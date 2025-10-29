package com.proseca.app.controllers;

import com.proseca.app.controllers.api.ReproduccionApi;
import com.proseca.app.dto.ReproduccionDTO;
import com.proseca.app.entities.Reproduccion;
import com.proseca.app.services.interfaces.ReproduccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReproduccionController implements ReproduccionApi {

    private final ReproduccionService service;

    public ReproduccionController(ReproduccionService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Reproduccion> registrar(ReproduccionDTO dto) {
        Reproduccion saved = service.registrar(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Reproduccion>> listarTodos() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Reproduccion>> listarPorAnimal(Integer animalId) {
        return new ResponseEntity<>(service.listarPorAnimal(animalId), HttpStatus.OK);
    }
}
