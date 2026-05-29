package com.AerolineaAPI.Aerolinea.controller;


import com.AerolineaAPI.Aerolinea.dto.ReservaRequestDTO;
import com.AerolineaAPI.Aerolinea.dto.ReservaResponseDTO;
import com.AerolineaAPI.Aerolinea.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

        private final ReservaService reservaService;

        @Autowired
        public ReservaController(ReservaService reservaService) {
            this.reservaService = reservaService;
        }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> findAll() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> findById(@PathVariable Long id) {
        ReservaResponseDTO resultado = reservaService.findById(id);
        if (resultado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> save(@RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO creado = reservaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> update(@PathVariable Long id, @RequestBody ReservaRequestDTO dto) {
        ReservaResponseDTO actualizado = reservaService.update(id, dto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

