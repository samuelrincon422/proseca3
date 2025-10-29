package com.proseca.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "produccion_de_leche")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduccionDeLeche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produccion")
    private Integer id;

    // Usamos @JsonBackReference para evitar el bucle con Animal
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_animal")
    @JsonBackReference(value = "animal-leche")
    private Animal animal;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "cantidad_litros")
    private Double cantidadLitros;
}