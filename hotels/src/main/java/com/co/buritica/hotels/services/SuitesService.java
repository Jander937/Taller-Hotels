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

        suitesTypesEntity.setId(suitesData.getSuitesTypesId());
        suitesEntity.setSuitesTypesEntity(suitesTypesEntity);

        suitesEntity.setId(((int) suitesRepository.count()) +1);
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
        // Elimina el hotel con el ID proporcionado
        suitesRepository.deleteById(id);

        // Verifica si el hotel fue eliminado correctamente
        Optional<SuitesEntity> deletedSuites = suitesRepository.findById(id);
        return deletedSuites.isEmpty();
    }
}
