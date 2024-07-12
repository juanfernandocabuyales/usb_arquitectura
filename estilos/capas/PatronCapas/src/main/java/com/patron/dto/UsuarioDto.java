package com.patron.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {

	private String identificacion;
	
	private String nombre;
	
	private String correo;
}
