package com.aruana.model.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.aruana.model.bean.Fornecedor;

public class FornecedorDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setRazaoSocial("Minalar");
		fornecedor.setCnpj("23.000.333/0003-33");
		fornecedor.setVendedor("Oranilza da Silveira");
		fornecedor.setTelefone("(92)8989-7474");
		fornecedor.setCelular("(92)96565-1212");

		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.salvar(fornecedor);
	}

	@Test
	@Ignore
	public void listar() {
		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		List<Fornecedor> lista = fornecedorDAO.listar();

		for (Fornecedor fornecedor : lista) {
			System.out.println(fornecedor.getRazaoSocial() + " - "
					+ fornecedor.getCnpj() + " - " + fornecedor.getVendedor()
					+ " - " + fornecedor.getTelefone() + " - "
					+ fornecedor.getCelular());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Integer codigo = 3;

		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.buscar(codigo);

		if (fornecedor == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println(fornecedor.getRazaoSocial() + " - "
					+ fornecedor.getCnpj() + " - " + fornecedor.getVendedor()
					+ " - " + fornecedor.getTelefone() + " - "
					+ fornecedor.getCelular());
		}
	}

	@Test
	@Ignore
	public void excluir() {

		Integer codigo = 3;

		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.buscar(codigo);

		if (fornecedor == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			fornecedorDAO.excluir(fornecedor);
			System.out.println("Registro Removido");
			System.out.println(fornecedor.getRazaoSocial() + " - "
					+ fornecedor.getCnpj() + " - " + fornecedor.getVendedor()
					+ " - " + fornecedor.getTelefone() + " - "
					+ fornecedor.getCelular());
		}

	}
	
	@Test
	@Ignore
	public void editar() {

		Integer codigo = 4;

		FornecedorDAO fornecedorDAO = new FornecedorDAO();
		Fornecedor fornecedor = fornecedorDAO.buscar(codigo);

		if (fornecedor == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			fornecedor.setRazaoSocial("Minalar");			
			fornecedorDAO.editar(fornecedor);
			System.out.println("Registro Editado");
			System.out.println(fornecedor.getRazaoSocial() + " - "
					+ fornecedor.getCnpj() + " - " + fornecedor.getVendedor()
					+ " - " + fornecedor.getTelefone() + " - "
					+ fornecedor.getCelular());
		}

	}

}