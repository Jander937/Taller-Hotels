package com.co.buritica.hotels.models.dtos;

import com.co.buritica.hotels.models.entities.SuitesEntity;
import com.co.buritica.hotels.models.entities.UsersEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
public class ReservationDTO {

    private Integer id;

    private Date checkInDate;

    private Date checkOutDate;

    private String status;

    private SuitesDTO suite;

    private UsersDTO user;

}
