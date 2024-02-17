package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.SuitesDTO;
import com.co.buritica.hotels.models.entities.HotelsEntity;
import com.co.buritica.hotels.models.entities.SuitesEntity;
import com.co.buritica.hotels.models.entities.SuitesTypesEntity;
import com.co.buritica.hotels.repositories.SuitesRepository;
import com.co.buritica.hotels.repositories.SuitesTypesRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SuitesService {

    @Autowired
    private SuitesRepository suitesRepository;

    @Autowired
    private SuitesTypesRepository suitesTypesRepository;

    public SuitesService(SuitesTypesRepository suitesTypesRepository) {
        this.suitesTypesRepository = suitesTypesRepository;
    }
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

    //rf6


//    public List<SuitesDTO> convertEntitiesToDTOs(List<SuitesEntity> suitesEntities) {
//        List<SuitesDTO> suitesDTOs = new ArrayList<>();
//        for (SuitesEntity entity : suitesEntities) {
//            SuitesDTO dto = new SuitesDTO();
//            // Copiar los datos de la entidad al DTO
//            dto.setId(entity.getId());
//            dto.setNumber(entity.getNumber());
//            dto.setPrivateBathroom(entity.getPrivateBathroom());
//            dto.setPhone(entity.getPhone());
//            dto.setHeating(entity.getHeating());
//            dto.setStatus(entity.getStatus());
//            // Añadir el DTO a la lista
//            suitesDTOs.add(dto);
//        }
//        return suitesDTOs;
//    }
//    @Transactional
//    public List<SuitesDTO> moreReserved() {
//        // Obtener la entidad SuitesTypesEntity
//        SuitesTypesEntity suitesTypesEntity = suitesTypesRepository.findById(1).orElse(null);
//
//        // Manejar null
//        if (suitesTypesEntity == null) {
//            return Collections.emptyList();
//        }
//
//        // Inicializar la colección suitesEntities
//        Hibernate.initialize(suitesTypesEntity.getSuitesEntities());
//
//        // Acceder a la colección suitesEntities
//        List<SuitesEntity> suitesEntities = suitesTypesEntity.getSuitesEntities();
//
//        // Convertir las entidades a DTOs
//        List<SuitesDTO> suitesDTOs = convertEntitiesToDTOs(suitesEntities);
//
//        return suitesDTOs;
//    }

}
