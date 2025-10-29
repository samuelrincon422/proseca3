package com.proseca.app.services.interfaces;

import com.proseca.app.dto.EventoDeSaludDTO;
import com.proseca.app.entities.EventoDeSalud;

import java.util.List;

public interface EventoDeSaludService {

    EventoDeSalud registrar(EventoDeSaludDTO dto);

    List<EventoDeSalud> listarTodos();

    List<EventoDeSalud> listarPorAnimal(Integer animalId);
}
