package com.aruana.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.aruana.model.bean.Cliente;
import com.aruana.model.bean.Status;
import com.aruana.model.bean.Telefone;
import com.aruana.model.bean.TipoUsuario;
import com.aruana.model.bean.Usuario;

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Usuario usuario = new Usuario();

		usuario.setSenha("456963");
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

		cliente.setCpf("333.333.333-33");
		cliente.setCnpj("nada");
		cliente.setRazaoSocial("nada");
		cliente.setNome("Tres Tres Tres");
		cliente.setEmail("Tres@gmail.com");
		cliente.setUsuario(usuario);

		clienteDAO.salvar(cliente);

		cliente = clienteDAO.buscar(3);

		telefone.setTelefone("(92)95555-5555");
		telefone.setCliente(cliente);
		telefones.add(telefone);
		telefone1.setTelefone("(92)96666-6666");
		telefone1.setCliente(cliente);
		telefones.add(telefone1);

		cliente.setTelefones(telefones);

		System.out.println(cliente.getCodigo());

		for (Telefone telefone2 : telefones) {
			telefoneDAO.salvar(telefone2);
		}

	}

	@Test
	@Ignore
	public void listar() {

		ClienteDAO clienteDAO = new ClienteDAO();
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		List<Cliente> lista = clienteDAO.listar();
		List<Telefone> listaTel = telefoneDAO.listar();

		for (Cliente cliente : lista) {
			System.out.println(cliente.getCodigo() + " - " + cliente.getNome()
					+ " - " + cliente.getCpf() + " - " + cliente.getEmail()
					+ " - " + cliente.getUsuario().getSenha() + " - "
					+ cliente.getUsuario().getStatus() + " - "
					+ cliente.getUsuario().getTipoUsuario() + "\n Telefones ");

			for (Telefone telefone : listaTel) {
				if (telefone.getCliente().getCodigo() == cliente.getCodigo()) {
					System.out.println(telefone.getTelefone());
				}

			}
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Integer codigo = 2;

		ClienteDAO clienteDao = new ClienteDAO();
		Cliente cliente = clienteDao.buscar(codigo);

		TelefoneDAO telefoneDAO = new TelefoneDAO();
		List<Telefone> listaTel = telefoneDAO.listar();

		System.out.println(cliente.getCodigo() + " - " + cliente.getNome()
				+ " - " + cliente.getCpf() + " - " + cliente.getEmail() + " - "
				+ cliente.getUsuario().getSenha() + " - "
				+ cliente.getUsuario().getStatus() + " - "
				+ cliente.getUsuario().getTipoUsuario() + "\n Telefones ");

		for (Telefone telefone : listaTel) {
			if (telefone.getCliente().getCodigo() == cliente.getCodigo()) {
				System.out.println(telefone.getTelefone());
			}

		}

	}

	@Test
	@Ignore
	public void excluir() {

		Integer codigo = 2;

		ClienteDAO clienteDao = new ClienteDAO();
		Cliente cliente = clienteDao.buscar(codigo);

		TelefoneDAO telefoneDAO = new TelefoneDAO();
		List<Telefone> listaTel = telefoneDAO.listar();

		for (Telefone telefone : listaTel) {
			System.out.println("Telefone removido");
			if (telefone.getCliente().getCodigo() == cliente.getCodigo()) {
				telefoneDAO.excluir(telefone);
			}
		}

		clienteDao.excluir(cliente);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(cliente.getUsuario());

	}
	
	@Test
	@Ignore
	public void editar() {

		Integer codigo = 1;

		ClienteDAO clienteDao = new ClienteDAO();
		//preenche o objeto cliente com os atributos
		Cliente cliente = clienteDao.buscar(codigo);

		TelefoneDAO telefoneDAO = new TelefoneDAO();
		//preenche a lista de telefones contidas no banco
		List<Telefone> listaTel = telefoneDAO.listar();	
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		//preenche o objeto usuario com os atributos
		Usuario usuario = usuarioDAO.buscar(cliente.getUsuario().getCodigo());
		
		//edita a senha do usuario
		usuario.setSenha("22222");				
		usuarioDAO.editar(usuario);		
		System.out.println(usuario.getCodigo());
		
		List<Telefone> telefones = new ArrayList<Telefone>();
		
		for (Telefone telefone : listaTel) {			
			if (telefone.getCliente().getCodigo() == cliente.getCodigo()) {
				telefones.add(telefone);
				System.out.println(telefone.getCodigo()+" - "+telefone.getTelefone());
			}
		}
		
		Telefone telefone = telefoneDAO.buscar(1);		
		telefone.setTelefone("(11)11111-1111");
		telefoneDAO.editar(telefone);		

		cliente.setCpf("111.100.111-10");	
		cliente.setNome("Primeiro primeniro");
		clienteDao.editar(cliente);	
		
		cliente = clienteDao.buscar(codigo);
		
		System.out.println(cliente.getCodigo() + " - " + cliente.getNome()
				+ " - " + cliente.getCpf() + " - " + cliente.getEmail() + " - "
				+ cliente.getUsuario().getSenha() + " - "
				+ cliente.getUsuario().getStatus() + " - "
				+ cliente.getUsuario().getTipoUsuario() + "\n Telefones ");

		for (Telefone tel : listaTel) {
			if (tel.getCliente().getCodigo() == cliente.getCodigo()) {
				System.out.println(tel.getTelefone());
			}

		}
	}


}
