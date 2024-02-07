package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_reservas")
public class ReservationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "fecha_ingreso")
    private Date admissionDate;

    @Column(name = "fecha_salida")
    private Date departureDate;

    @Column(name = "estado")
    private String status;

    @OneToMany
    @JoinColumn(name = "tbl_habitaciones_id")
    private SuitesEntity suitesEntity;

    @OneToOne
    @JoinColumn(name = "tbl_usuarios_id")
    private UsersEntity usersEntity;
}
