package com.globalsolution.backend.mapper;

import com.globalsolution.backend.dto.TrilhaDTO;
import com.globalsolution.backend.dto.UsuarioDTO;
import com.globalsolution.backend.entity.TrilhaDeAprendizado;
import com.globalsolution.backend.entity.Usuario;

public class MapperUtil {

    public static Usuario toUsuarioEntity(UsuarioDTO dto) {
        if (dto == null) return null;
        return Usuario.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .profissao(dto.getProfissao())
                .nivel(dto.getNivel())
                .build();
    }

    public static UsuarioDTO toUsuarioDTO(Usuario u) {
        if (u == null) return null;
        return new UsuarioDTO(u.getId(), u.getNome(), u.getEmail(), u.getProfissao(), u.getNivel());
    }

    public static TrilhaDeAprendizado toTrilhaEntity(TrilhaDTO dto) {
        if (dto == null) return null;
        return TrilhaDeAprendizado.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .cargaHoraria(dto.getCargaHoraria())
                .nivel(dto.getNivel())
                .build();
    }

    public static TrilhaDTO toTrilhaDTO(TrilhaDeAprendizado t) {
        if (t == null) return null;
        return new TrilhaDTO(t.getId(), t.getTitulo(), t.getDescricao(), t.getCargaHoraria(), t.getNivel());
    }
}
