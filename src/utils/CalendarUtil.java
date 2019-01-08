/*
 * Copyright (c) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.Lists;
import com.google.api.client.util.store.DataStoreFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import entities.Guard;
import entities.Turn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Yaniv Inbar
 */
public class CalendarUtil {

    private static final String APPLICATION_NAME = "Seguridad";

    /**
     * Directory to store user credentials.
     */
    private static final java.io.File DATA_STORE_DIR
            = new java.io.File(System.getProperty("user.dir"), "resources");

    /**
     * Global instance of the {@link DataStoreFactory}. The best practice is to
     * make it a single globally shared instance across your application.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static final List<String> SCOPES
            = Arrays.asList(CalendarScopes.CALENDAR);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (GeneralSecurityException | IOException t) {
            System.exit(1);
        }
    }

    /**
     * Authorizes the installed application to access user's protected data.
     */
    private static Credential authorize() throws Exception {

        String workingDir = System.getProperty("user.dir");

        // Reemplazar FileInputStream por el path al client_secrets.json
        InputStream in = new FileInputStream(workingDir + "\\resources\\client_secrets.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY,
                new InputStreamReader(in));
        if (clientSecrets.getDetails().getClientId().startsWith("Enter")
                || clientSecrets.getDetails().getClientSecret().startsWith("Enter ")) {
            System.out.println(
                    "Enter Client ID and Secret from https://code.google.com/apis/console/?api=calendar "
                    + "into calendar-cmdline-sample/src/main/resources/client_secrets.json");
            System.exit(1);
        }

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow
                = new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Calendar client service.
     *
     * @return an authorized Calendar client service
     * @throws IOException
     */
    public static com.google.api.services.calendar.Calendar
            getCalendarService() throws IOException, Exception {
        Credential credential = authorize();
        return new com.google.api.services.calendar.Calendar.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Adds events to Calendar
     *
     * @param events
     */
    public void addEvents(Guard guard, List<Turn> turns) {

        List<Event> events = Lists.newArrayList();
        turns.forEach(turn -> {
            Event event = new Event().setSummary(turn.getCompanyschedule().getCompany().getName() + ": Turno " + turn.getGuardschedule().getTurntype().getName())
                .setLocation(turn.getCompanyschedule().getCompany().getAddress())
                .setDescription("Turno a cubrir por " + turn.getGuardschedule().getGuard().getFirstname() + " "+ turn.getGuardschedule().getGuard().getLastname() + " para " + turn.getCompanyschedule().getCompany().getName());
                
            EventAttendee[] attendees = new EventAttendee[]{
            new EventAttendee().setEmail(turn.getGuardschedule().getGuard().getEmail())};
            event.setAttendees(Arrays.asList(attendees));

            String startTime = turn.getGuardschedule().getTurntype().getTimespan().substring(0, 5);
            String endTime = turn.getGuardschedule().getTurntype().getTimespan().substring(8, 13);
            
            Calendar cs = Calendar.getInstance();
            Calendar ce = Calendar.getInstance();
            cs.setTimeZone(TimeZone.getDefault());
            ce.setTimeZone(TimeZone.getDefault());
            cs.setFirstDayOfWeek(Calendar.MONDAY);
            cs.setTime(new Date());
            ce.setFirstDayOfWeek(Calendar.MONDAY);
            ce.setTime(new Date());
            
            cs.set(Calendar.DAY_OF_WEEK,turn.getGuardschedule().getDay().getId() == 7 ? 1 : turn.getGuardschedule().getDay().getId() + 1);
            ce.set(Calendar.DAY_OF_WEEK,turn.getGuardschedule().getDay().getId() == 7 ? 1 : turn.getGuardschedule().getDay().getId() + 1);
            
            cs.set(Calendar.HOUR_OF_DAY, Integer.valueOf(startTime.substring(0, 2)));
            cs.set(Calendar.MINUTE, Integer.valueOf(startTime.substring(3, 5)));
            EventDateTime edts = new EventDateTime();
            
            edts.setDateTime(new DateTime(cs.getTime()));
            
            ce.set(Calendar.HOUR_OF_DAY, Integer.valueOf(endTime.substring(0, 2)));
            ce.set(Calendar.MINUTE, Integer.valueOf(endTime.substring(3, 5)));
            EventDateTime edte = new EventDateTime();
            
            edte.setDateTime(new DateTime(ce.getTime()));
            
            event.setStart(edts);
            event.setEnd(edte);
            
            events.add(event);
        });
        try {
            com.google.api.services.calendar.Calendar service = getCalendarService();
            String calendarId = "primary";
            for (Event event : events) {
                event = service.events().insert(calendarId, event).execute();
                System.out.printf("Event created: %s\n", event.getHtmlLink());
            }
        } catch (Exception ex) {
            Logger.getLogger(CalendarUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listCalendars() {
        try {
            List<Event> events = Lists.newArrayList();
            com.google.api.services.calendar.Calendar service = getCalendarService();
            String calendarId = "primary";
                System.out.print(service.events().list(calendarId).execute());
        } catch (Exception ex) {
            Logger.getLogger(CalendarUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
