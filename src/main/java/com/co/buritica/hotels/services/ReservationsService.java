package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.models.dtos.SuitesDTO;
import com.co.buritica.hotels.models.dtos.UsersDTO;
import com.co.buritica.hotels.models.entities.*;
import com.co.buritica.hotels.repositories.ReservationsRepository;
import com.co.buritica.hotels.repositories.SuitesRepository;
import org.hibernate.mapping.Map;
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

    public List<ReservationDTO> getAllReservation(){
        List<ReservationDTO> result = new ArrayList<>();
        List<ReservationsEntity> reservationsEntities = reservationsRepository.findAll();

        for (ReservationsEntity date: reservationsEntities){
            ReservationDTO reservation = mapReservationsEntityToDTO(date);
            result.add(reservation);
        }
        return result;
    }

    private ReservationDTO mapReservationsEntityToDTO(ReservationsEntity date) {
        ReservationDTO reservartion = mapReservationsEntityToDTO(date);

        reservartion.setId(date.getId());
        reservartion.setStatus(date.getStatus());
        reservartion.setCheckInDate(date.getCheckInDate());
        reservartion.setCheckOutDate(date.getCheckOutDate());

        SuitesDTO suitesDTO = new SuitesDTO();

        suitesDTO.setHotelId(date.getSuitesEntity().getId());
        suitesDTO.setStatus(date.getSuitesEntity().getStatus());
        suitesDTO.setHeating(date.getSuitesEntity().getHeating());
        suitesDTO.setPhone(date.getSuitesEntity().getPhone());
        suitesDTO.setNumber(date.getSuitesEntity().getNumber());
        suitesDTO.setPrivateBathroom(date.getSuitesEntity().getPrivateBathroom());
        suitesDTO.setSuiteTypesId(date.getSuitesEntity().getSuiteTypesEntity().getId());

        reservartion.setSuite(suitesDTO);

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setDocument(date.getUsersEntity().getDocument());
        usersDTO.setNames(date.getUsersEntity().getNames());
        usersDTO.setSurname(date.getUsersEntity().getSurname());
        usersDTO.setPhone(date.getUsersEntity().getPhone());
        usersDTO.setStatus(date.getUsersEntity().getStatus());

        reservartion.setUser(usersDTO);

        return reservartion;
    }
}
