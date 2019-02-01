/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;
import entities.Guard;
import entities.Turn;
import java.text.MessageFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author arguser
 */
public class SendMail {
    
    private static final String USER_NAME = "tpfinaltaller";  // GMail user name (just the part before "@gmail.com")
    private static final String PASSWORD = "taller123"; // GMail password

    public void SendMail(Guard guard, List<Turn> turns) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        String from = "tpfinaltaller@gmail.com";
        String pass = "taller123";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));

            String body;//"Hola " + guard.getFirstname()+ " " + guard.getLastname()+", le recordamos sus turnos para esta semana:";
            
              body = "<table style=\"width:651px;\">";
              body += "<tr style=\"background-color:#ffe27f; height:26;\">";
              body += "     <td colspan=\"6\" style=\"text-align:center;\">";
              body += MessageFormat.format("<table style=\"width: 100%;\"><tr style=\"font-family:verdana; font-size:11.6px; text-align:left\"><td style=\"width:50%\">{0}</td><td style=\"width:50%\">TURNOS A CUBRIR</td></tr></table>",guard.getLastname() + ", " + guard.getFirstname());
              body += "     </td>";
              body += "</tr>";
              body += "<tr style=\"background-color:#dcdcdc; height:22; font-size:11.6; font-family:verdana; text-align:center\">";
              body += "     <td style=\"padding:4px\">";
              body += "           DÍA";
              body += "     </td>";
              body += "     <td style=\"padding:4px\">";
              body += "           TURNO";
              body += "     </td>";
              body += "     <td style=\"padding:4px\">";
              body += "           HORARIO INICIO TURNO";
              body += "     </td>";
              body += "     <td style=\"padding:4px\">";
              body += "           HORARIO FIN TURNO";
              body += "     </td>";
              body += "     <td style=\"padding:4px\">";
              body += "           LUGAR";
              body += "     </td>";
              body += "</tr>";
            
            int rowNum = 0;
            for (Turn turn : turns) {
                rowNum++;
                String day = turn.getGuardschedule().getDay().getName();
                String turnName = turn.getGuardschedule().getTurntype().getName();
                String timespan = turn.getGuardschedule().getTurntype().getTimespan();
                String lugar = turn.getCompanyschedule().getCompany().getAddress();
                String rowColor = (rowNum % 2) != 0 ? "#ffffff" : "#ffe27f66";
                String row = MessageFormat.format("<tr style=\"font-family:verdana; background-color:{0}; height:22; font-size:11.6; text-align:center;\"> <td>{1}</td><td>{5}</td><td>{2}</td><td>{3}</td><td>{4}</td></tr>", rowColor, day,timespan.substring(0, 5),timespan.substring(8, 13), lugar,turnName);
                
                body += row;
                
            }
            
            body += "</table>";

            message.addRecipient(Message.RecipientType.TO, new InternetAddress((String) guard.getEmail()));
            message.setSubject("Notificación de Turno");
            message.setContent(body, "text/html");
            //message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}