package com.globalsolution.backend.controller;

import com.globalsolution.backend.dto.TrilhaDTO;
import com.globalsolution.backend.entity.TrilhaDeAprendizado;
import com.globalsolution.backend.mapper.MapperUtil;
import com.globalsolution.backend.service.TrilhaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trilhas")
public class TrilhaController {

    private final TrilhaService service;

    public TrilhaController(TrilhaService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<TrilhaDTO>> listAll() {
        List<TrilhaDTO> list = service.findAll().stream().map(MapperUtil::toTrilhaDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(MapperUtil.toTrilhaDTO(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<TrilhaDTO> create(@Valid @RequestBody TrilhaDTO dto) {
        TrilhaDeAprendizado t = MapperUtil.toTrilhaEntity(dto);
        TrilhaDeAprendizado saved = service.create(t);
        return ResponseEntity.created(URI.create("/api/trilhas/" + saved.getId())).body(MapperUtil.toTrilhaDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrilhaDTO> update(@PathVariable Long id, @Valid @RequestBody TrilhaDTO dto) {
        TrilhaDeAprendizado t = MapperUtil.toTrilhaEntity(dto);
        TrilhaDeAprendizado updated = service.update(id, t);
        return ResponseEntity.ok(MapperUtil.toTrilhaDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
