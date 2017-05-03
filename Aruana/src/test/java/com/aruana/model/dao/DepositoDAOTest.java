package com.aruana.model.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.aruana.model.bean.Deposito;

public class DepositoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Deposito deposito = new Deposito();
		DepositoDAO depositoDAO = new DepositoDAO();
		
		deposito.setNome("Deposito 03");		
		depositoDAO.salvar(deposito);
		
	}

	@Test
	@Ignore
	public void listar(){
		
		DepositoDAO depositoDAO = new DepositoDAO();
		List<Deposito> lista = depositoDAO.listar();
		
		for (Deposito deposito : lista) {
			System.out.println(deposito.getCodigo() + " - "
					+ deposito.getNome());
		}
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		Integer codigo = 1;
		DepositoDAO depositoDAO = new DepositoDAO();
		Deposito deposito = depositoDAO.buscar(codigo);
		
		if (deposito == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println(deposito.getCodigo() + " - "
					+ deposito.getNome());
		}
		
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		Integer codigo = 2;
		DepositoDAO depositoDAO = new DepositoDAO();
		Deposito deposito = depositoDAO.buscar(codigo);
		
		if (deposito == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			depositoDAO.excluir(deposito);
			System.out.println("Registro Removido");
			System.out.println(deposito.getCodigo() + " - "
					+ deposito.getNome());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		Integer codigo = 3;
		DepositoDAO depositoDAO = new DepositoDAO();
		Deposito deposito = depositoDAO.buscar(codigo);
		
		if (deposito == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			deposito.setNome("Deposito 03");
			depositoDAO.editar(deposito);
			System.out.println("Registro Editado");
			System.out.println(deposito.getCodigo() + " - "
					+ deposito.getNome());
		}
	}

}
