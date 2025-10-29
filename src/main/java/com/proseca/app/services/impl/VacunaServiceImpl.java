package com.proseca.app.services.impl;

import com.proseca.app.entities.Vacuna;
import com.proseca.app.repositories.interfaces.VacunaRepository;
import com.proseca.app.services.interfaces.VacunaService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacunaServiceImpl implements VacunaService {

    private final VacunaRepository repository;

    public VacunaServiceImpl(VacunaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vacuna crear(Vacuna vacuna) {
        return repository.save(vacuna);
    }

    @Override
    public Vacuna obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vacuna no encontrada"));
    }

    @Override
    public List<Vacuna> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Vacuna actualizar(Integer id, Vacuna vacuna) {
        Vacuna existente = obtenerPorId(id);
        existente.setNombre(vacuna.getNombre());
        existente.setDescripcion(vacuna.getDescripcion());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
