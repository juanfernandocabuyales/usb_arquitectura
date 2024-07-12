package com.patron.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patron.model.UsuarioFormat;

public interface IUsuarioFormatRepository extends JpaRepository<UsuarioFormat, String> {

}