package com.patron.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Usuario {
	
	@Id
	@Column(name = "user_id")
	private String id;
	
	@Column(name = "user_name")
    private String name;
    
	@Column(name = "user_email")
    private String email;

}
