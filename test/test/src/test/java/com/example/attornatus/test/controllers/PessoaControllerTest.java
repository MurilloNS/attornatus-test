package com.example.attornatus.test.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.attornatus.test.entities.Pessoa;
import com.example.attornatus.test.services.PessoaService;

@SpringBootTest
class PessoaControllerTest {
	private Pessoa pessoa;

	@InjectMocks
	private PessoaController pessoaController;

	@Mock
	private PessoaService pessoaService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		initPessoa();
	}

	@Test
	void whenCriarThenReturnCreated() {
		when(pessoaService.savePessoa(any())).thenReturn(pessoa);

		ResponseEntity<Pessoa> response = pessoaController.criarPessoa(pessoa);

		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(Pessoa.class, response.getBody().getClass());
		assertEquals(pessoa.getId(), response.getBody().getId());
	}

	@Test
	void whenEditarThenReturnSuccess() {
		when(pessoaService.updatePessoa(1L, pessoa)).thenReturn(pessoa);

		ResponseEntity<Pessoa> response = pessoaController.editarPessoa(1L, pessoa);

		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(Pessoa.class, response.getBody().getClass());
		assertEquals(pessoa.getId(), response.getBody().getId());
	}

	@Test
	void testConsultarPessoa() {
		fail("Not yet implemented");
	}

	@Test
	void whenFindByIdThenReturnSuccess() {
		when(pessoaService.findByIdPessoa(anyLong())).thenReturn(pessoa);

		ResponseEntity<Pessoa> response = pessoaController.consultarPessoa(1L);

		assertNotNull(response);
		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(ResponseEntity.class, response.getClass());
		assertEquals(pessoa.getClass(), response.getBody().getClass());
		assertEquals(pessoa.getId(), response.getBody().getId());
	}

	private void initPessoa() {
		pessoa = new Pessoa("Murillo", null, null);
	}
}