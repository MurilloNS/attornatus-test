package com.example.attornatus.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attornatus.test.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}