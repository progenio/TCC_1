package com.aruana.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

@SuppressWarnings({ "serial", "deprecation" })
@Entity
@Table(name = "estoque")
public class Estoque implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "estcodigo")
	private Integer codigo;

	@Temporal(TemporalType.DATE)
	@Column(name = "estdata", nullable = false)
	private Date data;

	@Column(name = "estpreco", precision = 6, scale = 2, nullable = false)
	private BigDecimal preco;

	@Column(name = "estquantidade", nullable = false)
	private Short quantidade;

	@ManyToOne
	@JoinColumn(name = "estdepcodigo", nullable = false)
	@ForeignKey(name="FK_EST_DEP")
	private Deposito deposito;

	@ManyToOne
	@JoinColumn(name = "estprocodigo", nullable = false)
	@ForeignKey(name="FK_EST_PRO")
	private Produto produto;

	@OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL)
	private List<ItemPedido> itens;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

}
