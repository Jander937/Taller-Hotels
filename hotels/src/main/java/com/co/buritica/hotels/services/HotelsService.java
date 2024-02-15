package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.HotelDTO;
import com.co.buritica.hotels.models.entities.CitiesEntity;
import com.co.buritica.hotels.models.entities.HotelsEntity;
import com.co.buritica.hotels.repositories.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HotelsService {

    @Autowired
    private HotelsRepository hotelsRepository;


    //rf1
    public Boolean add(HotelDTO hotelData){

        HotelsEntity hotelsEntity = new HotelsEntity();

        hotelsEntity.setId(((int) hotelsRepository.count()) +1);

        hotelsEntity.setAddress(hotelData.getAddress());
        hotelsEntity.setPhones(hotelData.getPhones());
        hotelsEntity.setNeighborhood(hotelData.getNeighborhood());

        CitiesEntity citiesEntity = new CitiesEntity();

        citiesEntity.setId(hotelData.getCityId());
        hotelsEntity.setCitiesEntity(citiesEntity);



        HotelsEntity result = hotelsRepository.save(hotelsEntity);

        return (result.getCitiesEntity().getName() != null);
    }

    //rf3
    public Boolean delete(Integer id){

        // Verifica si el hotel fue eliminado correctamente
        Optional<HotelsEntity> deletedHotel = hotelsRepository.findById(id);

        if (deletedHotel.isEmpty())
        return false;

        // Elimina el hotel con el ID proporcionado
        hotelsRepository.deleteById(id);


        return true;
    }
}
