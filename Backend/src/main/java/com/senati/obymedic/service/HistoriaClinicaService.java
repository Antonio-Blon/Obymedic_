package com.senati.obymedic.service;

import com.senati.obymedic.entity.HistoriaClinica;
import com.senati.obymedic.repository.HistoriaClinicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service indica que esta clase contiene la logica de negocio
@Service
public class HistoriaClinicaService {

    // Inyectamos el repositorio para acceder a la base de datos
    private final HistoriaClinicaRepository historiaClinicaRepository;

    // Constructor: Spring inyecta automaticamente el repositorio
    public HistoriaClinicaService(HistoriaClinicaRepository historiaClinicaRepository){
        this.historiaClinicaRepository = historiaClinicaRepository;
    }

    // Retorna la lista de todas las historias clinicas
    public List<HistoriaClinica> listarTodas() {
        return historiaClinicaRepository.findAll();
    }
}