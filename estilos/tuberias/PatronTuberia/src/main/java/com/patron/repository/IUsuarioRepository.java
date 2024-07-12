package com.patron.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patron.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {

	Optional<Usuario> findByEmail(String email);
}
