package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository <UserEntity, Integer> {
    UserEntity findByEmail(@Param(("email")) String email);
}
