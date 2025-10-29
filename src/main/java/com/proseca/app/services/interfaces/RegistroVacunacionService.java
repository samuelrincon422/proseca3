package com.proseca.app.services.interfaces;

import com.proseca.app.dto.RegistroVacunacionRequestDTO;
import com.proseca.app.entities.RegistroVacunacion;
import java.util.List;

public interface RegistroVacunacionService {
    RegistroVacunacion registrarVacunacion(RegistroVacunacionRequestDTO dto);
    List<RegistroVacunacion> listarTodos();
    List<RegistroVacunacion> listarPorAnimal(Integer animalId);
}
