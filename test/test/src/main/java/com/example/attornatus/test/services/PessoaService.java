package com.example.attornatus.test.services;

import java.util.List;

import com.example.attornatus.test.entities.Pessoa;

public interface PessoaService {
	public Pessoa savePessoa(Pessoa pessoa);

	public Pessoa updatePessoa(Long id, Pessoa pessoa);

	public Pessoa findByIdPessoa(Long id);
	
	public List<Pessoa> listPessoa();
}