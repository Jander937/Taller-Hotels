package com.co.buritica.hotels.models.dtos;

import com.co.buritica.hotels.models.entities.ReservationEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class ObservationDTO {

    private Integer type;

    private String observation;

    private Timestamp date;

    private ReservationEntity reservationsEntity;
}
