package com.example.attornatus.test.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.attornatus.test.entities.Pessoa;
import com.example.attornatus.test.repositories.PessoaRepository;

class PessoaServiceImplTest {
	@InjectMocks
	private PessoaServiceImpl pessoaServiceImpl;

	@Mock
	private PessoaRepository pessoaRepository;

	private Pessoa pessoa;
	private Optional<Pessoa> optionalPessoa;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		initPessoa();
	}

	@Test
	void whenSaveThenReturnSuccess() {
		when(pessoaRepository.save(any())).thenReturn(pessoa);

		Pessoa response = pessoaServiceImpl.savePessoa(pessoa);

		assertNotNull(response);
		assertEquals(Pessoa.class, response.getClass());
		assertEquals(pessoa.getId(), response.getId());
	}

	@Test
	void whenUpdateThenReturnSuccess() {
		when(pessoaRepository.findById(anyLong())).thenReturn(optionalPessoa);

		pessoaServiceImpl.updatePessoa(1L, pessoa);

		verify(pessoaRepository, times(1)).save(any());
	}

	@Test
	void whenFindByIdThenReturnAnPessoaInstance() {
		when(pessoaRepository.findById(anyLong())).thenReturn(optionalPessoa);

		Pessoa response = pessoaServiceImpl.findByIdPessoa(1L);

		assertNotNull(response);
	}

	@Test
	void whenFindAllThenReturnAnListofPessoas() {
		when(pessoaRepository.findAll()).thenReturn(List.of(pessoa));

		List<Pessoa> response = pessoaServiceImpl.listPessoa();

		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Pessoa.class, response.get(0).getClass());
	}

	private void initPessoa() {
		pessoa = new Pessoa("Murillo", null, null);
		optionalPessoa = Optional.of(new Pessoa("Maria", null, null));
	}
}