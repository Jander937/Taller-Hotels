package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "tbl_observaciones")
public class ObservationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;
    @Column(name = "tipo")
    private Integer type;
    @Column(name = "observacion")
    private String observation;
    @Column(name = "fecha")
    private Date date;
    @JoinColumn(name = "tbl_reservas_id")
    private ReservationsEntity reservationsEntity;
}
