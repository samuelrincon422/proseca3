package com.proseca.app.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoDeSaludDTO {
    private Integer idAnimal;
    private LocalDate fecha;
    private String descripcion;
    private String tratamiento;
}