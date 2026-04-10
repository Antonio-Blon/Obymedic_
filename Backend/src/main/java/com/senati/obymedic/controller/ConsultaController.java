package com.senati.obymedic.controller;

import com.senati.obymedic.entity.Consulta;
import com.senati.obymedic.service.ConsultaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//3 ANOTACIONES
//Indica que esta clase maneja peticiones HTTPS y DEVUELVE JSON
@RestController
// Define la URL Base de todos los END-POINT de esta clase
@RequestMapping("api/consultas")
// Esta anotacion permite que el front-end puede llamar a esta API
// Si no ponemos esto, el navegador bloquea las peticiones por politicas CORS
@CrossOrigin(origins = "*")

public class ConsultaController  {

    //DECLARAMOS UNA VARIABLE DEFINIDA
    // Inyectamos el servicio para acceder a la logica del negocio
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService){
        this.consultaService = consultaService;
    }

    //GET /api/consultas -> devuelve todas las consultas en formato JSON
    @GetMapping
    public List<Consulta> listar() {
        return consultaService.listarTodas();
    }
}