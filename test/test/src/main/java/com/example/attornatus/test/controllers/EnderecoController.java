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

import com.example.attornatus.test.entities.Endereco;
import com.example.attornatus.test.services.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;

	@PostMapping("/{pessoaId}/addEndereco")
	private ResponseEntity<Endereco> addEndereco(@PathVariable Long pessoaId, @RequestBody Endereco endereco) {
		return new ResponseEntity<>(enderecoService.addEndereco(pessoaId, endereco), HttpStatus.CREATED);
	}

	@GetMapping("/{pessoaId}")
	private ResponseEntity<List<Endereco>> listarEnderecos(@PathVariable Long pessoaId) {
		return ResponseEntity.ok(enderecoService.listAddressByUser(pessoaId));
	}
	
	@PutMapping("/{pessoaId}/{enderecoId}")
	private ResponseEntity<Endereco> enderecoPrincipal(@PathVariable Long pessoaId, @PathVariable Long enderecoId){
		return ResponseEntity.ok(enderecoService.enderecoPrincipal(pessoaId, enderecoId));
	}
}