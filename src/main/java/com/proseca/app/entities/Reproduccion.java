package com.proseca.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "reproduccion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reproduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reproduccion")
    private Integer id;

    // Relación ManyToOne con Animal: Se usa @JsonBackReference para *IGNORAR* la referencia
    // al Animal al serializar la Reproduccion.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal")
    @JsonBackReference(value = "animal-reproduccion")
    private Animal animal;

    private String tipoEvento;
    private LocalDate fecha;
    private String observaciones;
}

