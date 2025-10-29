package com.proseca.app.services.impl;

import com.proseca.app.entities.Finca;
import com.proseca.app.repositories.interfaces.FincaRepository;
import com.proseca.app.services.interfaces.FincaService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FincaServiceImpl implements FincaService {

    private final FincaRepository repository;

    public FincaServiceImpl(FincaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Finca crear(Finca finca) {
        return repository.save(finca);
    }

    @Override
    public Finca obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Finca no encontrada"));
    }

    @Override
    public List<Finca> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Finca actualizar(Integer id, Finca finca) {
        Finca existente = obtenerPorId(id);
        existente.setNombre(finca.getNombre());
        existente.setUbicacion(finca.getUbicacion());
        existente.setPropietario(finca.getPropietario());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
