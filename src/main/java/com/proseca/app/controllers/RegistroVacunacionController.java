package com.proseca.app.controllers;

import com.proseca.app.controllers.api.RegistroVacunacionApi;
import com.proseca.app.dto.RegistroVacunacionRequestDTO;
import com.proseca.app.entities.RegistroVacunacion;
import com.proseca.app.services.interfaces.RegistroVacunacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RegistroVacunacionController implements RegistroVacunacionApi {

    private final RegistroVacunacionService service;

    public RegistroVacunacionController(RegistroVacunacionService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<RegistroVacunacion> registrar(RegistroVacunacionRequestDTO dto) {
        RegistroVacunacion saved = service.registrarVacunacion(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<RegistroVacunacion>> listarTodos() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<RegistroVacunacion>> listarPorAnimal(Integer animalId) {
        return new ResponseEntity<>(service.listarPorAnimal(animalId), HttpStatus.OK);
    }
}

