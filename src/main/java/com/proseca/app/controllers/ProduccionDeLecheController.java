package com.proseca.app.controllers;

import com.proseca.app.controllers.api.ProduccionDeLecheApi;
import com.proseca.app.dto.ProduccionDeLecheDTO;
import com.proseca.app.entities.ProduccionDeLeche;
import com.proseca.app.services.interfaces.ProduccionDeLecheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProduccionDeLecheController implements ProduccionDeLecheApi {

    private final ProduccionDeLecheService produccionDeLecheService;

    public ProduccionDeLecheController(ProduccionDeLecheService produccionDeLecheService) {
        this.produccionDeLecheService = produccionDeLecheService;
    }

    @Override
    public ResponseEntity<ProduccionDeLeche> registrar(ProduccionDeLecheDTO dto) {
        return new ResponseEntity<>(produccionDeLecheService.registrar(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProduccionDeLeche>> listarTodos() {
        return new ResponseEntity<>(produccionDeLecheService.listarTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ProduccionDeLeche>> listarPorAnimal(Integer animalId) {
        return new ResponseEntity<>(produccionDeLecheService.listarPorAnimal(animalId), HttpStatus.OK);
    }
}