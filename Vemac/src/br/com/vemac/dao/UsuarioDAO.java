package br.com.vemac.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.vemac.model.Usuario;
import br.com.vemac.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario buscar(String email){
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		
		try {
			Criteria consulta = openSession.createCriteria(Usuario.class);
			consulta.add(Restrictions.ilike("email", email));
			Usuario resultado = (Usuario)consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException e) {
			
			throw e;
		} finally {
			openSession.close();
		}
	}
	
}
