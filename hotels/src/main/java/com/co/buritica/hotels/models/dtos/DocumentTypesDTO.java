package com.co.buritica.hotels.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentTypesDTO {

    private Integer id;

    private String name;

    private String initials;
}
