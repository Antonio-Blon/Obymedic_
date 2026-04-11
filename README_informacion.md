# SISTEMA DE GESTION DE HISTORIAS CLINICAS - OBYMEDIC

[![TRELLO](https://img.shields.io/badge/TRELLO-KANBAN-blue?style=for-the-badge&logo=trello&logoColor=white)](https://trello.com/invite/b/69bc3ede73d188581baa1482/ATTI3f827d0ff18d1e9bfddfe0ef1a6bd47a27F9FC1E/proyecto-consultas-obymedic)
[![FIGMA](https://img.shields.io/badge/FIGMA-DISENO-red?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com/design/F0hS7gps6mz5811iBBZVr8/Entregable-01?node-id=1-2&t=1I4VFzDYAzfZAZIh-1)

---

## TRELLO

Mas info en [mi tablero de trello](https://trello.com/invite/b/69bc3ede73d188581baa1482/ATTI3f827d0ff18d1e9bfddfe0ef1a6bd47a27F9FC1E/proyecto-consultas-obymedic)

![TRELLO](recursos/programacion.png)

---

# Sistema de Gestion de Historias Clinicas - Obstetricia y Medicina

Sistema web para la gestion de registros de historiales medicos de Obstetricia

---

## Descripcion del negocio

| Campo | Informacion |
|-------|-------------|
| Nombre | Alber Einstein Muñoz de la flor |
| Consultorio Medico | Obymedic |
| RUC | 10431624163 |
| Especialidad | El consultorio brinda atencion medica general y especialmente de Obstetricia |

---

## Identificar el problema y solucion

### Problema

Actualmente el medico registra los historiales medicos de manera manual (en fisico), lo que genera:

- Perdida de tiempo al buscar informacion
- Riesgo de extravio de documentos
- Desorganizacion en los registros
- Dificultad para encontrar historiales por paciente
- Acumulacion de archivos fisicos

### Solucion tecnologica

Se desarrollara un Sistema Digital de Gestion de Historiales Medicos, el cual permitira:

- Registrar pacientes con su DNI
- Guardar multiples historiales asociados a un mismo DNI
- Implementar un filtro de busqueda por DNI
- Mostrar automaticamente los datos del paciente y fechas de atencion
- Almacenar la informacion en una base de datos digital

---

## Requerimientos Funcionales

| Requerimiento | Descripcion |
|---------------|-------------|
| Registrar paciente | El sistema debe permitir registrar pacientes utilizando su DNI |
| Guardar datos del paciente | El sistema debe almacenar nombre completo, edad, telefono y direccion del paciente |
| Registrar historial medico | El sistema debe permitir registrar un historial medico asociado al DNI del paciente |
| Guardar informacion medica | El historial debe incluir fecha de atencion, diagnostico, tratamiento y observaciones |
| Busqueda de paciente | El sistema debe permitir buscar pacientes mediante su DNI |
| Mostrar resultados | El sistema debe mostrar el nombre del paciente y las fechas de sus historiales medicos |
| Ver detalle del historial | El sistema debe mostrar el nombre del paciente y las fechas de sus historiales medicos |
| Editar historial medico | El sistema debe permitir modificar o actualizar la informacion del historial medico |

---

## Requerimientos No Funcionales

| Requerimiento | Descripcion |
|---------------|-------------|
| Facilidad de uso | El sistema debe tener una interfaz sencilla y facil de usar |
| Seguridad | El acceso al sistema debe realizarse mediante usuario y contrasena |
| Almacenamiento seguro | La informacion debe almacenarse en una base de datos segura |
| Rendimiento | El sistema debe responder a las busquedas en menos de 3 segundos |

---

## Stack completo

1. Trello = Gestion del proyecto (Kanban)
2. Draw.io = Diagrama ER + Diagrama de Clases
3. Figma = Wireframe + Diseno UI/UX
4. MySQL Workbench = Disenar y administrar BD
5. IntelliJ = Frontend (HTML, CSS, JS) + Backend (Spring Boot)
6. XAMPP = Servidor Tomcat para correr la app

---

## Tecnologias utilizadas

- Java 17
- Spring Boot 3
- MySQL 8
- HTML5, CSS3, JavaScript
- IntelliJ IDEA
- XAMPP (Tomcat)
- MySQL Workbench
- Figma (diseno UI/UX)
- Draw.io (diagramas)

---

## Estructura del proyecto

```
JavaWeb-GotaGota/
├── backend/          -> Spring Boot (Java)
│   ├── src/
│   ├── pom.xml
│   └── ...
├── frontend/         -> HTML, CSS, JS
│   ├── css/
│   ├── js/
│   └── interfaz.html
```

---

## Base de datos

El sistema cuenta con 2 tablas principales:

| Tabla | Descripcion |
|-------|-------------|
| PACIENTE | Consulta si el cliente tiene un registro previo |
| HISTORIAL_CLINICA | Registra el historial clinico y lo guarda en la base de datos |

### Diagrama Entidad-Relacion (DER)

![Diagrama Entidad Relacion](recursos/Diagrama_Entidad_Relacion.png)

### Modelo Relacional (MR)

![Modelo Relacional](recursos/Modelo_Relacional.png)

### Diagrama de Figma

Mas info en [Mi Diseno Figma](https://www.figma.com/design/F0hS7gps6mz5811iBBZVr8/Entregable-01?node-id=1-2&t=1I4VFzDYAzfZAZIh-1)

![FIGMA](recursos/figma.png)

### Script de Base de datos

```sql
CREATE DATABASE obymedic;
USE obymedic;

-- =========================
-- TABLA PACIENTES
-- =========================
CREATE TABLE pacientes (
    id_paciente BIGINT AUTO_INCREMENT PRIMARY KEY,
    
    nombre_apellidos VARCHAR(150) NOT NULL,
    dni VARCHAR(8) NOT NULL UNIQUE,
    
    telefono VARCHAR(20),
    direccion VARCHAR(150),
    distrito VARCHAR(100),
    provincia VARCHAR(100),

    fecha_nacimiento VARCHAR(20),
    edad INT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- =========================
-- TABLA CONSULTAS
-- =========================
CREATE TABLE consultas (
    id_consulta BIGINT AUTO_INCREMENT PRIMARY KEY,

    id_paciente BIGINT NOT NULL,

    fecha DATE,
    motivo VARCHAR(255),
    edad INT,

    pa VARCHAR(20),
    fc VARCHAR(20),
    fr VARCHAR(20),
    temperatura VARCHAR(20),
    peso DOUBLE,
    talla DOUBLE,
    spo2 VARCHAR(10),

    diagnostico TEXT,
    tratamiento TEXT,
    examenes_auxiliares TEXT,

    proxima_cita DATE,
    firma_sello VARCHAR(150),
    atencion_por VARCHAR(150),

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    -- RELACION CON PACIENTES
    CONSTRAINT fk_paciente
    FOREIGN KEY (id_paciente)
    REFERENCES pacientes(id_paciente)
    ON DELETE CASCADE
);
```

---

## Como correr el proyecto

### Requisitos previos

- Tener instalado IntelliJ IDEA
- Tener instalado XAMPP (para MySQL)
- Tener instalado MySQL Workbench
- Tener instalado JDK 21 o superior

### Backend

1. Abrir la carpeta `backend/` en IntelliJ IDEA
2. Configurar `application.properties` con los datos de MySQL
3. Iniciar XAMPP y activar MySQL
4. Ejecutar `GotagotaApplication.java`
5. El backend corre en: `http://localhost:8080`

### Frontend

1. Abrir la carpeta `frontend/` en VsCode
2. Abrir `index.html` con Live Server
3. El frontend se comunica con el backend via fetch()

> IMPORTANTE: El frontend y el backend corren por separado.
> El backend debe estar iniciado antes de abrir el frontend.

### Configuracion de base de datos

```properties
spring.application.name=obymedic

#CONEXION A MYSQL
spring.datasource.url=jdbc:mysql://localhost:3306/obymedic
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA / HIBERNATE
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# PUERTO
server.port=8080
```

---

## Autor

**Alber Einstein Muñoz de la flor** - Consultorio OBYMEDIC

---

Gracias por visitar este proyecto.
