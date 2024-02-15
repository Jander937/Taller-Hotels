package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_tipos_habitaciones")
public class SuitesTypesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;
}
