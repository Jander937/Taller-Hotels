package com.co.buritica.hotels.models.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDTO {

    private Long document;

    private String names;

    private String surname;

    private String secondSurname;

    private String address;

    private String phone;

    private String email;

    private String password;

    private Integer status;
}
