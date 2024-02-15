package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.SuitesDTO;
import com.co.buritica.hotels.services.SuitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class SuitesController {

    @Autowired
    private SuitesService suitesService;

    // Inyecta SuitesService en el constructor
//    public SuitesController(SuitesService suitesService) {
//        this.suitesService = suitesService;
//    }
    @PostMapping("/suites")
    public Optional<SuitesDTO> save(@RequestBody SuitesDTO suitesData) {

        Boolean result = suitesService.add(suitesData);

        if (result){
            return Optional.of(suitesData);
        }

        return Optional.empty();

    }
    @DeleteMapping(value = "/suites/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = suitesService.delete(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
