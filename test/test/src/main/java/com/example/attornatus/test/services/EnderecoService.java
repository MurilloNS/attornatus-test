package com.example.attornatus.test.services;

import java.util.List;

import com.example.attornatus.test.entities.Endereco;

public interface EnderecoService {
	public Endereco addEndereco(Long pessoaId, Endereco endereco);

	public List<Endereco> listAddressByUser(Long pessoaId);

	public Endereco enderecoPrincipal(Long pessoaId, Long enderecoId);
}