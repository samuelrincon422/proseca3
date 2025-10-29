package com.proseca.app.controllers.api;

import com.proseca.app.entities.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UsuarioApi {

    @Operation(tags = {"Usuario"}, summary = "Listar todos los usuarios")
    @GetMapping(value = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Usuario>> listarTodos();

    @Operation(tags = {"Usuario"}, summary = "Obtener usuario por ID")
    @GetMapping(value = "/usuarios/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Usuario> obtenerPorId(@PathVariable Integer id);

    @Operation(tags = {"Usuario"}, summary = "Registrar un nuevo usuario")
    @PostMapping(value = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Usuario> crear(@RequestBody Usuario usuario);

    @Operation(tags = {"Usuario"}, summary = "Actualizar usuario existente")
    @PutMapping(value = "/usuarios/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Usuario> actualizar(@PathVariable Integer id, @RequestBody Usuario usuario);

    @Operation(tags = {"Usuario"}, summary = "Eliminar usuario")
    @DeleteMapping(value = "/usuarios/{id}")
    ResponseEntity<Void> eliminar(@PathVariable Integer id);
}
