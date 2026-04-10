package com.senati.obymedic.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

// @Entity le dice a Hibernate que esta clase representa una tabla en la BD
@Entity
// Indica el nombre exacto de tabla en MYSQL o MariaDB
@Table(name = "consultas")
public class Consulta {

    // @Id marca este campo como la clave primaria de la tabla
    // @GeneratedValue hace que el id se genere automaticamente (AutoIncrement)
    // @Column(name="id_consulta") indica el nombre exacto de la columna en mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consulta")
    private Long id;

    // @ManyToOne indica que muchas consultas pertenecen a un paciente
    // @JoinColumn define la clave foranea en la tabla consultas
    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    // Datos de la consulta
    private LocalDate fecha;
    private String motivo;
    private Integer edad;

    // Examen físico
    private String pa;
    private String fc;
    private String fr;
    private String temperatura;
    private Double peso;
    private Double talla;
    private String spo2;

    // Evaluación médica
    private String diagnostico;
    private String tratamiento;
    private String examenes_auxiliares;

    // Otros datos
    private LocalDate proxima_cita;
    private String firma_sello;
    private String atencion_por;

    // Campos de control de tiempo (TIMESTAMP en la BD)
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getTalla() {
        return talla;
    }

    public void setTalla(Double talla) {
        this.talla = talla;
    }

    public String getSpo2() {
        return spo2;
    }

    public void setSpo2(String spo2) {
        this.spo2 = spo2;
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

    public String getExamenes_auxiliares() {
        return examenes_auxiliares;
    }

    public void setExamenes_auxiliares(String examenes_auxiliares) {
        this.examenes_auxiliares = examenes_auxiliares;
    }

    public LocalDate getProxima_cita() {
        return proxima_cita;
    }

    public void setProxima_cita(LocalDate proxima_cita) {
        this.proxima_cita = proxima_cita;
    }

    public String getFirma_sello() {
        return firma_sello;
    }

    public void setFirma_sello(String firma_sello) {
        this.firma_sello = firma_sello;
    }

    public String getAtencion_por() {
        return atencion_por;
    }

    public void setAtencion_por(String atencion_por) {
        this.atencion_por = atencion_por;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}