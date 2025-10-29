package com.proseca.app.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "finca")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Finca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_finca")
    private Integer id;

    private String nombre;
    private String ubicacion;
    private String propietario;

    // Relación OneToMany con Animal: Se usa @JsonManagedReference para incluir la lista.
    @OneToMany(mappedBy = "finca", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "finca-animal")
    private List<Animal> animales;
}
