package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <ReservationEntity, Integer> {
}
