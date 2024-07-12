package com.patron.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.patron.model.Usuario;
import com.patron.model.UsuarioFormat;
import com.patron.repository.IUsuarioFormatRepository;
import com.patron.repository.IUsuarioRepository;
import com.patron.service.ETLService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ETLServiceImpl implements ETLService {
	
	private final IUsuarioRepository usuarioRepository;
	
	private final IUsuarioFormatRepository usuarioFormatRepository;
	
	@Override
	public void iniciarTransformacionData() {
		try {
			List<Usuario> listUsuarios = usuarioRepository.findAll();
			if(null != listUsuarios && !listUsuarios.isEmpty()) {
				listUsuarios.stream().forEach(usuario -> {
					UsuarioFormat usuarioFormat = UsuarioFormat.builder()
							.id(usuario.getId() + "F")
							.name(usuario.getName().toUpperCase())
							.email(usuario.getEmail().split("@")[0])
							.build();
					usuarioFormatRepository.save(usuarioFormat);
				});
			}
		}catch(Exception e) {
			log.error("Se presento un error en la transformacion de la data",e);
		}
	}

}
