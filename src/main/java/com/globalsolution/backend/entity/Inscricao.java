package com.globalsolution.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inscricoes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "trilha_id"})
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Inscricao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "trilha_id")
    private TrilhaDeAprendizado trilha;

    private LocalDateTime inscricaoEm;

    private boolean concluida;
}
