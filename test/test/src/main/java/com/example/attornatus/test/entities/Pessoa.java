package com.example.attornatus.test.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_persons")
public class Pessoa {
	private Long id;
	private String nome;
	private Date nascimento;
}