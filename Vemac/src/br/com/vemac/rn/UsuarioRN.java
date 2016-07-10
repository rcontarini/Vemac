package br.com.vemac.rn;

import br.com.vemac.dao.UsuarioDAO;
import br.com.vemac.model.Usuario;
import br.com.vemac.util.MessagesUtil;

public class UsuarioRN extends MessagesUtil {
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioRN() {
		this.usuarioDAO = new UsuarioDAO();
	}
	
	public void salvar(Usuario usuario){
		Long id = usuario.getId();
		if(id == null || id == 0){
			this.usuarioDAO.salvar(usuario);
			info("Info", "Cadastro realizado com sucesso!");
		} else {
			this.usuarioDAO.editar(usuario);
		}
	}
	
	
	public UsuarioDAO getUsuarioDAO() {
		
		return usuarioDAO;
	}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	

}
