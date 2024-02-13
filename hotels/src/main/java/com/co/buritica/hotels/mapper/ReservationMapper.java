package com.co.buritica.hotels.mapper;

import com.co.buritica.hotels.models.dtos.ReservationDTO;
import com.co.buritica.hotels.models.entities.ReservationsEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

    @Mappings( {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "admissionDate", target = "admissionDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
                    @Mapping(source = "departureDate", target = "departureDate", dateFormat = "yyyy-MM-dd HH:mm:ss"),
                    @Mapping(source = "status", target = "status"),
                    @Mapping(source = "suitesEntity", target = "suitesEntity"),
                    @Mapping(source = "usersEntity", target = "usersEntity")
            } )

    ReservationDTO toGetDTO(ReservationsEntity reservationsEntity);

    @InheritInverseConfiguration
    ReservationsEntity toEntity(ReservationDTO reservationDTO);
}
