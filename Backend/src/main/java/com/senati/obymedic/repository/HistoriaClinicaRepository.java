package com.senati.obymedic.repository;

// IMPORTAMOS DRIVERS, METODOS
import com.senati.obymedic.entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// Anotacion @Repository INTERFAZ como la capa de acceso a la base de datos
@Repository
public interface HistoriaClinicaRepository extends JpaRepository<HistoriaClinica, Integer> {

    // Metodo para buscar historias clinicas por DNI del paciente
    List<HistoriaClinica> findByDni(Integer dni);

    // Metodo para buscar una historia clinica por ID
    Optional<HistoriaClinica> findByIdHistoria(Integer idHistoria);

    // JpaRepository ya tiene todo lo basico (guardar, eliminar, listar, etc.)
}