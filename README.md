# La Plataforma Historial de Equipos

## Proyecto Final: Ciclos de Vida de Desarrollo de Software 2020-2. 

## Dicipulos del Maestro Miguelito


- Miguel Angel Rodriguez Siachoque (Team Developer)
- James Alexander Torres Segura (Team Developer)
- Daniel Santiago Ducuara Ardila (Team Developer)

![](/src/main/webapp/img/Logo.png)

## Tutores

- Julián Mauricio Velazco Briceño (Product Owner)
- Oscar David Ospina Rodriguez (Product Owner)

# Descripción del producto:

## *Descripción general.*

La Plataforma Historial de Equipos, es una herramienta donde el personal del laboratorio de informática (LabInfo) pertenecientes a la decanatura de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito, pueden registrar los laboratorio, equipos y elementos de cada equipo, junto con las novedades que se realizan a cada uno de estos. 
El sistema, más allá de facilitar el registro de los equipos y novedades, es una valiosa base de conocimiento donde el personal del laboratorio, puede revisar el histórico de novedades que se le han realizado a cada elemento a través del tiempo durante todo su ciclo de vida útil. 
El personal administrativo del laboratorio puede crear laboratorios, equipos y elementos, asociar unos a otros y registrar novedades para cada uno; además de tener una variedad de reportes que les permitirá tener el control administrativo de estos implementos.

# *Manual de usuario:*

- Iniciamos nuestro recorrido en nuestra vista de inicio de sesion en la cual simplemtente ingresaremos con nuestro usuario y contraseña para iniciar a usar nuestros servicios, debemos tener en cuenta que nuestros usuarios y contraseñas seran suministrados y permaneceran en la base de datos solo estos usuarios pueden entrar a nuestra plataforma de servicios.

![](/src/main/webapp/img/1.PNG)

- Dicho lo anterior si tratamos de ingresar con datos inexistentes en la base de datos se nos rechazara nuestra solicitud de acceso. 

![](/src/main/webapp/img/2.PNG)

- Una vez dentro de nuestra plataforma veremos una interfaz sencilla donde se mostrara todos los servicios ofrecidos como lo son equipos, laboratorios, elementos y novedades como tambien en la parte superior derecha se encuentra un boton el cual permite finalizar sesion.

![](/src/main/webapp/img/4.PNG)

- Al ingresar al apartado de Equipos tendremos varias funcionalidades como:

   1. Registrar equipo: esta funcionalidad nos ayudara a registrar un equipo con solo la ip del equipo y su informacion.
   2. Consultar equipos: esta funcionalidad consulta los equipos que se encuentran registrados.
   3. Exportar equipos: esta funcionalidad permite exportar en forma de archivo la consulta de equipos registrados.
  
  ademas de esto podemos volver a la pagina principal para seguir usando el resto de nuestros servicios.
  
![](/src/main/webapp/img/4.PNG)
  
 - Al ingresar al apartado de Elementos obtendremos las siguientes funcionalidades como lo son:
  
   1. Registrar elemento: esta funcionalidad nos ayudara a registrar un elemento de un laboratorio como mouse, teclado, torre o monitor ademas necesitaremos su marca.
   2. Consultar elementos: esta funcionalidad consulta los elementos que se encuentran registrados.
   3. Exportar elementos: esta funcionalidad permite exportar en forma de archivo la consulta de elementos registrados.
   4. Asociar elemento: esta funcionalidad permite Asociar el elemento con un equipo en particular.
  
  ademas de esto podemos volver a la pagina principal para seguir usando el resto de nuestros servicios.
  
![](/src/main/webapp/img/4.PNG)

- Al ingresar al apartado de Laboratorios tendremos varias funcionalidades como:

   1. Registrar Laboratorio: esta funcionalidad nos ayudara a registrar un Laboratorio con solo su nombre.
   2. Consultar Laboratorios: esta funcionalidad consulta los Laboratorios que se encuentran registrados.
   3. Exportar Laboratorios: esta funcionalidad permite exportar en forma de archivo la consulta de Laboratorios registrados.
  
  ademas de esto podemos volver a la pagina principal para seguir usando el resto de nuestros servicios.
  
  ![](/src/main/webapp/img/4.PNG)
  
  - Al ingresar al apartado de Novedades tendremos varias funcionalidades como:

  1. Consultar Novedades: esta funcionalidad consulta las Novedades que se encuentran registradas.
  2. Exportar Novedades: esta funcionalidad permite exportar en forma de archivo la consulta de Novedades registradas.
    
  ademas de esto podemos volver a la pagina principal para seguir usando el resto de nuestros servicios.
  
    ![](/src/main/webapp/img/4.PNG)
  
# *Arquitectura y Diseño detallado:*

Modelo E-R.

![](diseño/md.png)

Diagrama de clases

![](diseño/bd.jpeg)

# *Descripción de la arquitectura y tecnología usadas durante el proyecto:*

Durante la elaboracion del proyecto logramos dar uso en:

- Capa de aplicación:
  En esta capa usamos Google guice, apache shiro y maven de tal manera que desde el inicio de sesion hasta las consultas se lograran realizar con facilidad
  y agilidad para tener un codigo eficiente y limpio.
  ![](/src/main/webapp/img/shiro.png)

- Capa de presentación
  En esta capa usamos primefaces y JSF este uso nos dara beneficios en la facilididad de la logica usada durante el proceso de visualizacion desde hacer mas agradable
  las vistas hasta realizar y mostrar de manera eficiente los resultados de las consultas.
  ![](/src/main/webapp/img/jsf.jpg)

- Capa de persistencia
  En esta capa usamos MyBatis y una base de datos PostgreSQL los cuales nos dara ese cambio y manejo de informacion provenientes de la base de datos lo cual nos dara una mayor   facilidad en el uso de los elementos obtenidos durante las consultas.
  ![](/src/main/webapp/img/sql.jpg)

## sistema de integración continua Circle Ci
[![CircleCI](https://circleci.com/gh/PDSW-ECI/base-proyectos.svg?style=svg)](https://app.circleci.com/pipelines/github/20202-PROYCVDS-LOS-DISCIPULOS-DE-MIGUE/MAESTRO-MIGUELITO)

## Enlace de la Pagina Web en Heroku
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://los-discipulos-de-miguelito.herokuapp.com/Login.xhtml)


# *Descripción del proceso:*

Integrantes.

Miguel Angel Rodriguez Siachoque encargado de la implementacion de las VIEWS y BACKEN
James Alexander Torres Segura encargado de la implementacion BACKEN
Daniel Santiago Ducuara Ardila encargado de la implementacion BD y BACKEN


## Enlace Taiga
https://tree.taiga.io/project/jamestorres99-historial-de-equipos-labinfo/backlog

## descripción de la Metodología.

Usamos durante estas ultimas semanas se realizo el desarrollo del proyecto por medio de Metodologia ágil SCRUM donde por medio de tres SPRINTS cada uno con un valor aproximado de dos semanas en donde se avanzo con el desarrollo y producion del proyecto.

![](/src/main/webapp/img/a.png)

## backlog del proyecto
A continuacion veremos el avance obtenido durante el tiempo reglamentario de cada SPRINT.

![](/src/main/webapp/img/back.PNG)

# Sprints

## Sprint 1
En el primer sprint planteamos nuestros objetivos los cuales logramos ir solucionando pero llegamos a la parte de implementación de Apache shiro el cual nos caso no unos si no 
muchos problemas por lo cual nuestro ritmo de desarrollo bajo considerablemente.

### sprint-backlog
![](/src/main/webapp/img/sp1.PNG)

### sprint-burndown chart
![](/src/main/webapp/img/back1.PNG)

## Sprint 2
En el segundo sprint logramos cumplir muy pocas de las metas propuestas debido a las fallas frecuentes en la asistencia de mi compañero por problemas personales lo cual nos obligo a bajar el tiempo de desarrollo del sprint.
### sprint-backlog
![](/src/main/webapp/img/sp2.PNG)

### sprint-burndown chart
![](/src/main/webapp/img/back2.PNG)

## Sprint 3
En el tercer sprint logramos terminar mas del 80% del desarrollo del proyecto aunque no se evidencie en el respectivo backlog debido a que logramos culminarlo despues del tiempo propuesto donde nuestro mayor desafio fueron la implementacion del exportar documento y la implementación de las graficas.
### sprint-backlog
![](/src/main/webapp/img/sp3.PNG)

### sprint-burndown chart
![](/src/main/webapp/img/back3.PNG)

# Reporte de análisis estático de código
## Codacy
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/9106912acf4e42f38eef7f27eb0c8522)](https://app.codacy.com/gh/20202-PROYCVDS-LOS-DISCIPULOS-DE-MIGUE/MAESTRO-MIGUELITO/dashboard)
