package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_sedes_hotel")
public class HotelsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "barrio")
    private String neighborhood;
    @Column(name = "direccion")
    private String adreess;
    @Column(name = "telefonos")
    private String phones;
    @Column(name = "tbl_ciudades_codigo")
    private CitiesEntity citiesEntity;
}
