package com.proseca.app.controllers.api;

import com.proseca.app.dto.ReproduccionDTO;
import com.proseca.app.entities.Reproduccion;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ReproduccionApi {

    @Operation(tags = {"Reproducción"}, summary = "Registrar evento de reproducción")
    @PostMapping(value = "/reproduccion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Reproduccion> registrar(@RequestBody ReproduccionDTO dto);

    @Operation(tags = {"Reproducción"}, summary = "Listar eventos de reproducción")
    @GetMapping(value = "/reproduccion", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Reproduccion>> listarTodos();

    @Operation(tags = {"Reproducción"}, summary = "Listar eventos de reproducción por animal")
    @GetMapping(value = "/reproduccion/animal/{animalId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Reproduccion>> listarPorAnimal(@PathVariable Integer animalId);
}
