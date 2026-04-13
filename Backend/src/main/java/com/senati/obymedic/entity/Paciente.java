package com.senati.obymedic.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

// @Entity le dice a Hibernate que esta clase representa una tabla en la BD
@Entity
// Indica el nombre exacto de tabla en MYSQL o MariaDB
@Table(name = "paciente")
public class Paciente {

    // @Id marca este campo como la clave primaria de la tabla
    // @Column(name="dni") indica el nombre exacto de la columna en mysql
    @Id
    @Column(name = "dni")
    private Integer dni;

    // nullable=false significa que este campo no puede estar vacio en la BD
    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultimaActualizacion;

    // GETTERS Y SETTERS
    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    // Metodos para auto-llenar fechas
    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
        ultimaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        ultimaActualizacion = LocalDateTime.now();
    }
}