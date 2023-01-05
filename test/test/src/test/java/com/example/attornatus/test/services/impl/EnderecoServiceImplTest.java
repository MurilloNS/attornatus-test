package com.example.attornatus.test.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.attornatus.test.entities.Endereco;
import com.example.attornatus.test.entities.Pessoa;
import com.example.attornatus.test.repositories.EnderecoRepository;
import com.example.attornatus.test.repositories.PessoaRepository;

@SpringBootTest
class EnderecoServiceImplTest {
	@InjectMocks
	private EnderecoServiceImpl enderecoServiceImpl;

	@Mock
	private EnderecoRepository enderecoRepository;

	@Mock
	private PessoaRepository pessoaRepository;

	private Endereco endereco;
	private Pessoa pessoa;
	private Optional<Endereco> optionalEndereco;
	private Optional<Pessoa> optionalPessoa;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		initEndereco();
	}

	@Test
	void whenAddEnderecoThenReturnSuccess() {
		when(pessoaRepository.findById(anyLong())).thenReturn(optionalPessoa);
		when(enderecoRepository.save(any())).thenReturn(endereco);
		when(pessoaRepository.save(any())).thenReturn(pessoa);

		Endereco response = enderecoServiceImpl.addEndereco(1L, endereco);

		assertNotNull(response);
		assertEquals(Endereco.class, response.getClass());
		assertEquals(endereco.getId(), response.getId());
	}

	@Test
	void whenFindAllThenReturnAnListofEnderecos() {
		when(enderecoRepository.findEnderecoByPessoa(anyLong())).thenReturn(List.of(endereco));

		List<Endereco> response = enderecoServiceImpl.listAddressByUser(1L);

		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(Endereco.class, response.get(0).getClass());
	}

	@Test
	void whenEnderecoPrincipalThenReturnSuccess() {
		when(enderecoRepository.findById(anyLong())).thenReturn(optionalEndereco);
		when(pessoaRepository.findById(anyLong())).thenReturn(optionalPessoa);
		when(pessoaRepository.save(any())).thenReturn(pessoa);

		Endereco response = enderecoServiceImpl.enderecoPrincipal(1L, 1L);

		assertNotNull(response);
		assertEquals(optionalEndereco.get().getId(), response.getId());
	}

	private void initEndereco() {
		endereco = new Endereco("Rua Geziael Pereira da Silva", "11713-285", 1273, "Praia Grande");
		optionalEndereco = Optional.of(new Endereco("Rua Geziael Pereira da Silva", "11713-285", 1273, "Praia Grande"));
		optionalPessoa = Optional.of(new Pessoa("Murillo", null, null));
		pessoa = new Pessoa("Murillo", null, null);
	}
}