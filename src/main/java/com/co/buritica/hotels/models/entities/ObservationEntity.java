package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_observaciones")
public class ObservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "tipo", columnDefinition = "TINYINT")
    private Integer type;

    @Column(name = "observación")
    private String observation;

    @Column(name = "fecha")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "tbl_reservas_id")
    private ReservationEntity reservationsEntity;
}
