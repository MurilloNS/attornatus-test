package com.example.attornatus.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attornatus.test.entities.Pessoa;
import com.example.attornatus.test.services.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
	@Autowired
	private PessoaService pessoaService;

	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
		return new ResponseEntity<>(pessoaService.savePessoa(pessoa), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.updatePessoa(id, pessoa));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaService.findByIdPessoa(id));
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoas() {
		return ResponseEntity.ok(pessoaService.listPessoa());
	}
}