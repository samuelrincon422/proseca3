package com.proseca.app.controllers;

import com.proseca.app.controllers.api.AnimalApi;
import com.proseca.app.entities.Animal;
import com.proseca.app.services.interfaces.AnimalService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AnimalController implements AnimalApi {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Animal> crear(Animal animal) {
        return new ResponseEntity<>(service.crear(animal), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Animal>> listarTodos() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Animal> obtenerPorId(Integer id) {
        return new ResponseEntity<>(service.obtenerPorId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Animal> actualizar(Integer id, Animal animal) {
        return new ResponseEntity<>(service.actualizar(id, animal), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> eliminar(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
