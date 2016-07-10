package br.com.vemac.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.vemac.model.Usuario;
import br.com.vemac.rn.LoginRN;
import br.com.vemac.util.MessagesUtil;

@ManagedBean
@ViewScoped
public class LoginBean extends MessagesUtil {
	
	private Usuario usuario;
	private Usuario usuarioTela;
	private LoginRN loginRN;
	
	public LoginBean() {
		this.usuario = new Usuario();
		this.loginRN = new LoginRN();
		this.usuarioTela = new Usuario();
	}
	
	public void login(){
		  this.usuario = this.loginRN.buscar(this.usuarioTela);
		 
		 if(this.usuario != null && this.usuario.getSenha().equals(this.usuarioTela.getSenha())){
			 FacesContext currentInstance = FacesContext.getCurrentInstance();
			 currentInstance.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			 info("Info", "Login efetuado com sucesso!");
		 } else {
			 error("Erro", "Usuário não encontrado!");
		 }
	}
	
	public void logout(){
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		currentInstance.getExternalContext().getSessionMap().remove("usuarioLogado");
	}
	
	public LoginRN getLoginRN() {
		return loginRN;
	}
	
	public void setLoginRN(LoginRN loginRN) {
		this.loginRN = loginRN;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuarioTela() {
		return usuarioTela;
	}
	
	public void setUsuarioTela(Usuario usuarioTela) {
		this.usuarioTela = usuarioTela;
	}

}
