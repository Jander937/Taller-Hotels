package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.models.entities.ReservationsEntity;
import com.co.buritica.hotels.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    //rf2

    //findAllReservations(): funcion para encontrar todas las reservas

    // Consultar todas las reservas

    //findAll:para recuperar todas las entidades de una tabla de la base de datos
    // sin necesidad de escribir una consulta SQL manualmente.

    //Aquí, reservationEntities.stream() crea un flujo a partir de la lista de entidades
    //de reservas, luego map(this::mapEntityToDTO) aplica la función mapEntityToDTO a cada
    //elemento del flujo, y finalmente collect(Collectors.toList()) recolecta los elementos
    //resultantes en una lista.

    public List<ReservationDTO> findAllReservations(){

        List<ReservationsEntity> reservationEntities = reservationsRepository.findAll();

        // Mapear las entidades de reservas a DTOs de reservas
        List<ReservationDTO> reservationDTOs = reservationEntities.stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());

        return reservationDTOs;
    }

    //mapear

    private ReservationDTO mapEntityToDTO(ReservationsEntity reservationsEntity) {
        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setAdmissionDate(reservationsEntity.getAdmissionDate());
        reservationDTO.setDepartureDate(reservationsEntity.getDepartureDate());
        reservationDTO.setStatus(reservationsEntity.getStatus());
        reservationDTO.setSuitesEntity(reservationsEntity.getSuitesEntity());
        reservationDTO.setUsersEntity(reservationsEntity.getUsersEntity());

        return reservationDTO;
    }

    //rf6
    public String getMostReservedRoomType(){
        // Consultar las reservas de la base de datos
        List<ReservationsEntity> reservations = reservationsRepository.findAll();

        // Contar el número de reservas por tipo de habitación

        //Se utiliza la API de Streams de Java para agrupar las reservas por el nombre
        // del tipo de habitación (SuitesTypesEntity) y contar cuántas reservas hay para
        // cada tipo de habitación. Se utiliza un Map donde la clave es el nombre del tipo
        // de habitación y el valor es el número de reservas.
        Map<String, Long> roomTypeCounts = reservations.stream()
                .collect(Collectors.groupingBy(reservation -> reservation.getSuitesEntity().getSuitesTypesEntity().getName(),
                        Collectors.counting()));

        // Encontrar el tipo de habitación con el mayor número de reservas

       // Se utiliza la API de Streams de Java para encontrar la entrada del Map con el valor
        // máximo (es decir, el tipo de habitación con más reservas). Luego, se extrae la clave
        // (nombre del tipo de habitación) de esta entrada y se asigna a la variable
        // mostReservedRoomType. Si no hay reservas, se devuelve un mensaje indicando que no hay
        // reservas.
        String mostReservedRoomType = roomTypeCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No hay reservas");

        return mostReservedRoomType;
    }

}
