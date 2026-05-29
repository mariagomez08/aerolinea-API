package com.AerolineaAPI.Aerolinea.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/*
* Crear la entidad Vuelo
— Anota la clase con @Entity y define el nombre de tabla explícitamente
— Campo id: tipo Long, con @Id y @GeneratedValue(strategy = GenerationType.IDENTITY)
— Campos origen y destino: String, @Column(nullable = false)
— Campo fechaHora: LocalDateTime, @Column(nullable = false)
— Campo estado: tipo EstadoVuelo, con @Enumerated(EnumType.STRING)
— Constructor vacío obligatorio para JPA + constructor con todos los campos
— Getters y setters para todos los campos
Recuerda: sin @Enumerated(EnumType.STRING), Hibernate guarda números en la BD.*/
@Entity
@Table(name="vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vuelo;

    @Column(nullable = false)
    @NotBlank(message = "El origen no puede estar vacío")
    private String origen;

    @Column(nullable = false)
    @NotBlank(message = "El destino no puede estar vacío")
    private String destino;

    @Column(nullable = false)
    @NotNull(message = "La fecha y hora del vuelo son obligatorias")
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado del vuelo es obligatorio")
    private EstadoVuelo estado;

    public Vuelo() {
    }

    public Vuelo(EstadoVuelo estado, LocalDateTime fechaHora, String destino, String origen, Long id) {
        this.estado = estado;
        this.fechaHora = fechaHora;
        this.destino = destino;
        this.origen = origen;
        this.id_vuelo = id;
    }

    public Long getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(Long id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public EstadoVuelo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVuelo estado) {
        this.estado = estado;
    }
}
