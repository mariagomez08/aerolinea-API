package com.AerolineaAPI.Aerolinea.controller;

import com.AerolineaAPI.Aerolinea.model.Pasajero;
import com.AerolineaAPI.Aerolinea.model.Vuelo;
import com.AerolineaAPI.Aerolinea.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
