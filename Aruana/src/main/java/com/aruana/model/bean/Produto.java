package com.aruana.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@SuppressWarnings({ "serial", "deprecation" })
@Entity
@Table(name="produto")
public class Produto implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="procodigo")
	private Integer codigo;
	
	@Column(name="pronome", length=150, nullable=false)
    private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="prounidade", length=20, nullable=false)
    private Unidade unidade;
	
	@ManyToOne
	@JoinColumn(name="proforcodigo", nullable=false)
	@ForeignKey(name="FK_PRO_FOR")
    private Fornecedor fornecedor;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
