package com.globalsolution.backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscricaoDTO {
    private Long id;
    private Long usuarioId;
    private Long trilhaId;
    private boolean concluida;
    private String inscricaoEm;
}