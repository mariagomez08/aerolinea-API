package com.AerolineaAPI.Aerolinea.dto;

import com.AerolineaAPI.Aerolinea.model.ClaseAsiento;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ReservaRequestDTO {

    @NotNull(message = "La fecha de reserva es obligatoria")
    private LocalDateTime fechaReserva; //feecha y hora de la reserva

    @NotNull(message = "La clase del asiento es obligatoria")
    private ClaseAsiento clase; //clase del asiento

    @NotNull(message = "El id del pasajero es obligatorio")
    private Long pasajeroId; //id pasajero que reserva

    @NotNull(message = "El id del vuelo es obligatorio")
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
