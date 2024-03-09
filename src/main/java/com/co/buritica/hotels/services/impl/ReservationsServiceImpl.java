package com.co.buritica.hotels.services.impl;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.models.dtos.SuiteDTO;
import com.co.buritica.hotels.models.dtos.UserDTO;
import com.co.buritica.hotels.models.entities.*;
import com.co.buritica.hotels.repositories.ReservationRepository;
import com.co.buritica.hotels.repositories.SuiteRepository;
import com.co.buritica.hotels.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationsServiceImpl implements ReservationsService {

    //rf2

    @Autowired
    private ReservationRepository reservationsRepository;

    @Autowired
    private SuiteRepository suitesRepository;

    @Override
    public List<ReservationDTO> getAll() {

        List<ReservationDTO> result = new ArrayList<>();

        List<ReservationEntity> reservationsEntities = reservationsRepository.findAll();

        if (reservationsEntities.isEmpty())
            return result;

        for (ReservationEntity dato : reservationsEntities) {
            ReservationDTO reservation = new ReservationDTO();

            reservation.setId(dato.getId());
            reservation.setStatus(dato.getStatus());
            reservation.setCheckInDate(dato.getCheckInDate());
            reservation.setCheckOutDate(dato.getCheckOutDate());

            SuiteDTO suitesDTO = new SuiteDTO();

            suitesDTO.setHotelId(dato.getSuitesEntity().getId());
            suitesDTO.setStatus(dato.getSuitesEntity().getStatus());
            suitesDTO.setHeating(dato.getSuitesEntity().getHeating());
            suitesDTO.setPhone(dato.getSuitesEntity().getPhone());
            suitesDTO.setNumber(dato.getSuitesEntity().getNumber());
            suitesDTO.setPrivateBathroom(dato.getSuitesEntity().getPrivateBathroom());
            suitesDTO.setSuiteTypesId(dato.getSuitesEntity().getSuiteTypesEntity().getId());

            reservation.setSuite(suitesDTO);

            UserDTO usersDTO = new UserDTO();

            usersDTO.setDocument(dato.getUsersEntity().getDocument());
            usersDTO.setNames(dato.getUsersEntity().getNames());
            usersDTO.setSurname(dato.getUsersEntity().getSurname());
            usersDTO.setPhone(dato.getUsersEntity().getPhone());
            usersDTO.setStatus(String.valueOf(dato.getStatus()));

            reservation.setUser(usersDTO);

            result.add(reservation);
        }

        return result;
    }

    //rf6
}
