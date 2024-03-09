package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.repositories.SuiteRepository;
import com.co.buritica.hotels.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @Autowired
    private SuiteRepository suitesRepository;

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


}
