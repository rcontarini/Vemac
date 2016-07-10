package br.com.vemac.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.vemac.model.Endereco;
import br.com.vemac.model.Fornecedor;
import br.com.vemac.rn.FornecedoresRN;
import br.com.vemac.util.MessagesUtil;

@ManagedBean
@ViewScoped
public class FornecedorBean extends MessagesUtil {
	
	private FornecedoresRN fornecedoresRN;
	private Fornecedor fornecedor;
	private Endereco endereco;
	private List<Fornecedor> listfornecedores;
	private Integer id;
	
	@PostConstruct
	public void init(){
		this.fornecedoresRN = new FornecedoresRN();
		this.fornecedor = new Fornecedor();
		this.endereco = new Endereco();
		this.listfornecedores = this.fornecedoresRN.listarFornecedores();
	}
	
	public void salvar(){
		this.fornecedor.setEndereco(this.endereco);
		this.fornecedoresRN.salvar(this.fornecedor);
		this.fornecedor = new Fornecedor();
		this.endereco = new Endereco();
	}
	
	public void excluir(Fornecedor fornecedor){
		this.fornecedoresRN.excluir(fornecedor);
		this.listfornecedores = this.fornecedoresRN.listarFornecedores();
	}
	
	
	public FornecedoresRN getFornecedoresRN() {
		return fornecedoresRN;
	}
	
	public void setFornecedoresRN(FornecedoresRN fornecedoresRN) {
		this.fornecedoresRN = fornecedoresRN;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Fornecedor> getListfornecedores() {
		return listfornecedores;
	}
	
	public void setListfornecedores(List<Fornecedor> listfornecedores) {
		this.listfornecedores = listfornecedores;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

}
