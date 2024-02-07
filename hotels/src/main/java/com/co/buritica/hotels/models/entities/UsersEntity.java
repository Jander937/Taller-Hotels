package com.co.buritica.hotels.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_tipos_usuarios")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "documento")
    private Long document;
    @Column(name = "nombres")
    private String names;
    @Column(name = "primer_apellido")
    private String surname;
    @Column(name = "segundo_apellido")
    private String second_surname;
    @Column(name = "direccion")
    private String adreess;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "correo")
    private String email;
    
}
