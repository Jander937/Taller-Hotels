package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.ReservationDTO;

import java.util.List;

public interface ReservationsService {
    List<ReservationDTO> getAll();
}
