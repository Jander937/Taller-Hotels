package com.co.buritica.hotels.controllers;

import com.co.buritica.hotels.models.dtos.SuiteDTO;
import com.co.buritica.hotels.repositories.SuiteRepository;
import com.co.buritica.hotels.services.SuitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/suite")
public class SuitesController {

    @Autowired
    private SuitesService suitesService;

    @Autowired
    private SuiteRepository suitesRepository;

    //rf21

    //rf4
    @PostMapping("/suites")
    public Optional<SuiteDTO> save(@RequestBody SuiteDTO suitesData) {

        Boolean result = suitesService.add(suitesData);

        if (result){
            return Optional.of(suitesData);
        }

        return Optional.empty();

    }
    //rf5
    @DeleteMapping(value = "/suites/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){

        Boolean result = suitesService.delete(id);

        if(result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    //rf6
    @GetMapping("/moreReserved")
    public ResponseEntity<?>  moreReservaction (){
       List <Object[]> result = suitesService.moreReservaction ();

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
