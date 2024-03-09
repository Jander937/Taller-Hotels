package com.co.buritica.hotels.services.impl;

import com.co.buritica.hotels.models.dtos.SuiteDTO;
import com.co.buritica.hotels.models.entities.HotelEntity;
import com.co.buritica.hotels.models.entities.SuiteEntity;
import com.co.buritica.hotels.models.entities.SuiteTypesEntity;
import com.co.buritica.hotels.repositories.SuiteRepository;
import com.co.buritica.hotels.repositories.SuiteTypesRepository;
import com.co.buritica.hotels.services.SuitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuitesServiceImpl implements SuitesService {

    @Autowired
    private SuiteRepository suitesRepository;

    @Autowired
    private SuiteTypesRepository suitesTypesRepository;

    public SuitesServiceImpl(SuiteTypesRepository suitesTypesRepository) {
        this.suitesTypesRepository = suitesTypesRepository;
    }
    //rf4
    @Override
    public Boolean add(SuiteDTO suitesData){

        SuiteEntity suitesEntity = new SuiteEntity();

        HotelEntity hotelsEntity = new HotelEntity();

        hotelsEntity.setId(suitesData.getHotelId());
        suitesEntity.setHotelsEntity(hotelsEntity);

        SuiteTypesEntity suitesTypesEntity = new SuiteTypesEntity();

        suitesTypesEntity.setId(suitesData.getSuiteTypesId());
        suitesEntity.setSuiteTypesEntity(suitesTypesEntity);

        suitesEntity.setNumber(suitesData.getNumber());
        suitesEntity.setPrivateBathroom(suitesData.getPrivateBathroom());
        suitesEntity.setPhone(suitesData.getPhone());
        suitesEntity.setHeating(suitesData.getHeating());
        suitesEntity.setStatus(suitesData.getStatus());


        SuiteEntity result = suitesRepository.save(suitesEntity);

        return (result != null);
    }

    //rf5
    @Override
    public Boolean delete(Integer id){
        // Verifica si el hotel fue eliminado correctamente
        Optional<SuiteEntity> deleteSuites = suitesRepository.findById(id);

        if(deleteSuites.isEmpty())
            return false;

        //TODO:Controlar la excepcion cuando no se puede eliminar la excepcion.

        // Elimina el hotel con el ID proporcionado
        suitesRepository.deleteById(id);

        return true;
    }

    //rf6
    @Override
    public  List<Object[]> moreReservaction(){
       return suitesRepository.findTypeRoomMostReserved();
    }
}
