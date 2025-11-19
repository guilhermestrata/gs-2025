package com.globalsolution.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrilhaDTO {
    private Long id;

    @NotBlank(message = "titulo é obrigatório")
    @Size(max = 150)
    private String titulo;

    private String descricao;

    @Min(value = 1, message = "cargaHoraria deve ser positiva")
    private Integer cargaHoraria;

    private Nivel nivel;
}
