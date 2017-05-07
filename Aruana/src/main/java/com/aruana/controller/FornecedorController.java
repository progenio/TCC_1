package com.aruana.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.aruana.model.bean.Fornecedor;
import com.aruana.model.dao.FornecedorDAO;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FornecedorController implements Serializable {

	private Fornecedor fornecedor;
	private List<Fornecedor> fornecedores;

	public void salvar() {
		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedorDAO.merge(fornecedor);

			novo();
			fornecedores = fornecedorDAO.listar();
			Messages.addGlobalInfo("Fornecedor salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o forncedor");
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedores = fornecedorDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os fornecedores");
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			fornecedor = (Fornecedor) evento.getComponent().getAttributes()
					.get("fornecedorSelecionado");

			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedorDAO.excluir(fornecedor);
			fornecedores = fornecedorDAO.listar();
			Messages.addGlobalInfo("Fornecedor removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o fornecedor");
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		fornecedor = (Fornecedor) evento.getComponent().getAttributes()
				.get("fornecedorSelecionado");
	}

	public void novo() {
		fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
