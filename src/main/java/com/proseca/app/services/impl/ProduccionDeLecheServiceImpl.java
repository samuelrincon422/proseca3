package com.proseca.app.services.impl;

import com.proseca.app.dto.ProduccionDeLecheDTO;
import com.proseca.app.entities.Animal;
import com.proseca.app.entities.ProduccionDeLeche;
import com.proseca.app.repositories.interfaces.AnimalRepository;
import com.proseca.app.repositories.interfaces.ProduccionDeLecheRepository;
import com.proseca.app.services.interfaces.ProduccionDeLecheService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduccionDeLecheServiceImpl implements ProduccionDeLecheService {

    private final ProduccionDeLecheRepository produccionDeLecheRepository;
    private final AnimalRepository animalRepository;

    public ProduccionDeLecheServiceImpl(ProduccionDeLecheRepository produccionDeLecheRepository,
                                        AnimalRepository animalRepository) {
        this.produccionDeLecheRepository = produccionDeLecheRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public ProduccionDeLeche registrar(ProduccionDeLecheDTO dto) {
        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal no encontrado"));

        ProduccionDeLeche produccion = ProduccionDeLeche.builder()
                .animal(animal)
                .fechaRegistro(dto.getFechaRegistro())
                .cantidadLitros(dto.getCantidadLitros())
                .build();

        return produccionDeLecheRepository.save(produccion);
    }

    @Override
    public List<ProduccionDeLeche> listarTodos() {
        return produccionDeLecheRepository.findAll();
    }

    @Override
    public List<ProduccionDeLeche> listarPorAnimal(Integer animalId) {
        return produccionDeLecheRepository.findByAnimalId(animalId);
    }
}
