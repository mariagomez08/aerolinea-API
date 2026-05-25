package com.AerolineaAPI.Aerolinea.repository;

import com.AerolineaAPI.Aerolinea.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero,Long> {
}
