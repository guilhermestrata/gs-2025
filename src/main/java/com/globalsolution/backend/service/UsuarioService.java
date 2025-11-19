package com.globalsolution.backend.service;

import com.globalsolution.backend.entity.Usuario;
import com.globalsolution.backend.exception.ResourceNotFoundException;
import com.globalsolution.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario create(Usuario u) {
        repo.findByEmail(u.getEmail()).ifPresent(existing -> {
            throw new IllegalArgumentException("Email já cadastrado: " + u.getEmail());
        });
        return repo.save(u);
    }

    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado: " + id));
    }

    public Usuario update(Long id, Usuario updated) {
        Usuario existing = findById(id);
        existing.setNome(updated.getNome());
        existing.setEmail(updated.getEmail());
        existing.setProfissao(updated.getProfissao());
        existing.setNivel(updated.getNivel());
        return repo.save(existing);
    }

    public void delete(Long id) {
        Usuario u = findById(id);
        repo.delete(u);
    }
}
