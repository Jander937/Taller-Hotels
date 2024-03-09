package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.SuiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuiteRepository extends JpaRepository<SuiteEntity, Integer> {

    @Query("SELECT COUNT(h.suiteTypesEntity.id) AS totalHabitaciones, th.id AS codigo, th.name AS tipoHabitacion " +
            "FROM SuiteEntity h " +
            "JOIN h.suiteTypesEntity th " +
            "WHERE h.status = 'RESERVADA' " +
            "GROUP BY th.id, th.name " +
            "ORDER BY COUNT(h.suiteTypesEntity.id)  DESC")
    List<Object[]> findTypeRoomMostReserved();

}

