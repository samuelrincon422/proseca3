package com.proseca.app.services.impl;

import com.proseca.app.dto.EventoDeSaludDTO;
import com.proseca.app.entities.Animal;
import com.proseca.app.entities.EventoDeSalud;
import com.proseca.app.repositories.interfaces.EventoDeSaludRepository;
import com.proseca.app.repositories.interfaces.AnimalRepository;
import com.proseca.app.services.interfaces.EventoDeSaludService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoDeSaludServiceImpl implements EventoDeSaludService {

    private final EventoDeSaludRepository eventoDeSaludRepository;
    private final AnimalRepository animalRepository;

    public EventoDeSaludServiceImpl(EventoDeSaludRepository eventoDeSaludRepository,
                                    AnimalRepository animalRepository) {
        this.eventoDeSaludRepository = eventoDeSaludRepository;
        this.animalRepository = animalRepository;
    }

    @Override
    public EventoDeSalud registrar(EventoDeSaludDTO dto) {
        Animal animal = animalRepository.findById(dto.getIdAnimal())
                .orElseThrow(() -> new RuntimeException("Animal no encontrado"));

        EventoDeSalud evento = EventoDeSalud.builder()
                .animal(animal)
                .descripcion(dto.getDescripcion())
                .fecha(dto.getFecha())
                .tipoEvento(dto.getTratamiento())
                .build();

        return eventoDeSaludRepository.save(evento);
    }

    @Override
    public List<EventoDeSalud> listarTodos() {
        return eventoDeSaludRepository.findAll();
    }

    @Override
    public List<EventoDeSalud> listarPorAnimal(Integer animalId) {
        return eventoDeSaludRepository.findByAnimalId(animalId);
    }
}
