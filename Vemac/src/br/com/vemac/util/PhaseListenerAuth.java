package br.com.vemac.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.vemac.model.Usuario;

public class PhaseListenerAuth implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4631127860647348637L;

	@Override
	public void afterPhase(PhaseEvent event) {
		
		FacesContext facesContext = event.getFacesContext();
		String nomePagina = facesContext.getViewRoot().getViewId();
		
		Usuario usuarioLogado = (Usuario) facesContext.getExternalContext().getSessionMap().get("usuarioLogado");
		
		if(nomePagina.equals("/login.xhtml") || nomePagina.equals("/pages/usuarios/cadastroUsuario.xhtml")){
			return;
		} 
		
		if(usuarioLogado != null){
			return;
		}
		
		NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
		navigationHandler.handleNavigation(facesContext, null, "/login?faces-redirect=true");
		facesContext.renderResponse();
		
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
