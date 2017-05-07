package com.aruana.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import com.aruana.model.bean.Fornecedor;
import com.aruana.model.bean.Produto;
import com.aruana.model.bean.Unidade;
import com.aruana.model.dao.FornecedorDAO;
import com.aruana.model.dao.ProdutoDAO;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoController implements Serializable {
	
	private Produto produto;
	private List<Produto> produtos;
	private List<Fornecedor> fornecedores;
	
	
	
	@PostConstruct
	public void lista(){
		try{
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao listar os produtos");
			erro.printStackTrace();
		}
	}
	
	public void salvar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.merge(produto);
			novo();
			produtos = produtoDAO.listar();
			Messages.addGlobalInfo("Produto salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto");
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		}
	}
	
	public Unidade[] getUnidades(){
		return Unidade.values();
	}
	
	public void novo(){
		try{
		produto = new Produto();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedores = fornecedorDAO.listar();
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao listar os fornecedores");
			erro.printStackTrace();
		}
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
