package com.proseca.app.controllers;

import com.proseca.app.controllers.api.UsuarioApi;
import com.proseca.app.entities.Usuario;
import com.proseca.app.repositories.interfaces.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController implements UsuarioApi {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<List<Usuario>> listarTodos() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Usuario> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Usuario> crear(Usuario usuario) {
        return new ResponseEntity<>(repository.save(usuario), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Usuario> actualizar(Integer id, Usuario usuario) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNombre(usuario.getNombre());
                    existing.setCorreo(usuario.getCorreo());
                    existing.setContrasena(usuario.getContrasena());
                    existing.setRol(usuario.getRol());
                    return new ResponseEntity<>(repository.save(existing), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Void> eliminar(Integer id) {
        if (!repository.existsById(id)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
