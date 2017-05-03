package com.aruana.model.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "pedido")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pedcodigo")
	private Integer codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "peddataabertura", nullable = false)
	private Date dataAbetura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "peddatafechamento", nullable = false)
	private Date dataFechamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "peddatasaida", nullable = false)
	private Date dataSaida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "peddataretorno", nullable = false)
	private Date dataRetorno;

	@Column(name = "pedtotalpedido", nullable = false, precision = 6, scale = 2)
	private BigDecimal totalPedido;

	@Enumerated(EnumType.STRING)
	@Column(name = "pedstatuspedido", nullable = false)
	private StatusPedido statusPedido;

	@ManyToOne
	@JoinColumn(name = "pedclicodigo", nullable = false)
	@ForeignKey(name="FK_PED_CLI")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "pedcolcodigo", nullable = false)
	@ForeignKey(name="FK_PED_COL")
	private Colaborador colaborador;

	@ManyToOne
	@JoinColumn(name = "pedentcodigo", nullable = false)
	@ForeignKey(name="FK_PED_ENT")
	private Entregador entregador;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataAbetura() {
		return dataAbetura;
	}

	public void setDataAbetura(Date dataAbetura) {
		this.dataAbetura = dataAbetura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public BigDecimal getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(BigDecimal totalPedido) {
		this.totalPedido = totalPedido;
	}

	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Entregador getEntregador() {
		return entregador;
	}

	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

}
