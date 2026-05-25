package com.AerolineaAPI.Aerolinea.repository;

/*
Crear los repositorios
— VueloRepository en el paquete repository — extiende JpaRepository
— PasajeroRepository en el paquete repository — extiende JpaRepository
— Ambos son interfaces, no clases. El cuerpo queda vacío por ahora.
— Anota cada uno con @RepositorCrear los repositorios
— VueloRepository en el paquete repository — extiende JpaRepository
— PasajeroRepository en el paquete repository — extiende JpaRepository
— Ambos son interfaces, no clases. El cuerpo queda vacío por ahora.
— Anota cada uno con @Repositor
*/

import com.AerolineaAPI.Aerolinea.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long> {

}
