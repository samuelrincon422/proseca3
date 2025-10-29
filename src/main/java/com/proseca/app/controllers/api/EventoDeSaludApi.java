package com.proseca.app.controllers.api;

import com.proseca.app.dto.EventoDeSaludDTO;
import com.proseca.app.entities.EventoDeSalud;
import com.proseca.app.dto.EventoDeSaludDTO;
import com.proseca.app.entities.EventoDeSalud;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EventoDeSaludApi {

    @Operation(tags = {"Eventos de Salud"}, summary = "Registrar un nuevo evento de salud")
    @PostMapping(value = "/eventos-salud")
    ResponseEntity<EventoDeSalud> registrar(@RequestBody EventoDeSaludDTO dto);

    @Operation(tags = {"Eventos de Salud"}, summary = "Listar todos los eventos de salud")
    @GetMapping(value = "/eventos-salud")
    ResponseEntity<List<EventoDeSalud>> listarTodos();

    @Operation(tags = {"Eventos de Salud"}, summary = "Listar eventos de salud por animal")
    @GetMapping(value = "/eventos-salud/animal/{animalId}")
    ResponseEntity<List<EventoDeSalud>> listarPorAnimal(@PathVariable Integer animalId);
}
