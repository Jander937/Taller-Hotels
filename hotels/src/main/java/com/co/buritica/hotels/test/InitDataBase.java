package com.co.buritica.hotels.test;

import com.co.buritica.hotels.models.entities.ReservationsEntity;
import com.co.buritica.hotels.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDataBase {
    @Autowired
    private ReservationsRepository reservationsRepository;
    @Bean
    public CommandLineRunner testReservationMapperCommand(){
        return args -> {
            List<ReservationsEntity> reservationsEntityList = reservationsRepository.findAll();

            System.out.println("PRODUCTS");
            reservationsEntityList.forEach(System.out::println);
        };
    }
}
