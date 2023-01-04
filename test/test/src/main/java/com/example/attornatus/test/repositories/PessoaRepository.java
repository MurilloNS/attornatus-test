package com.example.attornatus.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attornatus.test.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
}