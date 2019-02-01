--restricciones de integridad de tipo

CREATE DOMAIN temail
AS character varying(100)
CHECK(
VALUE ~ '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'
);

-- tablas
create table Guard (
ID serial not null,
DNI int not null,
Firstname text not null,
Lastname text not null,
Registrationdate date not null, -- ALTER TABLE GUARD ADD COLUMN Registrationdate DATE NOT NULL WITH DEFAULT CURRENT DATE;
Phone int null,
Gender boolean not null,
Email text null,
Birthdate date not null,
fechaAlta date not null,
fechaBaja date null,
PRIMARY KEY (ID)
);

create table Company(
ID serial not null,
Name text not null,
Address text not null,
Phone int null,
Registrationdate date not null,-- ALTER TABLE COMPANY ADD COLUMN Registrationdate DATE NOT NULL WITH DEFAULT CURRENT DATE;
Email temail null,
CUIT int not null,
fechaAlta date not null,
fechaBaja date null,
PRIMARY KEY (ID)
);

create table Turntype(
ID serial not null,
Name text not null,
timespan text not null,
PRIMARY KEY (ID)
);

create table Day (
ID serial not null,
Name text not null,
PRIMARY KEY (ID)
);

create table GuardNotificationType(
ID serial not null,
Description varchar not null,
PRIMARY KEY (ID)
);

create table CompanySchedule(
ID serial not null,
FK_Company int not null,
FK_Day int not null,
TurnType int not null,
PRIMARY KEY (ID),
FOREIGN KEY (FK_Company) REFERENCES Company(ID) on delete cascade,
FOREIGN KEY (FK_Day) REFERENCES Day(ID) on delete cascade,
FOREIGN KEY (TurnType) REFERENCES Turntype(ID) on delete cascade
);

create table GuardSchedule(
ID serial not null,
FK_Guard int not null,
FK_Day int not null,
TurnType int not null,
PRIMARY KEY (ID),
FOREIGN KEY (FK_Guard) REFERENCES Guard(ID) on delete cascade,
FOREIGN KEY (FK_Day) REFERENCES Day(ID) on delete cascade,
FOREIGN KEY (TurnType) REFERENCES Turntype(ID) on delete cascade
);

create table Turn(
ID serial not null,
FK_GuardSchedule int not null,
FK_CompanySchedule int not null,
TurnDate date not null,
fechaAlta date not null,
fechaBaja date null,
PRIMARY KEY (ID),
FOREIGN KEY (FK_GuardSchedule) REFERENCES GuardSchedule(ID) on delete cascade,
FOREIGN KEY (FK_CompanySchedule) REFERENCES CompanySchedule(ID) on delete cascade
);

create table GuardPreference(
ID serial not null,
FK_Guard int not null,
FK_guardNotificationType int not null,
Description varchar not null,
PRIMARY KEY (ID),
FOREIGN KEY (FK_guardNotificationType) REFERENCES GuardNotificationType(ID),
FOREIGN KEY (FK_Guard) REFERENCES Guard(ID) on delete cascade
);

create table Notification (
ID serial not null,
FK_Guard int not null,
SendDate date not null,
PRIMARY KEY (ID),
FOREIGN KEY (FK_Guard) REFERENCES Guard(ID) on delete cascade
);

create table USERS (
ID serial not null,
username varchar not null,
password varchar not null,
PRIMARY KEY (ID)
);

create table UserLog (
ID serial not null,
fechaIngreso date not null,
FK_users int not null,
PRIMARY KEY (ID),
FOREIGN KEY (FK_users) REFERENCES USERS(ID) on delete cascade
);