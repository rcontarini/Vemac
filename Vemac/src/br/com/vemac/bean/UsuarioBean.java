package br.com.vemac.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vemac.model.Usuario;
import br.com.vemac.rn.UsuarioRN;
import br.com.vemac.util.MessagesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean extends MessagesUtil {
	
	private UsuarioRN usuarioRN;
	private Usuario usuario;
	
	@PostConstruct
	public void init(){
		this.usuarioRN = new UsuarioRN();
		this.usuario = new Usuario();
	}
	
	public void salvar(){
		this.usuarioRN.salvar(this.usuario);
		this.usuario = new Usuario();
	}
	
	
	public UsuarioRN getUsuarioRN() {
		return usuarioRN;
	}
	
	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
