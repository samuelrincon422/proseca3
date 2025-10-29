package com.proseca.app.controllers.api;

import com.proseca.app.dto.RegistroVacunacionRequestDTO;
import com.proseca.app.entities.RegistroVacunacion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Vacunación", description = "Gestión de registros de vacunación de animales")
@RequestMapping("/api/vacunacion")
public interface RegistroVacunacionApi {

    @Operation(summary = "Registrar vacunación para un animal")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RegistroVacunacion> registrar(@RequestBody RegistroVacunacionRequestDTO dto);

    @Operation(summary = "Listar todos los registros de vacunación")
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<RegistroVacunacion>> listarTodos();

    @Operation(summary = "Listar registros de vacunación por ID de animal")
    @GetMapping(value = "/animal/{animalId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<RegistroVacunacion>> listarPorAnimal(@PathVariable Integer animalId);
}
