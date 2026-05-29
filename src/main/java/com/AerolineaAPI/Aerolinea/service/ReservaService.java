package com.AerolineaAPI.Aerolinea.service;

import com.AerolineaAPI.Aerolinea.dto.ReservaRequestDTO;
import com.AerolineaAPI.Aerolinea.dto.ReservaResponseDTO;
import com.AerolineaAPI.Aerolinea.model.Reserva;
import com.AerolineaAPI.Aerolinea.repository.PasajeroRepository;
import com.AerolineaAPI.Aerolinea.repository.ReservaRepository;
import com.AerolineaAPI.Aerolinea.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AerolineaAPI.Aerolinea.model.Pasajero;
import com.AerolineaAPI.Aerolinea.model.Vuelo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Autowired
    private VueloRepository vueloRepository;

    public List<ReservaResponseDTO> findAll() {

        List<Reserva> reservas = reservaRepository.findAll();

        List<ReservaResponseDTO> respuesta = new ArrayList<>();

        for (Reserva reserva : reservas) {

            ReservaResponseDTO dto = ReservaResponseDTO.desde(reserva);

            respuesta.add(dto);
        }

        return respuesta;
    }

    public ReservaResponseDTO findById(Long id) {

        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva == null) {
            return null;
        }

        return ReservaResponseDTO.desde(reserva);
    }

    public ReservaResponseDTO save(ReservaRequestDTO dto) {

        Pasajero pasajero = pasajeroRepository
                .findById(dto.getPasajeroId())
                .orElse(null);

        Vuelo vuelo = vueloRepository
                .findById(dto.getVueloId())
                .orElse(null);

        Reserva reserva = new Reserva();

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setClase(dto.getClase());
        reserva.setPasajero(pasajero);
        reserva.setVuelo(vuelo);

        Reserva reservaGuardada = reservaRepository.save(reserva);

        return ReservaResponseDTO.desde(reservaGuardada);
    }

    public ReservaResponseDTO update(Long id, ReservaRequestDTO dto) {

        Reserva reserva = reservaRepository.findById(id).orElse(null);

        if (reserva == null) {
            return null;
        }

        Pasajero pasajero = pasajeroRepository
                .findById(dto.getPasajeroId())
                .orElse(null);

        Vuelo vuelo = vueloRepository
                .findById(dto.getVueloId())
                .orElse(null);

        reserva.setFechaReserva(dto.getFechaReserva());
        reserva.setClase(dto.getClase());
        reserva.setPasajero(pasajero);
        reserva.setVuelo(vuelo);

        Reserva reservaActualizada = reservaRepository.save(reserva);

        return ReservaResponseDTO.desde(reservaActualizada);
    }

    public void delete(Long id) {

        reservaRepository.deleteById(id);
    }
}
