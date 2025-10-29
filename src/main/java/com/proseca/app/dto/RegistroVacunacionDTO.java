package com.proseca.app.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroVacunacionDTO {
    private Integer id;
    private Integer animalId;
    private Integer vacunaId;
    private Integer usuarioId;
    private LocalDate fecha;
    private String observaciones;
}
