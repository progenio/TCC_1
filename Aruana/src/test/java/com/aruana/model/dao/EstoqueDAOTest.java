package com.aruana.model.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.aruana.model.bean.Deposito;
import com.aruana.model.bean.Estoque;
import com.aruana.model.bean.Produto;

public class EstoqueDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Integer codigo = 3;
		Estoque estoque = new Estoque();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		DepositoDAO depositoDAO = new DepositoDAO();
		Deposito deposito = depositoDAO.buscar(1);

		estoque.setProduto(produto);
		estoque.setQuantidade(new Short("10"));
		estoque.setPreco(new BigDecimal("15.50"));
		estoque.setData(new Date());
		estoque.setDeposito(deposito);

		EstoqueDAO estoqueDAO = new EstoqueDAO();
		estoqueDAO.salvar(estoque);
	}

	@Test
	@Ignore
	public void listar() {

		EstoqueDAO estoqueDAO = new EstoqueDAO();
		List<Estoque> lista = estoqueDAO.listar();

		for (Estoque estoque : lista) {
			System.out.println(estoque.getCodigo() + " - "
					+ estoque.getProduto().getNome() + " - "
					+ estoque.getQuantidade() + " - " + estoque.getPreco()
					+ " - " + " - " + estoque.getData() + " - "
					+ estoque.getDeposito().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Integer codigo = 1;
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		Estoque estoque = estoqueDAO.buscar(codigo);

		if (estoque == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println(estoque.getCodigo() + " - "
					+ estoque.getProduto().getNome() + " - "
					+ estoque.getQuantidade() + " - " + estoque.getPreco()
					+ " - " + " - " + estoque.getData() + " - "
					+ estoque.getDeposito().getNome());
		}

	}

	@Test
	@Ignore
	public void excluir() {
		
		Integer codigo = 2;
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		Estoque estoque = estoqueDAO.buscar(codigo);

		if (estoque == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			estoqueDAO.excluir(estoque);
			System.out.println("Registro Removido");
			System.out.println(estoque.getCodigo() + " - "
					+ estoque.getProduto().getNome() + " - "
					+ estoque.getQuantidade() + " - " + estoque.getPreco()
					+ " - " + " - " + estoque.getData() + " - "
					+ estoque.getDeposito().getNome());
		}

	}

	@Test
	@Ignore
	public void editar() {
		
		Integer codigo = 2;
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		Estoque estoque = estoqueDAO.buscar(codigo);

		if (estoque == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			estoque.setPreco(new BigDecimal("10.00"));
			estoque.setQuantidade(new Short("20"));
			estoqueDAO.editar(estoque);
			System.out.println("Registro Editado");
			System.out.println(estoque.getCodigo() + " - "
					+ estoque.getProduto().getNome() + " - "
					+ estoque.getQuantidade() + " - " + estoque.getPreco()
					+ " - " + " - " + estoque.getData() + " - "
					+ estoque.getDeposito().getNome());
		}
	}
}
