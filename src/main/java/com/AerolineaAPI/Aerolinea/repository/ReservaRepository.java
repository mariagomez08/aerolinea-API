package com.AerolineaAPI.Aerolinea.repository;

import com.AerolineaAPI.Aerolinea.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
