package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.SuitesDTO;
import com.co.buritica.hotels.models.entities.HotelsEntity;
import com.co.buritica.hotels.models.entities.SuitesEntity;
import com.co.buritica.hotels.models.entities.SuitesTypesEntity;
import com.co.buritica.hotels.repositories.SuitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuitesService {

    @Autowired
    private SuitesRepository suitesRepository;

    //rf4
    public Boolean add (SuitesDTO suitesData){

        SuitesEntity suitesEntity = new SuitesEntity();

        HotelsEntity hotelsEntity = new HotelsEntity();

        hotelsEntity.setId(suitesData.getHotelId());
        suitesEntity.setHotelsEntity(hotelsEntity);

        SuitesTypesEntity suitesTypesEntity = new SuitesTypesEntity();

        suitesTypesEntity.setId(suitesData.getSuiteTypesId());
        suitesEntity.setSuiteTypesEntity(suitesTypesEntity);

        suitesEntity.setNumber(suitesData.getNumber());
        suitesEntity.setPrivateBathroom(suitesData.getPrivateBathroom());
        suitesEntity.setPhone(suitesData.getPhone());
        suitesEntity.setHeating(suitesData.getHeating());
        suitesEntity.setStatus(suitesData.getStatus());


        SuitesEntity result = suitesRepository.save(suitesEntity);

        return (result != null);
    }

    //rf5
    public Boolean delete (Integer id){
        // Verifica si el hotel fue eliminado correctamente
        Optional<SuitesEntity> deleteSuites = suitesRepository.findById(id);

        if(deleteSuites.isEmpty())
            return false;

        //TODO:Controlar la excepcion cuando no se puede eliminar la excepcion.

        // Elimina el hotel con el ID proporcionado
        suitesRepository.deleteById(id);

        return true;
    }
}
