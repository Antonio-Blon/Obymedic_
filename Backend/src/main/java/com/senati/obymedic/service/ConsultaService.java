package com.senati.obymedic.service;

import com.senati.obymedic.entity.Consulta;
import com.senati.obymedic.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//Importamos la anotacion @service
// Esto es la capa de la logica de negocio, aqui van las validaciones, calculos, etc.
@Service
public class ConsultaService {

    //Inyectamos el repositorio para poder acceder a la base de datos
    private final ConsultaRepository consultaRepository;

    //Constructor: Spring inyecta automaticamente el repositorio
    public ConsultaService(ConsultaRepository consultaRepository){
        this.consultaRepository = consultaRepository;
    }

    //Retorna o recive la lista de todas las consultas
    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }
}