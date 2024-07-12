package com.patron.service;

import java.util.List;

import com.patron.dto.UsuarioDto;

public interface IUsuarioService {
	
	List<UsuarioDto> consultarUsuarios();

	UsuarioDto consultarUsuarioEmail(String email);	
}
