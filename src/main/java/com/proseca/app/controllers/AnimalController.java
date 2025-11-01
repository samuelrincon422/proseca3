package com.proseca.app.controllers;

import com.proseca.app.controllers.api.AnimalApi;
import com.proseca.app.entities.Animal;
import com.proseca.app.repositories.interfaces.AnimalRepository;
import com.proseca.app.services.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class AnimalController implements AnimalApi {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public ResponseEntity<Animal> crear(Animal animal) {
        Animal nuevo = animalRepository.save(animal);
        return ResponseEntity.ok(nuevo);
    }

    @Override
    public ResponseEntity<List<Animal>> listarTodos() {
        return ResponseEntity.ok(animalRepository.findAll());
    }

    @Override
    public ResponseEntity<Animal> obtenerPorId(Integer id) {
        return animalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Animal> actualizar(Integer id, Animal animal) {
        if (!animalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        animal.setId(id);
        return ResponseEntity.ok(animalRepository.save(animal));
    }

    @Override
    public ResponseEntity<Void> eliminar(Integer id) {
        if (!animalRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        animalRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}





