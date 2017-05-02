package com.aruana.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@SuppressWarnings({ "serial", "deprecation" })
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "endcodigo")
	private Integer codigo;

	@Column(name = "endnumero", length = 20, nullable = false)
	private String numero;

	@Column(name = "endcomplemento", nullable = false, columnDefinition = "TEXT")
	private String complemento;

	@Column(name = "endreferencia")
	private String referencia;

	@Column(name = "endobservacao")
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "endcepcodigo", nullable = false)
	@ForeignKey(name = "FK_END_CEP")
	private Cep cep;

	@ManyToOne
	@JoinColumn(name = "endclicodigo", nullable = false)
	@ForeignKey(name = "FK_END_CLI")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "enddepcodigo", nullable = false)
	@ForeignKey(name = "FK_END_DEP")
	private Deposito deposito;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

}
