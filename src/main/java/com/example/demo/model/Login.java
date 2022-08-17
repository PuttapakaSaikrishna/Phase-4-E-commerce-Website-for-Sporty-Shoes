package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Login {
@Id
	private int id;
	private String username;
	private String password;
}
