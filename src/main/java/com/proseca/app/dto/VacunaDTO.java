package com.proseca.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacunaDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
}