package com.proseca.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "evento_de_salud")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoDeSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer id;

    // Relación ManyToOne con Animal: Se usa @JsonBackReference para *IGNORAR* la referencia
    // al Animal al serializar el Evento.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal")
    @JsonBackReference(value = "animal-salud")
    private Animal animal;

    private String descripcion;
    private String tipoEvento;
    private LocalDate fecha;
}

