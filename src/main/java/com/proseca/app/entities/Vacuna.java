package com.proseca.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "vacuna")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacuna")
    private Integer id;

    private String nombre;
    private String descripcion;

    // Se usa @JsonManagedReference para incluir la lista de registros
    @OneToMany(mappedBy = "vacuna", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
     @JsonManagedReference(value = "vacuna-registro")
    private List<RegistroVacunacion> registros;
}