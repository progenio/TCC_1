package com.aruana.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "itempedido")
public class ItemPedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itecodigo")
	private Integer codigo;

	@Column(name = "itequantidade", nullable = false, length = 4)
	private Short quantidade;

	@Column(name = "itetotalitem", nullable = false, precision = 6, scale = 2)
	private BigDecimal totalItem;

	@ManyToOne
	@JoinColumn(name = "itepedcodigo", nullable = false)
	@ForeignKey(name = "FK_ITE_PED")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "iteestcodigo", nullable = false)
	@ForeignKey(name = "FK_ITE_EST")
	private Estoque estoque;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(BigDecimal totalItem) {
		this.totalItem = totalItem;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

}
