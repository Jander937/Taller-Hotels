package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_ciudades")
public class CitiesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer code;
    @Column(name = "nombre")
    private String name;
}
