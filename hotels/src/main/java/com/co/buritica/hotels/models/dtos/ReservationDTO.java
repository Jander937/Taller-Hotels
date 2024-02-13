package com.co.buritica.hotels.models.dtos;

import com.co.buritica.hotels.models.entities.SuitesEntity;
import com.co.buritica.hotels.models.entities.UsersEntity;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReservationDTO {

    private Integer id;

    private Date admissionDate;

    private Date departureDate;

    private String status;

    private SuitesEntity suitesEntity;

    private UsersEntity usersEntity;

}
