package com.AerolineaAPI.Aerolinea.model;

/*
* rear la entidad Pasajero
— Misma estructura que Vuelo — @Entity, @Table, @Id, @GeneratedValue
— Campos: nombre, apellido, documento, email — todos String, nullable = false
— Constructor vacío + constructor completo + getters y setters*/

import jakarta.persistence.*;

@Entity
@Table(name="pasajeros")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    private String email;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, String documento, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
