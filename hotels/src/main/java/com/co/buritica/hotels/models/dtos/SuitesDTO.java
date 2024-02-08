package com.co.buritica.hotels.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuitesDTO {


    private Integer number;

    private Boolean privateBathroom;

    private Boolean phone;

    private Boolean heating;

    private String status;

    private Integer hotelId;

    private Integer suitesTypesId;

}
