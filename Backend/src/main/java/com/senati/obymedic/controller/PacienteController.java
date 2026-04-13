package com.senati.obymedic.controller;

import com.senati.obymedic.entity.Paciente;
import com.senati.obymedic.service.PacienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//3 ANOTACIONES
//Indica que esta clase maneja peticiones HTTPS y DEVUELVE JSON
@RestController
// Define la URL Base de todos los END-POINT de esta clase
@RequestMapping("api/pacientes")
// Esta anotacion permite que el front-end puede llamar a esta API
// Si no ponemos esto, el navegador bloquea las peticiones por politicas CORS
@CrossOrigin(origins = "*")

public class PacienteController {
    //DECLARAMOS UNA VARIABLE DEFINIDA
    // Inyectamos el servicio para acceder a la logica del negocio
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    //GET /api/pacientes -> devuelve todos los pacientes en formato JSON
    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listarTodos();
    }

    // ============================================
    // POST /api/pacientes -> guarda un nuevo paciente
    // ============================================
    @PostMapping
    public Paciente guardar(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }
}