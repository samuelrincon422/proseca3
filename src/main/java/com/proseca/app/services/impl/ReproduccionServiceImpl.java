package com.proseca.app.services.impl;

import com.proseca.app.dto.ReproduccionDTO;
import com.proseca.app.entities.Animal;
import com.proseca.app.entities.Reproduccion;
import com.proseca.app.repositories.interfaces.AnimalRepository;
import com.proseca.app.repositories.interfaces.ReproduccionRepository;
import com.proseca.app.services.interfaces.ReproduccionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReproduccionServiceImpl implements ReproduccionService {

    private final ReproduccionRepository reproduccionRepository;
    private final AnimalRepository animalRepository;

    public ReproduccionServiceImpl(ReproduccionRepository reproduccionRepository,
                                   AnimalRepository animalRepository) {
        this.reproduccionRepository = reproduccionRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public Reproduccion registrar(ReproduccionDTO dto) {
        Animal animal = animalRepository.findById(dto.getIdAnimal())
                .orElseThrow(() -> new RuntimeException("Animal no encontrado con ID: " + dto.getIdAnimal()));

        Reproduccion reproduccion = new Reproduccion();
        reproduccion.setAnimal(animal);
        reproduccion.setFecha(dto.getFecha());
        reproduccion.setTipoEvento(dto.getTipoEvento());
        reproduccion.setObservaciones(dto.getObservaciones());

        return reproduccionRepository.save(reproduccion);
    }

    @Override
    public List<Reproduccion> listarTodos() {
        return reproduccionRepository.findAll();
    }

    @Override
    public List<Reproduccion> listarPorAnimal(Integer animalId) {
        return reproduccionRepository.findByAnimalId(animalId);
    }
}
