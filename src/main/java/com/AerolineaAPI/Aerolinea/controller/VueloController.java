package com.AerolineaAPI.Aerolinea.controller;

import com.AerolineaAPI.Aerolinea.model.Vuelo; // O tu VueloDTO si manejas uno
import com.AerolineaAPI.Aerolinea.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private VueloService vueloService;

    @GetMapping
    public ResponseEntity<List<Vuelo>> findAll() {
        return ResponseEntity.ok(vueloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> findById(@PathVariable Long id) {
        Vuelo vuelo = vueloService.findById(id);
        if (vuelo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vuelo);
    }

    @PostMapping
    public ResponseEntity<Vuelo> save(@RequestBody Vuelo vuelo) {
        Vuelo creado = vueloService.save(vuelo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> update(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        Vuelo actualizado = vueloService.update(id, vuelo);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vueloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
