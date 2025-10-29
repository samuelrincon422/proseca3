package com.proseca.app.controllers.api;

import com.proseca.app.entities.Vacuna;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Vacuna", description = "Gestión de vacunas")
@RequestMapping("/api/vacuna")
public interface VacunaApi {

    @Operation(summary = "Crear una nueva vacuna")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Vacuna> crear(@RequestBody Vacuna vacuna);

    @Operation(summary = "Listar todas las vacunas")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Vacuna>> listarTodos();

    @Operation(summary = "Obtener una vacuna por su ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Vacuna> obtenerPorId(@PathVariable Integer id);

    @Operation(summary = "Actualizar una vacuna existente")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Vacuna> actualizar(@PathVariable Integer id, @RequestBody Vacuna vacuna);

    @Operation(summary = "Eliminar una vacuna por su ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Integer id);
}