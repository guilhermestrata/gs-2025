package com.globalsolution.backend.entity;

import com.globalsolution.backend.dto.Nivel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trilhas")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TrilhaDeAprendizado {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String titulo;

    @Size(max = 1000)
    private String descricao;

    @Min(1)
    private Integer cargaHoraria;

    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Inscricao> inscricoes = new HashSet<>();
}
