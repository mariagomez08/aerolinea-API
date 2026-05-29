package com.AerolineaAPI.Aerolinea.dto;

import com.AerolineaAPI.Aerolinea.model.ClaseAsiento;

import java.time.LocalDateTime;

public class ReservaRequestDTO {

    private LocalDateTime fechaReserva; //feecha y hora de la reserva
    private ClaseAsiento clase; //clase del asiento
    private Long pasajeroId; //id pasajero que reserva
    private Long vueloId; //vuelo reservado

    public ReservaRequestDTO() {
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public ClaseAsiento getClase() {
        return clase;
    }

    public void setClase(ClaseAsiento clase) {
        this.clase = clase;
    }

    public Long getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Long pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }
}
