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
		
		usuario = usuarioDAO.buscar(3);
		System.out.println(usuario.getCodigo());
		
			
		Cliente cliente = new Cliente();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Telefone telefone = new Telefone();
		Telefone telefone1 = new Telefone();
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		
		cliente.setCpf("111.111.111-11");
		cliente.setCnpj("nada");
		cliente.setRazaoSocial("nada");
		cliente.setNome("Um Um Um");
		cliente.setEmail("um@gmail.com");
		cliente.setUsuario(usuario);		
		
		clienteDAO.salvar(cliente);
		
		cliente = clienteDAO.buscar(3);
		
		telefone.setTelefone("(92)91111-1111");
		telefone.setCliente(cliente);
		telefones.add(telefone);
		telefone1.setTelefone("(92)92222-2222");
		telefone1.setCliente(cliente);
		telefones.add(telefone1);
		
		cliente.setTelefones(telefones);
		
		System.out.println(cliente.getCodigo());
		
		for (Telefone telefone2 : telefones) {
			System.out.println(telefone2.getTelefone()+" - "+telefone2.getCliente().getCodigo());
		}
		
		for (Telefone telefone2 : telefones) {
			telefoneDAO.salvar(telefone2);
		}
		
		
		
		
		
		
	}

}
