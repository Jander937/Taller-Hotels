package com.co.buritica.hotels.models.dtos;


import lombok.*;

@Getter
@Setter
@ToString

public class SuitesDTO {

    private Integer id;

    private Integer number;

    private Boolean privateBathroom;

    private Boolean phone;

    private Boolean heating;

    private String status;

    private Integer hotelId;

    private Integer suiteTypesId;


}
