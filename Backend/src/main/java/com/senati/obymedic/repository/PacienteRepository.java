package com.senati.obymedic.repository;

// IMPORTAMOS DRIVERS, METODOS
import com.senati.obymedic.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// Anotacion @Repository INTERFAZ como la capa de acceso a la base de datos
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    // Metodo para buscar paciente por DNI
    Optional<Paciente> findByDni(Integer dni);

    // JpaRepository ya tiene todo lo basico (guardar, eliminar, listar, etc.)
}
