package com.proseca.app.controllers.api;

import com.proseca.app.entities.Animal;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import java.util.List;

@Tag(name = "Animal", description = "Gestión de animales")
@RequestMapping("/api/animal")
public interface AnimalApi {





    @Operation(summary = "Crear un nuevo animal")
    @PostMapping(value = "/Insertar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Animal> crear(@RequestBody Animal animal);

    @Operation(summary = "Listar todos los animales")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Animal>> listarTodos();

    @Operation(summary = "Obtener un animal por su ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Animal> obtenerPorId(@PathVariable Integer id);

    @Operation(summary = "Actualizar un animal existente")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Animal> actualizar(@PathVariable Integer id, @RequestBody Animal animal);

    @Operation(summary = "Eliminar un animal por su ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Integer id);
}
