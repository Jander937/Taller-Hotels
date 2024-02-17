package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.repositories.SuitesRepository;
import com.co.buritica.hotels.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @Autowired
    private SuitesRepository suitesRepository;

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
    public ResponseEntity<?> obtenerTipoHabitacionMasReservada() {
        List<Object[]> result = suitesRepository.findTipoHabitacionMasReservada();

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Mapear los resultados a un DTO o clase de respuesta según sea necesario
        // Aquí puedes procesar los datos obtenidos del query y devolverlos en el cuerpo de la respuesta
        // Por ejemplo, podrías crear un DTO para representar los datos de tipo de habitación más reservado
        // y mapear los datos del array de objetos a ese DTO.

        return ResponseEntity.ok().body(result);
    }

}
