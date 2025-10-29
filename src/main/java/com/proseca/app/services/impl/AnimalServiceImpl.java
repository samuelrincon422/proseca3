package com.proseca.app.services.impl;

import com.proseca.app.entities.Animal;
import com.proseca.app.repositories.interfaces.AnimalRepository;
import com.proseca.app.services.interfaces.AnimalService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository repository;

    public AnimalServiceImpl(AnimalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Animal crear(Animal animal) {
        return repository.save(animal);
    }

    @Override
    public Animal obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal no encontrado"));
    }

    @Override
    public List<Animal> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Animal actualizar(Integer id, Animal animal) {
        Animal existente = obtenerPorId(id);
        existente.setNombre(animal.getNombre());
        existente.setEspecie(animal.getEspecie());
        existente.setRaza(animal.getRaza());
        existente.setFechaNacimiento(animal.getFechaNacimiento());
        existente.setFinca(animal.getFinca());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
