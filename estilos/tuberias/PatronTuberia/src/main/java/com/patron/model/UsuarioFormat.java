package com.patron.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario_format")
@Builder
public class UsuarioFormat {
	
	@Id
	@Column(name = "user_format_id")
	private String id;
	
	@Column(name = "user_format_user")
    private String name;
    
	@Column(name = "user_format_email")
    private String email;

}
