package com.proseca.app.services.interfaces;

import com.proseca.app.entities.Finca;
import java.util.List;

public interface FincaService {
    Finca crear(Finca finca);
    Finca obtenerPorId(Integer id);
    List<Finca> listarTodos();
    Finca actualizar(Integer id, Finca finca);
    void eliminar(Integer id);
}
