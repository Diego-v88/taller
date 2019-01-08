# Taller de Programación 2013 - UTN-FRCU Práctico Final
## Introducción
El trabajo práctico final consta de la realización de una aplicación administradora de turnos de vigilancia. La aplicación deberá ser capaz de determinar asignaciones de un conjunto de cuidadores a turnos basados en determinadas restricciones. Deberá también generar notificaciones a los cuidadores asignados y poseer reportes para determinar el pago a dichos usuarios.
## Requerimientos funcionales
### General
La interfaz del usuario debe ser consistente y no deberá tener errores de interacción ni de visualización de información. El programa deberá ser fácil de usar e intuitivo. 

### Administración de cuidadores.
La aplicación deberá ser capaz de dar de alta, modificar, eliminar y visualizar cuidadores los cuales se encuentran disponibles para asignar guardias. La información deberá ser persistida internamente por el programa, siendo los principales datos los siguientes:

* Nombre: Nombre del cuidador.
* DNI: Documento de identidad.
* Teléfono: Teléfono de contacto.
* Correo: Cuenta de correo electrónico. Dato opcional.
* Horario disponible: Rango horario en que puede realizar vigilancias. Por simplificación se asume que el rango horario aplica para todos los días, hábiles o no.
* Notificaciones automáticas: Se puede establecer los tipos de notificaciones que el usuario desea recibir. Las notificaciones pueden ser: por correo electrónico o por evento de calendario Google.

Nota: El relevamiento de información detectó que los cuidadores jóvenes utilizan asiduamente la aplicación Calendar de Google, los de mediana edad prefieren que sean notificados vía mail, y los de mayor edad solamente quieren que sean avisados vía telefónica. Por ello el operador de la aplicación solamente debe notificar manualmente (por llamado telefónico) a los usuarios que no posea notificaciones automáticas configuradas.

### Administración de Entidades.
Se debe poder administrar los datos de las entidades las cuales se debe dar el servicio de vigilancia, indicando el rango horario y el período de tiempo que la entidad desea el servicio.

### Asignación de vigilancias.
La aplicación debe ser capaz de realizar asignaciones de manera automática de cuidadores a entidades, las cuales se hacen una vez por semana mediante una acción del operador de la aplicación.

Se deben considerar para realizar la asignación las siguientes reglas:

* Deben coincidir el horario disponible del cuidador con el rango horario de la vigilancia en la
entidad.
* Por reglamentaciones internas de la organización ningún cuidador debe sobrepasar las 8 hs de
vigilancia continua, ni sobrepasar las 40 hs semanales de trabajo.
* El cuidador debe tener un día entero de descanso después de tres jornadas laborales como
máximo.
* Ningún cuidador debe trabajar menos de 20 hs semanales.

Una vez realizada la asignaciones, la aplicación solicitará confirmación al operador para asentar dichas asignaciones. En dicho proceso se enviarán las notificaciones a los cuidadores de forma automática si poseen configuradas las notificaciones por calendario o correo.

Si el cuidador posee solamente configurada la notificación por llamado telefónico debe evidenciarse en la pantalla dicha condición, de forma que el operador de la aplicación pueda realizar los llamados telefónicos.

### Reportes.
Se debe poder acceder al listado y detalle de asignaciones semanales realizadas anteriormente, con el objetivo de tener constancia de los trabajos realizados. Detalles y otros requerimientos.

Nota: Este documento plantea el comportamiento básico que debe tener la aplicación. Si el alumno no encuentra en este documento definición sobre alguna parte de un requerimiento necesario, puede tomar la decisión definir o refinar dichos requerimientos. Este es el caso de las interfaces de usuario, las cuales no están definidas, el alumno debe determinarlas de acuerdo a su parecer con la condición que no contradigan los requerimientos aquí planteados.
El alumno puede extender los requerimientos aquí expuestos si así lo desea.

## Requerimientos no funcionales

* El programa deberá tener una interfaz gráfica desarrollada en Swing, integrando los
conocimientos y técnicas adquiridos durante la cátedra. La incorporación de conocimientos
no adquiridos durante la cátedra serán también bienvenidos.
* Para el acceso a fuentes de calendario se puede utilizarlos servicios de Google, la librería y
documentación puede obtenerse desde la siguiente dirección.
* Para el acceso a fuentes de correo Java SE no provee la funcionalidad de forma estándar, por
ello se debe utilizar librerías externas. Se sugiere utilizar las librerías JavaMail de Oracle
que forman parte de la distribución J2EE.
* El cliente ha manifestado la intención de que próximamente en una posterior versión de la
aplicación tenga la posibilidad de que realicen notificaciones por SMS y por Calendario de
Facebook y Hotmail, por lo que la aplicación deberá estar preparada para incorporar
de una forma fácil y rápida otros tipos de notificaciones.
* El programa deberá persistir las configuraciones en una base de datos relacional. Se espera
que en un futuro puedan configurarse persistencia en distintos gestores de BBDD u otras
formas de persistencia por lo que el software debe estar preparado para ello.
* El programa deberá estar correctamente comentado y documentado en formato JavaDoc.

### Librerias
* Google Calendar API https://developers.google.com/google-apps/calendar/
* JavaMail - Biblioteca Java de correo y mensajería http://www.oracle.com/technetwork/java/javamail/index.html

## Entregables
Los entregables del trabajo final consisten en:

* Código ejecutable.
* Código Fuente.
* Documentación en formato JavaDoc.
* Diagrama de clases y paquetes en formato digital de alguna herramienta UML conocida.
* Guía de Instalación y Uso del programa.

Importante : Se debe entregar los mencionados elementos en un CD.

## Evaluación
Los puntos a evaluar del trabajo práctico final son el uso de buenas técnicas de desarrollo y
documentación, legibilidad del código, utilización correcta del lenguaje y finalmente la resolución
empleada para satisfacer los requerimientos.
Se deberá realizar una defensa grupal e individual del trabajo en el momento de la entrega, en donde
los alumnos deberán explicar la solución empleada y responder a preguntas de forma individual del
docente. Si bien las tareas de codificación pueden dividirse dentro del grupo, cada integrante debe
conocer y comprender de forma completa el desarrollo ya que cualquier integrante tiene que poder
responder cualquier pregunta sobre la aplicación.
