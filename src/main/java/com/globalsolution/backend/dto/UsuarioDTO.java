package com.globalsolution.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;

    @NotBlank(message = "nome é obrigatório")
    @Size(max = 100)
    private String nome;

    @NotBlank @Email(message = "email inválido")
    private String email;

    private String profissao;

    private Nivel nivel;
}
