package com.co.buritica.hotels.models.dtos;

import com.co.buritica.hotels.models.entities.CitiesEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelDTO {


    private String neighborhood;

    private String address;

    private String phones;

    private Integer cityId;
}
