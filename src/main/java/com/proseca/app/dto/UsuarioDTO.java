package com.proseca.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
}
