package com.proseca.app.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReproduccionDTO {
    private Integer idAnimal;
    private LocalDate fecha;
    private String tipoEvento; // "Inseminación", "Parto", etc.
    private String observaciones;
}

