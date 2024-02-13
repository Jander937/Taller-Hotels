package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tbl_sedes_hotel")
public class HotelsEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "barrio")
    private String neighborhood;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefonos")
    private String phones;

    @OneToOne
    @JoinColumn (name = "tbl_ciudades_codigo")
    private CitiesEntity citiesEntity;

}
