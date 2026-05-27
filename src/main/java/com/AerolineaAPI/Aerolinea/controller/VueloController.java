package com.AerolineaAPI.Aerolinea.controller;

import com.AerolineaAPI.Aerolinea.model.Vuelo;
import com.AerolineaAPI.Aerolinea.service.VueloService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Vuelo crearVuelo( @RequestBody Vuelo vuelo){
        return vueloService.save(vuelo);
    }

    @GetMapping("/{id}")// /vuelos/{id} Retorna el vuelo con ese ID
    public Vuelo devolverVueloPorID(@PathVariable Long id){
        return vueloService.findById(id);
    }
    @PutMapping("/{id}") //vuelos/{id} Actualiza un vuelo existente
    public Vuelo actualizarVuelo(@PathVariable Long id, @RequestBody Vuelo datos){
        return vueloService.update(id, datos);
    }
    @DeleteMapping("/{id}") //vuelos/{id} Elimina un vuelo por ID
    public void eliminarVueloPorID(@PathVariable Long id){
        vueloService.delete(id);
    }
}
