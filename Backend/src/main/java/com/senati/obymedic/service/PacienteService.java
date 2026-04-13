package com.senati.obymedic.service;

import com.senati.obymedic.entity.Paciente;
import com.senati.obymedic.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service indica que esta clase contiene la logica de negocio
@Service
public class PacienteService {

    // Inyectamos el repositorio para acceder a la base de datos
    private final PacienteRepository pacienteRepository;

    // Constructor: Spring inyecta automaticamente el repositorio
    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    // Retorna la lista de todos los pacientes
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    // ============================================
    // Guardar o actualizar un paciente
    // ============================================
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
}