package com.globalsolution.backend.service;

import com.globalsolution.backend.entity.Inscricao;
import com.globalsolution.backend.entity.TrilhaDeAprendizado;
import com.globalsolution.backend.entity.Usuario;
import com.globalsolution.backend.exception.ResourceNotFoundException;
import com.globalsolution.backend.repository.InscricaoRepository;
import com.globalsolution.backend.repository.TrilhaRepository;
import com.globalsolution.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class InscricaoService {

    private final InscricaoRepository inscrRepo;
    private final UsuarioRepository usuarioRepo;
    private final TrilhaRepository trilhaRepo;

    public InscricaoService(InscricaoRepository inscrRepo, UsuarioRepository usuarioRepo, TrilhaRepository trilhaRepo) {
        this.inscrRepo = inscrRepo;
        this.usuarioRepo = usuarioRepo;
        this.trilhaRepo = trilhaRepo;
    }

    public Inscricao inscrever(Long usuarioId, Long trilhaId) {
        Usuario u = usuarioRepo.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado: " + usuarioId));
        TrilhaDeAprendizado t = trilhaRepo.findById(trilhaId).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada: " + trilhaId));

        if (inscrRepo.findByUsuarioAndTrilha(u, t).isPresent()) {
            throw new IllegalArgumentException("Usuário já inscrito nesta trilha.");
        }

        Inscricao i = Inscricao.builder()
                .usuario(u)
                .trilha(t)
                .inscricaoEm(LocalDateTime.now())
                .concluida(false)
                .build();
        return inscrRepo.save(i);
    }

    public List<Inscricao> listarPorUsuario(Long usuarioId) {
        Usuario u = usuarioRepo.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrado: " + usuarioId));
        return inscrRepo.findByUsuario(u);
    }

    public List<Inscricao> listarPorTrilha(Long trilhaId) {
        TrilhaDeAprendizado t = trilhaRepo.findById(trilhaId).orElseThrow(() -> new ResourceNotFoundException("Trilha não encontrada: " + trilhaId));
        return inscrRepo.findByTrilha(t);
    }

    public void cancelarInscricao(Long inscricaoId) {
        Inscricao i = inscrRepo.findById(inscricaoId).orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada: " + inscricaoId));
        inscrRepo.delete(i);
    }

    public Inscricao marcarConcluida(Long inscricaoId) {
        Inscricao i = inscrRepo.findById(inscricaoId).orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada: " + inscricaoId));
        i.setConcluida(true);
        return inscrRepo.save(i);
    }
}
