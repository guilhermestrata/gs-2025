package com.globalsolution.backend.repository;

import com.globalsolution.backend.entity.Inscricao;
import com.globalsolution.backend.entity.TrilhaDeAprendizado;
import com.globalsolution.backend.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {

    Optional<Inscricao> findByUsuarioAndTrilha(Usuario usuario, TrilhaDeAprendizado trilha);

    List<Inscricao> findByUsuario(Usuario usuario);

    List<Inscricao> findByTrilha(TrilhaDeAprendizado trilha);
}