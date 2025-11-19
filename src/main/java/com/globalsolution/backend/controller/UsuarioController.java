package com.globalsolution.backend.controller;

import com.globalsolution.backend.dto.UsuarioDTO;
import com.globalsolution.backend.entity.Usuario;
import com.globalsolution.backend.mapper.MapperUtil;
import com.globalsolution.backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listAll() {
        List<UsuarioDTO> list = service.findAll().stream().map(MapperUtil::toUsuarioDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(MapperUtil.toUsuarioDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO dto) {
        Usuario u = MapperUtil.toUsuarioEntity(dto);
        Usuario saved = service.create(u);
        return ResponseEntity.created(URI.create("/api/usuarios/" + saved.getId())).body(MapperUtil.toUsuarioDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
        Usuario u = MapperUtil.toUsuarioEntity(dto);
        Usuario updated = service.update(id, u);
        return ResponseEntity.ok(MapperUtil.toUsuarioDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
