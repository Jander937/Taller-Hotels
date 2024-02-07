package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_habitaciones")
public class SuitesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "banio_privado")
    private Boolean privateBathroom;

    @Column(name = "telefono")
    private Boolean phone;

    @Column(name = "calefaccion")
    private Boolean heating;

    @Column(name = "estado")
    private String status;

    @ManyToOne
    @JoinColumn(name = "tbl_sedes_hotel_id")
    private HotelsEntity hotelsEntity;

    @JoinColumn(name = "tdl_tipos_habitaciones_id")
    private SuitesTypesEntity suitesTypesEntity;
}
