package com.globalsolution.backend.controller;

import com.globalsolution.backend.dto.InscricaoDTO;
import com.globalsolution.backend.entity.Inscricao;
import com.globalsolution.backend.service.InscricaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

    private final InscricaoService service;
    private final DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;

    public InscricaoController(InscricaoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<InscricaoDTO> criar(@RequestParam Long usuarioId, @RequestParam Long trilhaId) {
        Inscricao i = service.inscrever(usuarioId, trilhaId);
        InscricaoDTO dto = toDTO(i);
        return ResponseEntity.created(URI.create("/api/inscricoes/" + dto.getId())).body(dto);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<InscricaoDTO>> porUsuario(@PathVariable Long usuarioId) {
        List<InscricaoDTO> list = service.listarPorUsuario(usuarioId).stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/trilha/{trilhaId}")
    public ResponseEntity<List<InscricaoDTO>> porTrilha(@PathVariable Long trilhaId) {
        List<InscricaoDTO> list = service.listarPorTrilha(trilhaId).stream().map(this::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        service.cancelarInscricao(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/concluir")
    public ResponseEntity<InscricaoDTO> concluir(@PathVariable Long id) {
        Inscricao i = service.marcarConcluida(id);
        return ResponseEntity.ok(toDTO(i));
    }

    private InscricaoDTO toDTO(Inscricao i) {
        return new InscricaoDTO(
                i.getId(),
                i.getUsuario().getId(),
                i.getTrilha().getId(),
                i.isConcluida(),
                i.getInscricaoEm() != null ? i.getInscricaoEm().format(fmt) : null
        );
    }
}
