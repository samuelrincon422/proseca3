package com.proseca.app.repositories.interfaces;

import com.proseca.app.entities.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunaRepository extends JpaRepository<Vacuna, Integer> {}