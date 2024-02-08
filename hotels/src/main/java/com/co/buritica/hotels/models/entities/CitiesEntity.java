package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_ciudades")
public class CitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo", nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String name;
}
