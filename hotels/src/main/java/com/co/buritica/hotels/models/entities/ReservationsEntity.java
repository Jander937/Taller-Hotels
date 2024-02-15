package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_reservas")
public class ReservationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "fecha_ingreso")
    private Date checkInDate;

    @Column(name = "fecha_salida")
    private Date checkOutDate;

    @Column(name = "estado")
    private String status;

    @OneToOne
    @JoinColumn(name = "tbl_habitaciones_id")
    private SuitesEntity suitesEntity;

    @OneToOne
    @JoinColumn(name = "tbl_usuarios_id")
    private UsersEntity usersEntity;


}
