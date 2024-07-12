package com.patron.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patron.dto.UsuarioDto;
import com.patron.service.IUsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/usuario/")
@AllArgsConstructor
public class UsuarioController {

	private final IUsuarioService usuarioService;
	
	@GetMapping("list-all")
    public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.consultarUsuarios());
    }
	
	@GetMapping("findByEmail/{email}")
    public ResponseEntity<UsuarioDto> findByEmail(@PathVariable(name = "email") String email) {
        return ResponseEntity.ok(usuarioService.consultarUsuarioEmail(null));
    }
	
	
}
