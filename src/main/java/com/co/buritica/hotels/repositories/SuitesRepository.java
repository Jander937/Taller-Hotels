package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.SuitesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuitesRepository extends JpaRepository<SuitesEntity, Integer> {
}
