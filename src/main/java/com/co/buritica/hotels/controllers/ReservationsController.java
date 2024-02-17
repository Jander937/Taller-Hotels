package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    //rf2
    @GetMapping("/reservation")
    public Optional<ResponseEntity<List<ReservationDTO>>> all () {
        List<ReservationDTO> result = reservationsService.getAll();

        //TODO: 1. Hacer la paginacion
        //TODO: 2. Aplicar filtros(ordenar filtrar por nombres)

        if (!result.isEmpty()) {
            return Optional.of(ResponseEntity.ok().body(result));
        }
        return Optional.of(ResponseEntity.noContent().build());

    }
    //rf6

    @GetMapping("/moreReserved")
    public ResponseEntity<List<ReservationDTO>> moreReserved (){
        List<ReservationDTO> allReservations = reservationsService.getAllReservation();

        if (!allReservations.isEmpty()){

            Map<Integer, Integer> roomReservationCounts = new HashMap<>();
            for (ReservationDTO reservation : allReservations){
                int roomId = reservation.getSuite().getId();
                roomReservationCounts.put(roomId, roomReservationCounts.getOrDefault(roomId, 0) + 1);
            }
            Integer mostReservedRoomId = Collections.max(roomReservationCounts.entrySet(), Map.Entry.comparingByValue()).getKey();

            List<ReservationDTO> mostReservedRommReservations = allReservations.stream()
                    .filter(reservation -> reservation.getSuite().getId() == mostReservedRoomId)
                    .collect(Collectors.toList());

            return ResponseEntity.ok().body(mostReservedRommReservations);

        }else{

            return ResponseEntity.noContent().build();
        }
    }
}
