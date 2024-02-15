package com.co.buritica.hotels.models.dtos;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SuitesTypesDTO {

    private String name;

    private String description;
}
