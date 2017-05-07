package com.aruana.model.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.aruana.model.bean.Entregador;
import com.aruana.model.bean.Status;

public class EntregadorDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Entregador entregador = new Entregador();
		EntregadorDAO entregadorDAO = new EntregadorDAO();

		entregador.setPlaca("JWQ-1200");
		entregador.setTipo("Caminhão");
		entregador.setStatus(Status.ATIVO);

		entregadorDAO.salvar(entregador);

	}

	@Test
	@Ignore
	public void listar() {
		
		EntregadorDAO entregadorDAO = new EntregadorDAO();
		List<Entregador> lista = entregadorDAO.listar();
		
		for(Entregador entregador : lista){
			System.out.println(entregador.getCodigo() + " - "
					+ entregador.getPlaca() + " - " + entregador.getTipo()
					+ " - "	+ entregador.getStatus());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		
		Integer codigo = 3;
		EntregadorDAO entregadorDAO = new EntregadorDAO();
		Entregador entregador = entregadorDAO.buscar(codigo);
		
		System.out.println(entregador.getCodigo() + " - "
				+ entregador.getPlaca() + " - " + entregador.getTipo()
				+ " - "	+ entregador.getStatus());
		
	}

	@Test
	@Ignore
	public void excluir() {
		
		Integer codigo = 3;
		EntregadorDAO entregadorDAO = new EntregadorDAO();
		Entregador entregador = entregadorDAO.buscar(codigo);
		
		if(entregador == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			entregadorDAO.excluir(entregador);
			System.out.println("Registro Removido");
			System.out.println(entregador.getCodigo() + " - "
					+ entregador.getPlaca() + " - " + entregador.getTipo()
					+ " - "	+ entregador.getStatus());
		}
		
	}

	@Test
	@Ignore
	public void editar() {
		
		Integer codigo = 2;
		EntregadorDAO entregadorDAO = new EntregadorDAO();
		Entregador entregador = entregadorDAO.buscar(codigo);
		
		if(entregador == null){
			System.out.println("Nenhum registro encontrado!");
		}else{
			entregador.setPlaca("AAA-0000");
			entregadorDAO.excluir(entregador);
			System.out.println("Registro Editado");
			System.out.println(entregador.getCodigo() + " - "
					+ entregador.getPlaca() + " - " + entregador.getTipo()
					+ " - "	+ entregador.getStatus());
		}
	}

}
