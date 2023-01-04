package com.example.attornatus.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attornatus.test.entities.Pessoa;
import com.example.attornatus.test.repositories.PessoaRepository;
import com.example.attornatus.test.services.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa savePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa updatePessoa(Long id, Pessoa pessoa) {
		Pessoa pessoaUpdated = pessoaRepository.findById(id).get();
		pessoaUpdated.setNome(pessoa.getNome());
		pessoaUpdated.setNascimento(pessoa.getNascimento());
		return pessoaRepository.save(pessoaUpdated);
	}

	@Override
	public Pessoa findByIdPessoa(Long id) {
		return pessoaRepository.findById(id).get();
	}

	@Override
	public List<Pessoa> listPessoa() {
		return pessoaRepository.findAll();
	}
}