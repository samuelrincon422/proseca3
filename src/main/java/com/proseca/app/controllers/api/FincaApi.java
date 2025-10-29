package com.proseca.app.controllers.api;

import com.proseca.app.entities.Finca;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Finca", description = "Gestión de fincas")
@RequestMapping("/api/finca")
public interface FincaApi {

    @Operation(summary = "Crear una nueva finca")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Finca> crear(@RequestBody Finca finca);

    @Operation(summary = "Listar todas las fincas")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Finca>> listarTodos();

    @Operation(summary = "Obtener una finca por su ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Finca> obtenerPorId(@PathVariable Integer id);

    @Operation(summary = "Actualizar una finca existente")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Finca> actualizar(@PathVariable Integer id, @RequestBody Finca finca);

    @Operation(summary = "Eliminar una finca por su ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Integer id);
}