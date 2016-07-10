package br.com.vemac.test;

import org.hibernate.Session;
import org.junit.Test;

import br.com.vemac.util.HibernateUtil;


public class HibernateUtilTest {
	
	@Test
	public void conectar(){
		
		Session openSession = HibernateUtil.getSessionfactory().openSession();
		openSession.close();
		HibernateUtil.getSessionfactory().close();
	}

}

