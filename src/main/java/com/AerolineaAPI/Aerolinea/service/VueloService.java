package com.AerolineaAPI.Aerolinea.service;



import com.AerolineaAPI.Aerolinea.model.Vuelo;
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

    public Vuelo findById(Long id){
        return vueloRepository.findById(id).orElse(null);
    }
    public Vuelo update(Long id, Vuelo datos){
         Vuelo existe = vueloRepository.findById(id).orElse(null);
         if(existe == null){ return null; }
             existe.setDestino(datos.getDestino());
             existe.setEstado(datos.getEstado());
             existe.setFechaHora(datos.getFechaHora());
             existe.setOrigen(datos.getOrigen());
             return vueloRepository.save(existe);
    }

   /* delete(Long id) id del vuelo Elimina por ID. Sin retorno voi*/
    public void delete (Long id){
        vueloRepository.deleteById(id);
    }
}
