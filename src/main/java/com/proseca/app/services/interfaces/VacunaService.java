package com.proseca.app.services.interfaces;

import com.proseca.app.entities.Vacuna;
import java.util.List;

public interface VacunaService {
    Vacuna crear(Vacuna vacuna);
    Vacuna obtenerPorId(Integer id);
    List<Vacuna> listarTodos();
    Vacuna actualizar(Integer id, Vacuna vacuna);
    void eliminar(Integer id);
}
