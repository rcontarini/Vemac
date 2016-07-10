package br.com.vemac.rn;

import java.util.List;

import br.com.vemac.dao.FornecedorDAO;
import br.com.vemac.model.Fornecedor;
import br.com.vemac.util.MessagesUtil;

public class FornecedoresRN extends MessagesUtil {
	
	private FornecedorDAO fornecedorDAO;
	
	public FornecedoresRN() {
		this.fornecedorDAO = new FornecedorDAO();
	}
	
	public void salvar(Fornecedor fornecedor){
		Long id = fornecedor.getId();
		if(id == null || id == 0){
			this.fornecedorDAO.salvar(fornecedor);
			info("Info!", "Fornecedor cadastrado com sucesso!");
		} else {
			this.fornecedorDAO.editar(fornecedor);
		}
		
	}
	
	public List<Fornecedor> listarFornecedores(){
		return this.fornecedorDAO.listar();
		
	}
	
	public void excluir(Fornecedor fornecedor){
		Long id = fornecedor.getId();
		if(id == null || id == 0){
			error("Erro", "Fornecedor inválido!");
		} else {
			this.fornecedorDAO.excluir(fornecedor);
			info("Info!", "Fornecedor excluído com sucesso!");
		}
	}
	
	public FornecedorDAO getFornecedorDAO() {
		return fornecedorDAO;
	}
	
	public void setFornecedorDAO(FornecedorDAO fornecedorDAO) {
		this.fornecedorDAO = fornecedorDAO;
	}

}
