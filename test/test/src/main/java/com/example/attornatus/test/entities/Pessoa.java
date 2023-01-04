package com.example.attornatus.test.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate nascimento;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pessoa_endereco", joinColumns = @JoinColumn(name = "pessoa_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> enderecos = new ArrayList<>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "enderecoPrincipal", referencedColumnName = "id")
	private Endereco enderecoPrincipal;

	public Pessoa() {
	}

	public Pessoa(String nome, LocalDate nascimento, Endereco enderecoPrincipal) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Endereco getEnderecoPrincipal() {
		return enderecoPrincipal;
	}

	public void setEnderecoPrincipal(Endereco enderecoPrincipal) {
		this.enderecoPrincipal = enderecoPrincipal;
	}

	public void addEndereco(Endereco enderecos) {
		this.enderecos.add(enderecos);
	}
}