package com.senati.obymedic.controller;

import com.senati.obymedic.entity.Paciente;
import com.senati.obymedic.service.PacienteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Indica que esta clase maneja peticiones HTTP y devuelve JSON
@RestController
// Define la URL base de los endpoints
@RequestMapping("api/pacientes")
// Permite que el frontend consuma esta API
@CrossOrigin(origins = "*")

public class PacienteController {

    // Inyectamos el servicio
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    // GET /api/pacientes → devuelve todos los pacientes
    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listarTodos();
    }
}