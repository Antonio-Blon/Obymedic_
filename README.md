## TRELLO
Más info en [mi tablero de trello](https://trello.com/invite/b/69bc3ede73d188581baa1482/ATTI3f827d0ff18d1e9bfddfe0ef1a6bd47a27F9FC1E/proyecto-consultas-obymedic)
![TRELLO](recursos/progrmacion.png)
# Sistema de Gestión de Historias Clínicas Obstetricia y Medicina

Sistema web para la gestión de registros de historiales medicos de Obstetricia

## Descripcion del negocio
Nombre: Alber Einstein Muños de la flor <br>
Consultorio Médico: Obymedic <br>
RUC: 10431624163 <br>
El consultorio brinda atención médica general y especialmente de Obstetricia <br>


## Identificar el problema y solución
Problema: Actualmente el médico registra los historiales médicos de manera manual (en físico), lo que genera. <br>
•	Pérdida de tiempo al buscar información<br>
•	Riesgo de extravío de documentos<br>
•	Desorganización en los registros<br>
•	Dificultad para encontrar historiales por paciente<br>
•	Acumulación de archivos físicos<br>

Solucion tecnologica: Se desarrollará un Sistema Digital de Gestión de Historiales Médicos, el cual permitirá:
•	Registrar pacientes con su DNI. <br>
•	Guardar múltiples historiales asociados a un mismo DNI. <br>
•	Implementar un filtro de búsqueda por DNI. <br>
•	Mostrar automáticamente los datos del paciente y fechas de atención. <br>
•	Almacenar la información en una base de datos digital. <br>

 
## Requerimientos Funcionales
| Requerimiento | Descripcion |
|---|---|
| Registrar paciente | El sistema debe permitir registrar pacientes utilizando su DNI.|
| Guardar datos del paciente | El sistema debe almacenar nombre completo, edad, teléfono y dirección del paciente. |
| Registrar historial médico | El sistema debe permitir registrar un historial médico asociado al DNI del paciente. |
| Guardar información médica | El historial debe incluir fecha de atención, diagnóstico, tratamiento y observaciones. |
| Búsqueda de paciente | El sistema debe permitir buscar pacientes mediante su DNI. |
| Mostrar resultados | El sistema debe mostrar el nombre del paciente y las fechas de sus historiales médicos. |
| Ver detalle del historial | El sistema debe mostrar el nombre del paciente y las fechas de sus historiales médicos.   |
| Editar historial médico | El sistema debe permitir modificar o actualizar la información del historial médico. |
 
## Requerimientos No Funcionales
 
| Requerimiento | Descripcion |
|---|---|
| Facilidad de uso | El sistema debe tener una interfaz sencilla y fácil de usar. |
| Seguridad | El acceso al sistema debe realizarse mediante usuario y contraseña. |
| Almacenamiento seguro | La información debe almacenarse en una base de datos segura. |
| Rendimiento | El sistema debe responder a las búsquedas en menos de 3 segundos. |
## Stack completo
1. Trello             = Gestión del proyecto (Kanban)
2. Draw.io            = Diagrama ER + Diagrama de Clases
3. Figma              = Wireframe + Diseño UI/UX
4. MySQL Workbench    = Diseñar y administrar BD
5. IntelliJ           = Frontend (HTML,CSS,JS) + Backend (Spring Boot)
6. XAMPP              = Servidor Tomcat para correr la app

## Tecnologias utilizadas
- Java 17
- Spring Boot 3
- MySQL 8
- HTML5, CSS3, JavaScript
- IntelliJ IDEA
- XAMPP (Tomcat)
- MySQL Workbench
- Figma (diseño UI/UX)
- Draw.io (diagramas)


## Base de datos
 
El sistema cuenta con 4 tablas principales:
 
| Tabla | Descripcion |
|---|---|
| PACIENTE | Consulta si el cliente tiene un registro previo. |
| HISTORIAL_CLINICA | Registra el historial clinico y lo guarda en la base de datos |


  
### Diagrama Entidad-Relacion (DER)
![Diagrama Entidad Relacion](recursos/Diagrama_Entidad_Relacion.png)
 
### Modelo Relacional (MR)
![Modelo Relacional](recursos/Modelo_Relacional.png)



### DIAGRAMA DE FIGMA
<iframe style="border: 1px solid rgba(0, 0, 0, 0.1);" width="800" height="450" src="https://embed.figma.com/design/BXoCcKRR9FjiXnO5TxFhuK/Proyecto-Senati?node-id=1-7&embed-host=share" allowfullscreen></iframe>

 <iframe width="560" height="315" src="https://www.youtube.com/embed/fxKnmW0QxHQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


