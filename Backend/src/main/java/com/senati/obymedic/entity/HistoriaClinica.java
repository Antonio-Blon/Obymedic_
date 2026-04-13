package com.senati.obymedic.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// @Entity le dice a Hibernate que esta clase representa una tabla en la BD
@Entity
// Indica el nombre exacto de tabla en MYSQL o MariaDB
@Table(name = "historia_clinica")
public class HistoriaClinica {

    // @Id marca este campo como la clave primaria de la tabla
    // @GeneratedValue hace que el id se genere automaticamente (AutoIncrement)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Integer idHistoria;

    // @Column(name="dni") indica el nombre exacto de la columna en mysql
    // nullable=false significa que este campo no puede estar vacio
    @Column(name = "dni", nullable = false)
    private Integer dni;

    @Column(name = "fecha_consulta", updatable = false)
    private LocalDateTime fechaConsulta;

    @Column(name = "diagnostico", length = 500)
    private String diagnostico;

    @Column(name = "tratamiento", length = 500)
    private String tratamiento;

    @Column(name = "observaciones", length = 500)
    private String observaciones;

    // Relacion con Paciente (Muchas historias clinicas pertenecen a un paciente)
    @ManyToOne
    @JoinColumn(name = "dni", insertable = false, updatable = false)
    private Paciente paciente;

    // GETTERS Y SETTERS
    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDateTime getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDateTime fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Metodo para auto-llenar fecha_consulta
    @PrePersist
    protected void onCreate() {
        fechaConsulta = LocalDateTime.now();
    }
}