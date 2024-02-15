package com.co.buritica.hotels.models.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HotelDTO {


    private String neighborhood;

    private String address;

    private String phones;

    private Integer cityId;
}
