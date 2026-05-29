package com.AerolineaAPI.Aerolinea.controller;

import com.AerolineaAPI.Aerolinea.model.Pasajero; // O tu PasajeroDTO si manejas uno
import com.AerolineaAPI.Aerolinea.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    @Autowired
    private PasajeroService pasajeroService;

    @GetMapping
    public ResponseEntity<List<Pasajero>> findAll() {
        return ResponseEntity.ok(pasajeroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> findById(@PathVariable Long id) {
        Pasajero pasajero = pasajeroService.findById(id);
        if (pasajero == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pasajero);
    }

    @PostMapping
    public ResponseEntity<Pasajero> save(@RequestBody Pasajero pasajero) {
        Pasajero creado = pasajeroService.save(pasajero);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> update(@PathVariable Long id, @RequestBody Pasajero pasajero) {
        Pasajero actualizado = pasajeroService.update(id, pasajero);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pasajeroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
