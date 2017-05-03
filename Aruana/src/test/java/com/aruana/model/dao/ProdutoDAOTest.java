package com.aruana.model.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.aruana.model.bean.Fornecedor;
import com.aruana.model.bean.Produto;
import com.aruana.model.bean.Unidade;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Integer codigo = 1;

		Produto produto = new Produto();
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.buscar(codigo);

		produto.setNome("Agua Garrafão 10");
		produto.setUnidade(Unidade.LITRO);
		produto.setFornecedor(fornecedor);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
	}

	@Test
	@Ignore
	public void listar() {

		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> lista = produtoDAO.listar();

		for (Produto produto : lista) {
			System.out.println(produto.getCodigo() + " - " + produto.getNome()
					+ " - " + produto.getUnidade() + " - "
					+ produto.getFornecedor().getRazaoSocial());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		Integer codigo = 2;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		if (produto == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println(produto.getCodigo() + " - " + produto.getNome()
					+ " - " + produto.getUnidade() + " - "
					+ produto.getFornecedor().getRazaoSocial());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		Integer codigo = 2;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		if (produto == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Registro Removido");
			System.out.println(produto.getCodigo() + " - " + produto.getNome()
					+ " - " + produto.getUnidade() + " - "
					+ produto.getFornecedor().getRazaoSocial());
		}
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Integer codigo = 3;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		if (produto == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println(produto.getCodigo() + " - " + produto.getNome()
					+ " - " + produto.getUnidade() + " - "
					+ produto.getFornecedor().getRazaoSocial());
			
			produto.setNome("Botijão de Gas 13");
			produtoDAO.editar(produto);
			
			System.out.println("Registro Alterado");
			System.out.println(produto.getCodigo() + " - " + produto.getNome()
					+ " - " + produto.getUnidade() + " - "
					+ produto.getFornecedor().getRazaoSocial());
		}
		
	}

}
