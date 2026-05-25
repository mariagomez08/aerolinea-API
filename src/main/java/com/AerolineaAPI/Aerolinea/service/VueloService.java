package com.AerolineaAPI.Aerolinea.service;


import com.AerolineaAPI.Aerolinea.model.Pasajero;
import com.AerolineaAPI.Aerolinea.model.Vuelo;
import com.AerolineaAPI.Aerolinea.repository.PasajeroRepository;
import com.AerolineaAPI.Aerolinea.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> findAll(){
        return vueloRepository.findAll();
    }

    public Vuelo save(Vuelo vuelo){
        return vueloRepository.save(vuelo);
    }
}
