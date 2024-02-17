package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.models.dtos.SuitesDTO;
import com.co.buritica.hotels.models.dtos.UsersDTO;
import com.co.buritica.hotels.models.entities.*;
import com.co.buritica.hotels.repositories.ReservationsRepository;
import com.co.buritica.hotels.repositories.SuitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsService {

    //rf2

    @Autowired
    private ReservationsRepository reservationsRepository;

    @Autowired
    private SuitesRepository suitesRepository;

    public List<ReservationDTO> getAll() {

        List<ReservationDTO> result = new ArrayList<>();

        List<ReservationsEntity> reservationsEntities = reservationsRepository.findAll();

        if (reservationsEntities.isEmpty())
            return result;

        for (ReservationsEntity dato : reservationsEntities) {
            ReservationDTO reservation = new ReservationDTO();

            reservation.setId(dato.getId());
            reservation.setStatus(dato.getStatus());
            reservation.setCheckInDate(dato.getCheckInDate());
            reservation.setCheckOutDate(dato.getCheckOutDate());

            SuitesDTO suitesDTO = new SuitesDTO();

            suitesDTO.setHotelId(dato.getSuitesEntity().getId());
            suitesDTO.setStatus(dato.getSuitesEntity().getStatus());
            suitesDTO.setHeating(dato.getSuitesEntity().getHeating());
            suitesDTO.setPhone(dato.getSuitesEntity().getPhone());
            suitesDTO.setNumber(dato.getSuitesEntity().getNumber());
            suitesDTO.setPrivateBathroom(dato.getSuitesEntity().getPrivateBathroom());
            suitesDTO.setSuiteTypesId(dato.getSuitesEntity().getSuiteTypesEntity().getId());

            reservation.setSuite(suitesDTO);

            UsersDTO usersDTO = new UsersDTO();

            usersDTO.setDocument(dato.getUsersEntity().getDocument());
            usersDTO.setNames(dato.getUsersEntity().getNames());
            usersDTO.setSurname(dato.getUsersEntity().getSurname());
            usersDTO.setPhone(dato.getUsersEntity().getPhone());
            usersDTO.setStatus(dato.getUsersEntity().getStatus());

            reservation.setUser(usersDTO);

            result.add(reservation);
        }

        return result;
    }

    //rf6

}
