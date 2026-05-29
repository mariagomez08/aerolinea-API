package com.AerolineaAPI.Aerolinea.model;

/*
* rear la entidad Pasajero
— Misma estructura que Vuelo — @Entity, @Table, @Id, @GeneratedValue
— Campos: nombre, apellido, documento, email — todos String, nullable = false
— Constructor vacío + constructor completo + getters y setters*/

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="pasajeros")
public class Pasajero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @Column(nullable = false)
    @NotBlank(message = "El apellido no puede estar vacío")
    private String apellido;
    @Column(nullable = false)
    @NotBlank(message = "El documento es obligatorio")
    private String documento;
    @Column(nullable = false)
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email no tiene un formato válido")
    private String email;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, String documento, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
