package com.proseca.app.services.interfaces;

import com.proseca.app.dto.ReproduccionDTO;
import com.proseca.app.entities.Reproduccion;

import java.util.List;

public interface ReproduccionService {
    Reproduccion registrar(ReproduccionDTO dto);
    List<Reproduccion> listarTodos();
    List<Reproduccion> listarPorAnimal(Integer animalId);
}
