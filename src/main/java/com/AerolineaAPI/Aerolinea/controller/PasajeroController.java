package com.AerolineaAPI.Aerolinea.controller;

import com.AerolineaAPI.Aerolinea.model.Pasajero;
import com.AerolineaAPI.Aerolinea.model.Vuelo;
import com.AerolineaAPI.Aerolinea.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {
    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public List<Pasajero> obtenerTodos() {
        return pasajeroService.findAll();
    }

    @PostMapping
    public Pasajero crearPasajero(@RequestBody Pasajero pasajero){
        return pasajeroService.save(pasajero);
    }


    @GetMapping("/{id}") // /pasajeros/{id}
    public Pasajero devolverPasajeroPorID(@PathVariable Long id) {
        return pasajeroService.findById(id);
    }

    @PutMapping("/{id}") // /pasajeros/{id}
    public Pasajero actualizarPasajero(@PathVariable Long id, @RequestBody Pasajero datos) {
        return pasajeroService.update(id, datos);
    }

    @DeleteMapping("/{id}") // /pasajeros/{id}
    public void eliminarPasajeroPorID(@PathVariable Long id) {
        pasajeroService.delete(id);
    }

}
