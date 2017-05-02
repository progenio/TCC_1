package com.aruana.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="cep")
public class Cep implements Serializable{
	
	@Id
	@Column(name = "cepcodigo")
	private Integer codigo;
	
	@Column(name = "cepcidade", length = 50)
	private String cidade;
	
	@Column(name = "ceplogradouro", length = 70)
	private String logradouro;
	
	@Column(name = "cepbairro", length = 72)
	private String bairro;
	
	@Column(name = "cepcep", length = 9, nullable=false)
	private String cep;
	
	@Column(name = "ceptplogradouro", length = 20)
	private String tipoLogradouro;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	
}
