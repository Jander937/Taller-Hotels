package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.ReservationsEntity;
import com.co.buritica.hotels.models.entities.SuitesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuitesRepository extends JpaRepository<SuitesEntity, Integer> {
    @Query("SELECT r FROM ReservationsEntity r " +
            "JOIN FETCH r.suitesEntity h " +
            "JOIN FETCH h.suiteTypesEntity th " +
            "WHERE r.id = :reservaId")
    ReservationsEntity findReservaByIdWithHabitacionAndTipoHabitacion(Long reservaId);
    @Query("SELECT COUNT(h.suiteTypesEntity.id) AS totalHabitaciones, th.id AS codigo, th.name AS tipoHabitacion " +
            "FROM SuitesEntity h " +
            "JOIN h.suiteTypesEntity th " +
            "WHERE h.status = 'RESERVADA' " +
            "GROUP BY th.id, th.name " +
            "ORDER BY COUNT(h.suiteTypesEntity.id) DESC")
    List<Object[]> findTipoHabitacionMasReservada();

}

