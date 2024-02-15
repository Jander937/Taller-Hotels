package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.SuitesDTO;
import com.co.buritica.hotels.services.SuitesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Optional;

@RestController
public class SuitesController {

    private final SuitesService suitesService;

    // Inyecta SuitesService en el constructor
    public SuitesController(SuitesService suitesService) {
        this.suitesService = suitesService;
    }
    @PostMapping("/suites")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<SuitesDTO> save(@RequestBody SuitesDTO suitesData) {

        Boolean result = suitesService.add(suitesData);

        if (result){
            return Optional.of(suitesData);
        }


        return Optional.empty();

    }
    @DeleteMapping(value = "/suites/10")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<EntityResponse<?>> delete(){

        Boolean result = suitesService.delete(10);

        if(result){
            return Optional.empty();
        }
        return Optional.empty();
    }

}
