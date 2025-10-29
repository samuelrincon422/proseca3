package com.proseca.app.services.interfaces;

import com.proseca.app.dto.ProduccionDeLecheDTO;
import com.proseca.app.entities.ProduccionDeLeche;
import java.util.List;

public interface ProduccionDeLecheService {
    ProduccionDeLeche registrar(ProduccionDeLecheDTO dto);
    List<ProduccionDeLeche> listarTodos();
    List<ProduccionDeLeche> listarPorAnimal(Integer animalId);
}
