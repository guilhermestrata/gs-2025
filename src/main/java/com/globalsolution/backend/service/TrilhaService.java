package com.globalsolution.backend.service;


import com.globalsolution.backend.entity.TrilhaDeAprendizado;
import com.globalsolution.backend.exception.ResourceNotFoundException;
import com.globalsolution.backend.repository.TrilhaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrilhaService {

    private final TrilhaRepository repo;

    public TrilhaService(TrilhaRepository repo) {
        this.repo = repo;
    }

    public TrilhaDeAprendizado create(TrilhaDeAprendizado t) {
        return repo.save(t);
    }

    @Transactional(readOnly = true)
    public List<TrilhaDeAprendizado> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public TrilhaDeAprendizado findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada: " + id));
    }

    public TrilhaDeAprendizado update(Long id, TrilhaDeAprendizado updated) {
        TrilhaDeAprendizado existing = findById(id);
        existing.setTitulo(updated.getTitulo());
        existing.setDescricao(updated.getDescricao());
        existing.setCargaHoraria(updated.getCargaHoraria());
        existing.setNivel(updated.getNivel());
        return repo.save(existing);
    }

    public void delete(Long id) {
        TrilhaDeAprendizado t = findById(id);
        repo.delete(t);
    }
}