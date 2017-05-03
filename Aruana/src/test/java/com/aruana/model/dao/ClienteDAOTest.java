package com.aruana.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.aruana.model.bean.Cliente;
import com.aruana.model.bean.Status;
import com.aruana.model.bean.Telefone;
import com.aruana.model.bean.TipoUsuario;
import com.aruana.model.bean.Usuario;

public class ClienteDAOTest {
	
	@Test
	//@Ignore
	public void salvar(){
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuario.setSenha("12345");
		usuario.setStatus(Status.ATIVO);
		usuario.setTipoUsuario(TipoUsuario.CLIENTE);
		
		usuarioDAO.salvar(usuario);
		/*
		usuarioDAO.buscar(1);
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Telefone telefone = new Telefone();
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		
		telefone.setTelefone("(92)91111-1111");
		telefones.add(telefone);
		telefone.setTelefone("(92)92222-2222");
		telefones.add(telefone);
		
		
		cliente.setCpf("111.111.111-11");
		cliente.setNome("Um Um Um");
		cliente.setEmail("um@gmail.com");
		cliente.setTelefones(telefones);
		
		clienteDAO.salvar(cliente);
		
		cliente = clienteDAO.buscar(1);
		
		for (Telefone telefone2 : telefones) {
			telefoneDAO.salvar(telefone2);
		}
		
		
		*/
		
		
		
	}

}
