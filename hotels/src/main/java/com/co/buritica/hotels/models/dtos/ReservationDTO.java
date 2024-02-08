package com.co.buritica.hotels.models.dtos;

import com.co.buritica.hotels.models.entities.SuitesEntity;
import com.co.buritica.hotels.models.entities.UsersEntity;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ReservationDTO {


    private Date admissionDate;

    private Date departureDate;

    private String status;

    private SuitesEntity suitesEntity;

    private UsersEntity usersEntity;

}
