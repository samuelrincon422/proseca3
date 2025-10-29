package com.proseca.app.controllers;

import com.proseca.app.controllers.api.FincaApi;
import com.proseca.app.entities.Finca;
import com.proseca.app.services.interfaces.FincaService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FincaController implements FincaApi {

    private final FincaService service;

    public FincaController(FincaService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<Finca> crear(Finca finca) {
        return new ResponseEntity<>(service.crear(finca), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Finca>> listarTodos() {
        return new ResponseEntity<>(service.listarTodos(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Finca> obtenerPorId(Integer id) {
        return new ResponseEntity<>(service.obtenerPorId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Finca> actualizar(Integer id, Finca finca) {
        return new ResponseEntity<>(service.actualizar(id, finca), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> eliminar(Integer id) {
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
