package com.proseca.app.services.interfaces;

import com.proseca.app.entities.Animal;
import java.util.List;

public interface AnimalService {
    Animal crear(Animal animal);
    Animal obtenerPorId(Integer id);
    List<Animal> listarTodos();
    Animal actualizar(Integer id, Animal animal);
    void eliminar(Integer id);
}
