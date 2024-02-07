package com.co.buritica.hotels.repositories;


import com.co.buritica.hotels.models.entities.ObservationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationsRepository extends JpaRepository <ObservationsEntity, Integer> {
}
