package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.HotelDTO;
import com.co.buritica.hotels.services.HotelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Optional;


@RestController
public class HotelsController {

    @Autowired
    private HotelsService hotelsService;


    @PostMapping("/hotels")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<HotelDTO> save(@RequestBody HotelDTO hotelData) {

        Boolean result = hotelsService.add(hotelData);

        if (result){
            return Optional.of(hotelData);
        }


        return Optional.empty();

    }

    @DeleteMapping
    public Optional<EntityResponse<?>> delete(@PathVariable int id){

        Boolean result = hotelsService.delete(id);

        if(result){
            return Optional.empty();
        }
        return Optional.empty();
    }

}
