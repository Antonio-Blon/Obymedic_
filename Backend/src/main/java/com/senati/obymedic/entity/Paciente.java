package com.senati.obymedic.entity;

import jakarta.persistence.*;

// @Entity le dice a Hibernate que esta clase representa una tabla en la BD
@Entity
// Indica el nombre exacto de tabla en MYSQL o MariaDB
@Table(name = "pacientes")
public class Paciente {

    // @Id marca este campo como la clave primaria de la tabla
    // @GeneratedValue hace que el id se genere automaticamente (AutoIncrement)
    // @Column(name="id_paciente") indica el nombre exacto de la columna en mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    // nullable=false significa que este campo no puede estar vacio en la BD
    @Column(nullable = false)
    private String nombre_apellidos;

    // unique=true significa que no puede haber dos pacientes con el mismo DNI
    // length=8 limita el campo a 8 caracteres
    @Column(nullable = false, unique = true, length = 8)
    private String dni;

    // Sin anotaciones (@) extra: columna normal, puede ser nula
    private String telefono;
    private String direccion;
    private String distrito;
    private String provincia;

    private String fecha_nacimiento;
    private Integer edad;

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public void setNombre_apellidos(String nombre_apellidos) {
        this.nombre_apellidos = nombre_apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}