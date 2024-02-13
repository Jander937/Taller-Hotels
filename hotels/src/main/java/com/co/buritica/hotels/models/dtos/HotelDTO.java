package com.co.buritica.hotels.models.dtos;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDTO {


    private String neighborhood;

    private String address;

    private String phones;

    private Integer cityId;
}
