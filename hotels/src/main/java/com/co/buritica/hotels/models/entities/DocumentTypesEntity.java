package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tbl_tipos_documento")
public class DocumentTypesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "sigla")
    private String initials;
}
