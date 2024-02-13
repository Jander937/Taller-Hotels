package com.co.buritica.hotels.models.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SuitesDTO {


    private Integer number;

    private Boolean privateBathroom;

    private Boolean phone;

    private Boolean heating;

    private String status;

    private Integer hotelId;

    private Integer suitesTypesId;

}
