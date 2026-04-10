package com.senati.obymedic.repository;

import com.senati.obymedic.entity.Consulta;
import com.senati.obymedic.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // Listar todas las consultas de un paciente
    List<Consulta> findByPaciente(Paciente paciente);
}