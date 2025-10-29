package com.proseca.app.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduccionDeLecheDTO {
    private Integer animalId;
    private LocalDate fechaRegistro;
    private Double cantidadLitros;
}