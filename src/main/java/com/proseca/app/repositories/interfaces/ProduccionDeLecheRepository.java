package com.proseca.app.repositories.interfaces;

import com.proseca.app.entities.ProduccionDeLeche;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProduccionDeLecheRepository extends JpaRepository<ProduccionDeLeche, Integer> {
    List<ProduccionDeLeche> findByAnimalId(Integer animalId);
}
