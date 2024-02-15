package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.SuitesDTO;
import com.co.buritica.hotels.services.SuitesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SuitesController {
    private SuitesService suitesService;

    @PostMapping("/suites")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<SuitesDTO> save(@RequestBody SuitesDTO suitesData) {

        Boolean result = suitesService.add(suitesData);

        if (result){
            return Optional.of(suitesData);
        }


        return Optional.empty();

    }

}
