package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.HotelDTO;

public interface HotelsService {

     Boolean add(HotelDTO hotelData);

     Boolean delete(Integer id);
}
