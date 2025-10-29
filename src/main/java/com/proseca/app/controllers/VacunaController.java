package com.proseca.app.controllers;

import com.proseca.app.controllers.api.VacunaApi;
import com.proseca.app.entities.Vacuna;
import com.proseca.app.services.interfaces.VacunaService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class VacunaController implements VacunaApi {

    private final VacunaService service;

    public VacunaController(VacunaService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Vacuna> crear(Vacuna vacuna) {
        return new ResponseEntity<>(service.crear(vacuna), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Vacuna>> listarTodos() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vacuna> obtenerPorId(Integer id) {
        return new ResponseEntity<>(service.obtenerPorId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Vacuna> actualizar(Integer id, Vacuna vacuna) {
        return new ResponseEntity<>(service.actualizar(id, vacuna), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> eliminar(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
