package com.senati.obymedic.controller;

import com.senati.obymedic.entity.HistoriaClinica;
import com.senati.obymedic.service.HistoriaClinicaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//3 ANOTACIONES
//Indica que esta clase maneja peticiones HTTPS y DEVUELVE JSON
@RestController
// Define la URL Base de todos los END-POINT de esta clase
@RequestMapping("api/historias-clinicas")
// Esta anotacion permite que el front-end puede llamar a esta API
// Si no ponemos esto, el navegador bloquea las peticiones por politicas CORS
@CrossOrigin(origins = "*")

public class HistoriaClinicaController {
    //DECLARAMOS UNA VARIABLE DEFINIDA
    // Inyectamos el servicio para acceder a la logica del negocio
    private final HistoriaClinicaService historiaClinicaService;

    public HistoriaClinicaController(HistoriaClinicaService historiaClinicaService){
        this.historiaClinicaService = historiaClinicaService;
    }

    //GET /api/historias-clinicas -> devuelve todas las historias clinicas en formato JSON
    @GetMapping
    public List<HistoriaClinica> listar() {
        return historiaClinicaService.listarTodas();
    }

    // POST /api/historias-clinicas -> guarda una nueva historia clinica
    @PostMapping
    public HistoriaClinica guardar(@RequestBody HistoriaClinica historiaClinica) {
        return historiaClinicaService.guardar(historiaClinica);
    }

    // GET /api/historias-clinicas/{id} -> buscar por ID
    @GetMapping("/{id}")
    public HistoriaClinica buscarPorId(@PathVariable Integer id) {
        return historiaClinicaService.buscarPorId(id);
    }

    // DELETE /api/historias-clinicas/{id} -> eliminar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        if (historiaClinicaService.existsById(id)) {
            historiaClinicaService.eliminar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
