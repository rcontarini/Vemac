package br.com.vemac.rn;

import br.com.vemac.dao.UsuarioDAO;
import br.com.vemac.model.Usuario;

public class LoginRN {
	
	private UsuarioDAO usuarioDAO;
	private Usuario usuarioBuscar;
	
	public LoginRN() {
		this.usuarioDAO = new UsuarioDAO();
	}
	
	public Usuario buscar(Usuario usuario){
		this.usuarioBuscar = new Usuario();
		
		if(usuario.getEmail() != null || usuario.getSenha() != null){
			this.usuarioBuscar = this.usuarioDAO.buscar(usuario.getEmail());
		}
		return this.usuarioBuscar;
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	public Usuario getUsuarioBuscar() {
		return usuarioBuscar;
	}
	
	public void setUsuarioBuscar(Usuario usuarioBuscar) {
		this.usuarioBuscar = usuarioBuscar;
	}

}
