package com.proseca.app.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class RegistroVacunacionRequestDTO {
    private Integer animalId;
    private Integer vacunaId;
    private LocalDate fechaAplicacion;
    private String responsable;
}
