package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository <HotelEntity, Integer> {
}
