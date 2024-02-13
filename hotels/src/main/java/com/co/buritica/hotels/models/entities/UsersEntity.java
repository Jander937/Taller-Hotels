package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_usuarios")
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
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

    @Column(name = "estado")
    private Integer status;

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
