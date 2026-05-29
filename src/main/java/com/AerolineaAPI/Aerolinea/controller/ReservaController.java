package com.AerolineaAPI.Aerolinea.controller;


import com.AerolineaAPI.Aerolinea.dto.ReservaRequestDTO;
import com.AerolineaAPI.Aerolinea.dto.ReservaResponseDTO;
import com.AerolineaAPI.Aerolinea.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
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
        public List<ReservaResponseDTO> findAll() {

            return reservaService.findAll();
        }

        @GetMapping("/{id}")
        public ReservaResponseDTO findById(@PathVariable Long id) {

            return reservaService.findById(id);
        }

        @PostMapping
        public ReservaResponseDTO save(@RequestBody ReservaRequestDTO dto) {

            return reservaService.save(dto);
        }

        @PutMapping("/{id}")
        public ReservaResponseDTO update(
                @PathVariable Long id,
                @RequestBody ReservaRequestDTO dto) {

            return reservaService.update(id, dto);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {

            reservaService.delete(id);
        }
    }

