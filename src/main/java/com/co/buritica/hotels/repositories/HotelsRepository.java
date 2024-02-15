package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.HotelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelsRepository extends JpaRepository <HotelsEntity, Integer> {
}
