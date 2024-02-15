package com.co.buritica.hotels.models.dtos;

import com.co.buritica.hotels.models.entities.ReservationsEntity;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class ObservationsDTO {


    private Integer type;


    private String observation;


    private Timestamp date;


    private ReservationsEntity reservationsEntity;
}
