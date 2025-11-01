package com.proseca.app.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FincaDTO {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private String propietario;


}
