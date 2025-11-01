package com.proseca.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "registro_vacunacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroVacunacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer id;

    // Relación ManyToOne con Animal: Se usa @JsonBackReference para *IGNORAR* la referencia
    // al Animal al serializar el RegistroVacunacion. Esto rompe el bucle.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal")

    @JsonBackReference(value = "animal-vacunacion")
    private Animal animal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vacuna")
    // Nota: Si la entidad Vacuna también tiene una lista de RegistroVacunacion,
    // también necesitarías aplicar @JsonManagedReference/@JsonBackReference entre ellas.
    private Vacuna vacuna;

    @Column(name = "fecha_aplicacion")
    private LocalDate fechaAplicacion;

    private String responsable;
}