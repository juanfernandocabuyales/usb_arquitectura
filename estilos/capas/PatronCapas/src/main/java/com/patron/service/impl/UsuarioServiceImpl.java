package com.patron.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.patron.dto.UsuarioDto;
import com.patron.model.Usuario;
import com.patron.repository.IUsuarioRepository;
import com.patron.service.IUsuarioService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements IUsuarioService {

	private IUsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDto> consultarUsuarios() {
		List<UsuarioDto> listUsuariosDto = new ArrayList<>();
		try {
			List<Usuario>listUsuario = usuarioRepository.findAll();
			if(null == listUsuario) {
				return new ArrayList<>();
			}
			listUsuariosDto = listUsuario.stream().map(item -> UsuarioDto.builder().correo(item.getEmail()).identificacion(item.getId()).nombre(item.getName()).build()).toList();
		}catch(Exception e) {
			log.error("Se presento un error en la consulta",e);
		}
		return listUsuariosDto;
	}

	@Override
	public UsuarioDto consultarUsuarioEmail(String email) {
		try {
			Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
			if(null != usuario) {
				return UsuarioDto.builder().correo(usuario.getEmail()).identificacion(usuario.getId()).nombre(usuario.getName()).build();
			}
		}catch(Exception e) {
			log.error("Se presento un error en la consulta",e);
		}
		return null;
	}

}
