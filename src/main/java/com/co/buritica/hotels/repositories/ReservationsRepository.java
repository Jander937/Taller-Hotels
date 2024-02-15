package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.ReservationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationsRepository extends JpaRepository <ReservationsEntity, Integer> {
}
