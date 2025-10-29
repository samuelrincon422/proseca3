package com.proseca.app.repositories.interfaces;

import com.proseca.app.entities.RegistroVacunacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RegistroVacunacionRepository extends JpaRepository<RegistroVacunacion, Integer> {
    List<RegistroVacunacion> findByAnimalId(Integer animalId);
}