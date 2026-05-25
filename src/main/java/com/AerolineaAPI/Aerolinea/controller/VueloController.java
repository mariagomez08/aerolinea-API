package com.AerolineaAPI.Aerolinea.controller;

import com.AerolineaAPI.Aerolinea.model.Vuelo;
import com.AerolineaAPI.Aerolinea.service.VueloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* Crear los controllers y verificar
— VueloController en el paquete controller — @RestController, @RequestMapping("/vuelos")
— Inyecta VueloService por constructor
— Método: @GetMapping que devuelve List
— PasajeroController — misma estructura, ruta /pasajeros
— Corre la aplicación y verifica en consola que Hibernate crea las tablas
— Inserta un dato de prueba en pgAdmin e inspecciona la respuesta en Postman
* */
@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }
    @GetMapping
    public List<Vuelo> obtenerTodos() {
        return vueloService.findAll();
    }
}
