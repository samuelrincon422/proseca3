package com.proseca.app.controllers;

import com.proseca.app.controllers.api.EventoDeSaludApi;
import com.proseca.app.dto.EventoDeSaludDTO;
import com.proseca.app.entities.EventoDeSalud;
import com.proseca.app.services.interfaces.EventoDeSaludService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventoDeSaludController implements EventoDeSaludApi {

    private final EventoDeSaludService eventoDeSaludService;

    public EventoDeSaludController(EventoDeSaludService eventoDeSaludService) {
        this.eventoDeSaludService = eventoDeSaludService;
    }

    @Override
    public ResponseEntity<EventoDeSalud> registrar(EventoDeSaludDTO dto) {
        EventoDeSalud nuevo = eventoDeSaludService.registrar(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<EventoDeSalud>> listarTodos() {
        return new ResponseEntity<>(eventoDeSaludService.listarTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<EventoDeSalud>> listarPorAnimal(Integer animalId) {
        return new ResponseEntity<>(eventoDeSaludService.listarPorAnimal(animalId), HttpStatus.OK);
    }
}