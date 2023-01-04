package com.example.attornatus.test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.attornatus.test.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	@Query("SELECT e FROM Endereco e JOIN e.pessoas p WHERE p.id = :id")
	public List<Endereco> findEnderecoByPessoa(Long id);
}