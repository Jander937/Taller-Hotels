package com.co.buritica.hotels.services;

import com.co.buritica.hotels.models.dtos.SuiteDTO;

import java.util.List;

public interface SuitesService {
    //rf4
    Boolean add(SuiteDTO suitesData);

    //rf5
    Boolean delete(Integer id);

    //rf6
    List<Object[]> moreReservaction();
}
