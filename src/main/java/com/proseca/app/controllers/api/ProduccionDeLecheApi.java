package com.proseca.app.controllers.api;

import com.proseca.app.dto.ProduccionDeLecheDTO;
import com.proseca.app.entities.ProduccionDeLeche;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProduccionDeLecheApi {

    @Operation(tags = {"Producción de Leche"}, summary = "Registrar producción de leche")
    @PostMapping("/produccion-leche")
    ResponseEntity<ProduccionDeLeche> registrar(@RequestBody ProduccionDeLecheDTO dto);

    @Operation(tags = {"Producción de Leche"}, summary = "Listar toda la producción")
    @GetMapping("/produccion-leche")
    ResponseEntity<List<ProduccionDeLeche>> listarTodos();

    @Operation(tags = {"Producción de Leche"}, summary = "Listar producción por animal")
    @GetMapping("/produccion-leche/animal/{animalId}")
    ResponseEntity<List<ProduccionDeLeche>> listarPorAnimal(@PathVariable Integer animalId);
}
