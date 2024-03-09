package com.co.buritica.hotels.models.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long document;

    private String names;

    private String surname;

    private String secondSurname;

    private String address;

    private String phone;

    private String email;

    private String password;

    private String status;

}
