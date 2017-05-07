package com.aruana.model.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.aruana.model.bean.Colaborador;
import com.aruana.model.bean.Estoque;
import com.aruana.model.bean.Status;
import com.aruana.model.bean.TipoUsuario;
import com.aruana.model.bean.Usuario;

public class ColaboradorDAOTest {

	@Test
	//@Ignore
	public void salvar() {

		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Colaborador colaborador = new Colaborador();
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

		usuario.setSenha("987563");
		usuario.setStatus(Status.ATIVO);
		usuario.setTipoUsuario(TipoUsuario.VENDEDOR);
		usuarioDAO.salvar(usuario);

		List<Usuario> lista = usuarioDAO.listar();
		usuario = lista.get(lista.size() - 1);

		colaborador.setNome("Calos Santos");
		colaborador.setUsuario(usuario);
		colaboradorDAO.salvar(colaborador);

	}

	@Test
	@Ignore
	public void listar() {

		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		List<Colaborador> lista = colaboradorDAO.listar();

		for (Colaborador colaborador : lista) {
			System.out.println(colaborador.getCodigo() + " - "
					+ colaborador.getNome() + " - "
					+ colaborador.getUsuario().getCodigo() + " - "
					+ colaborador.getUsuario().getTipoUsuario());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		
		Integer codigo = 1;
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		Colaborador colaborador = colaboradorDAO.buscar(codigo);
		
		if (colaborador == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println(colaborador.getCodigo() + " - "
					+ colaborador.getNome() + " - "
					+ colaborador.getUsuario().getCodigo() + " - "
					+ colaborador.getUsuario().getTipoUsuario());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		
		Integer codigo = 2;
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		Colaborador colaborador = colaboradorDAO.buscar(codigo);
		
		if (colaborador == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			colaboradorDAO.excluir(colaborador);
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(colaborador.getUsuario());
			System.out.println("Registro Removido");
			System.out.println(colaborador.getCodigo() + " - "
					+ colaborador.getNome() + " - "
					+ colaborador.getUsuario().getCodigo() + " - "
					+ colaborador.getUsuario().getTipoUsuario());
		}
		

	}

	@Test
	@Ignore
	public void editar() {
		
		Integer codigo = 1;
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();		
		Colaborador colaborador = colaboradorDAO.buscar(codigo);
		Usuario usuario = usuarioDAO.buscar(colaborador.getUsuario().getCodigo());		
		
		colaborador.setNome("Rafaela Ribeiro");
		usuario.setTipoUsuario(TipoUsuario.GERENTE);					
		colaboradorDAO.editar(colaborador);			
		usuarioDAO.editar(colaborador.getUsuario());
		System.out.println("Registro Alterado");
		System.out.println(colaborador.getCodigo() + " - "
				+ colaborador.getNome() + " - "
				+ colaborador.getUsuario().getCodigo() + " - "
				+ colaborador.getUsuario().getTipoUsuario());

	}

}
