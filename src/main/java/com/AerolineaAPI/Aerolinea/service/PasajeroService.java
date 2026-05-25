package com.AerolineaAPI.Aerolinea.service;
/*
Crear los servicios
— VueloService en el paquete service — anota con @Service
— Inyecta VueloRepository por constructor con @Autowired — campo final
— Métodos: findAll() y save(Vuelo vuelo)
— PasajeroService — misma estructura, inyecta PasajeroRepository
 */

import com.AerolineaAPI.Aerolinea.model.Pasajero;
import com.AerolineaAPI.Aerolinea.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasajero> findAll(){
       return pasajeroRepository.findAll();
    }

    public Pasajero save(Pasajero pasajero){
        return pasajeroRepository.save(pasajero);
    }
}
