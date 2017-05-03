package com.aruana.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;


@SuppressWarnings({ "serial", "deprecation" })
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clicodigo")
	private Integer codigo;

	@Column(name = "clicnpj", length = 18)
	private String cnpj;

	@Column(name = "clicpf", length = 14)
	private String cpf;

	@Column(name = "clinome", length = 150)
	private String nome;

	@Column(name = "clirazaosocial", length = 150)
	private String razaoSocial;

	@Column(name = "cliemail", length = 100, nullable=false)
	private String email;
	
	@OneToOne
	@JoinColumn(name = "cliusucodigo", nullable=false)
	@ForeignKey(name="FK_CLI_USU")
	private Usuario usuario;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Telefone> telefones;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}



}
