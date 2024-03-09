package com.co.buritica.hotels.repositories;


import com.co.buritica.hotels.models.entities.ObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository <ObservationEntity, Integer> {
}
