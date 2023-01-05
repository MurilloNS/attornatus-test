package com.example.attornatus.test.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attornatus.test.entities.Endereco;
import com.example.attornatus.test.entities.Pessoa;
import com.example.attornatus.test.repositories.EnderecoRepository;
import com.example.attornatus.test.repositories.PessoaRepository;
import com.example.attornatus.test.services.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Endereco addEndereco(Long pessoaId, Endereco endereco) {
		Pessoa pessoa = pessoaRepository.findById(pessoaId).get();
		Endereco enderecoNovo = enderecoRepository.save(endereco);
		pessoa.addEndereco(enderecoNovo);
		pessoaRepository.save(pessoa);
		return enderecoNovo;
	}

	@Override
	public List<Endereco> listAddressByUser(Long pessoaId) {
		return enderecoRepository.findEnderecoByPessoa(pessoaId);
	}

	@Override
	public Endereco enderecoPrincipal(Long pessoaId, Long enderecoId) {
		Endereco endereco = enderecoRepository.findById(enderecoId).get();
		Pessoa pessoa = pessoaRepository.findById(pessoaId).get();
		pessoa.setEnderecoPrincipal(endereco);
		pessoaRepository.save(pessoa);
		return endereco;
	}

}