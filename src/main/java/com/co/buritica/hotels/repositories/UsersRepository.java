package com.co.buritica.hotels.repositories;

import com.co.buritica.hotels.models.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <UsersEntity, Integer> {
}
