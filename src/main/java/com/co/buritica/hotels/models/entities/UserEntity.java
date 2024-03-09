package com.co.buritica.hotels.models.entities;


import jakarta.persistence.*;

import lombok.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "documento")
    private Long document;

    @Column(name = "nombres")
    private String names;

    @Column(name = "primer_apellido")
    private String surname;

    @Column(name = "segundo_apellido")
    private String secondSurname;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono")
    private String phone;


    @Column(name = "correo")
    private String email;

    @Column(name = "clave")
    private String password;

    @Column(name = "estado", columnDefinition = "TINYINT")
    private Boolean status;

    @ManyToOne
    @JoinColumn (name = "tbl_tipos_documento_id")
    private DocumentTypesEntity documentTypesEntity;

    @ManyToOne
    @JoinColumn(name = "tbl_ciudades_codigo")
    private CitiesEntity citiesEntity;

    @ManyToOne
    @JoinColumn(name = "tbl_tipos_usuarios_id")
    private UserTypesEntity userTypesEntity;

}
