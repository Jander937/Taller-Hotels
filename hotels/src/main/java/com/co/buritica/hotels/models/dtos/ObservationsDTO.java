package com.co.buritica.hotels.models.dtos;

import com.co.buritica.hotels.models.entities.ReservationsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ObservationsDTO {


    private Integer type;


    private String observation;


    private Timestamp date;


    private ReservationsEntity reservationsEntity;
}
