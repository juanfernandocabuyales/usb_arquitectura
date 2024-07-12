package com.patron.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patron.service.ETLService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/etl/")
@AllArgsConstructor
public class ETLController {

	private final ETLService etlService;
	
	@PostMapping("transformacion")
    public ResponseEntity<String> listarUsuarios() {
		etlService.iniciarTransformacionData();
        return ResponseEntity.ok("Se ha iniciado el proceso de transformacion");
    }
}
