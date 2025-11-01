package com.proseca.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "animal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Integer id;

    private String nombre;
    private String especie;
    private String raza;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    //private Integer id_finca;

    // Relación ManyToOne con Finca: Se usa @JsonBackReference para evitar el bucle Finca -> Animal.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_finca")
    @JsonBackReference(value = "finca-animal")
    private Finca finca;

    // Relación OneToMany con RegistrosVacunacion: Se usa @JsonManagedReference para incluir la lista.
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference(value = "animal-vacunacion")
    private List<RegistroVacunacion> registrosVacunacion;

    // AÑADIDO: Listas de otras relaciones OneToMany con @JsonManagedReference para evitar bucles.
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference(value = "animal-reproduccion")
    private List<Reproduccion> registrosReproduccion;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference(value = "animal-salud")
    private List<EventoDeSalud> eventosDeSalud;
}
