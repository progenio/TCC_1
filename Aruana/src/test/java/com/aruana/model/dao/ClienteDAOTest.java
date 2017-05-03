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
		
		usuario.setSenha("854796");
		usuario.setStatus(Status.ATIVO);
		usuario.setTipoUsuario(TipoUsuario.CLIENTE);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		usuario = usuarioDAO.buscar(4);
		System.out.println(usuario.getCodigo());
		
			
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
		cliente.setCnpj("nada");
		cliente.setRazaoSocial("nada");
		cliente.setNome("Um Um Um");
		cliente.setEmail("um@gmail.com");
		cliente.setUsuario(usuario);
		cliente.setTelefones(telefones);
		
		clienteDAO.salvar(cliente);
		
		cliente = clienteDAO.buscar(1);
		System.out.println(cliente.getCodigo());
		
		for (Telefone telefone2 : telefones) {
			telefoneDAO.salvar(telefone2);
		}
		
		
		
		
		
		
	}

}
