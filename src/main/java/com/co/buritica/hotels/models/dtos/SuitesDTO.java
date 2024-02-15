package com.co.buritica.hotels.models.dtos;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SuitesDTO {


    private Integer number;

    private Boolean privateBathroom;

    private Boolean phone;

    private Boolean heating;

    private String status;

    private Integer hotelId;

    private Integer suiteTypesId;

}
