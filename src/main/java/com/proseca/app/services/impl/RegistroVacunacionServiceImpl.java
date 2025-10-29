package com.proseca.app.services.impl;

import com.proseca.app.dto.RegistroVacunacionRequestDTO;
import com.proseca.app.entities.Animal;
import com.proseca.app.entities.RegistroVacunacion;
import com.proseca.app.entities.Vacuna;
import com.proseca.app.repositories.interfaces.AnimalRepository;
import com.proseca.app.repositories.interfaces.VacunaRepository;
import com.proseca.app.repositories.interfaces.RegistroVacunacionRepository;
import com.proseca.app.services.interfaces.RegistroVacunacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroVacunacionServiceImpl implements RegistroVacunacionService {

    private final RegistroVacunacionRepository registroRepo;
    private final AnimalRepository animalRepo;
    private final VacunaRepository vacunaRepo;

    public RegistroVacunacionServiceImpl(
            RegistroVacunacionRepository registroRepo,
            AnimalRepository animalRepo,
            VacunaRepository vacunaRepo
    ) {
        this.registroRepo = registroRepo;
        this.animalRepo = animalRepo;
        this.vacunaRepo = vacunaRepo;
    }

    @Override
    public RegistroVacunacion registrarVacunacion(RegistroVacunacionRequestDTO dto) {
        Animal animal = animalRepo.findById(dto.getAnimalId())
                .orElseThrow(() -> new RuntimeException("Animal no encontrado"));
        Vacuna vacuna = vacunaRepo.findById(dto.getVacunaId())
                .orElseThrow(() -> new RuntimeException("Vacuna no encontrada"));

        RegistroVacunacion registro = RegistroVacunacion.builder()
                .animal(animal)
                .vacuna(vacuna)
                .responsable(dto.getResponsable())
                .build();

        return registroRepo.save(registro);
    }

    @Override
    public List<RegistroVacunacion> listarTodos() {
        return registroRepo.findAll();
    }

    @Override
    public List<RegistroVacunacion> listarPorAnimal(Integer animalId) {
        return registroRepo.findByAnimalId(animalId);
    }
}
