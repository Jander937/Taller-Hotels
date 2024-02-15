package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.UserTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypesRepository extends JpaRepository <UserTypesEntity, Integer> {
}
