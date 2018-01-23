package negocio;

import dados.IRepositorioCliente;
import dados.IRepositorioEmpresa;
import dados.IRepositorioFuncionario;
import dados.IRepositorioProduto;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Cliente;
import negocio.beans.Empresa;
import negocio.beans.Funcionario;
import negocio.beans.Produto;

public interface IFachada {

	IRepositorioCliente getRepositorioC();

	void setRepositorioC(IRepositorioCliente repositorioC);

	boolean cadastrarCliente(Cliente c) throws ValorInvalidoException, UsuarioExistenteException;
	

	Cliente procurarCliente(String cpf);

	boolean removerCliente(String cpf) throws NaoExisteException;

	boolean loginCliente(String cpf, String senha);

	IRepositorioEmpresa getRepositorioE();

	void setRepositorioE(IRepositorioEmpresa repositorioE);

	boolean cadastrarEmpresa(Empresa e) throws ValorInvalidoException, UsuarioExistenteException;

	
	Empresa procurarEmpresa(String cnpj);

	boolean removerEmpresa(String cnpj) throws NaoExisteException;

	boolean loginEmpresa(String cnpj, String senha);

	IRepositorioFuncionario getRepositorioF();

	void setRepositorioF(IRepositorioFuncionario repositorioF);

	boolean cadastrarFuncionario(Funcionario f) throws ValorInvalidoException, UsuarioExistenteException;

	
	Funcionario procurarFuncionario(String cpf);

	boolean removerFuncionario(String cpf) throws NaoExisteException;

	boolean loginFuncionario(String cpf, String senha);

	IRepositorioProduto getRepositorioP();

	void setRepositorioP(IRepositorioProduto repositorioP);

	boolean cadastrarProduto(Produto p) throws ValorInvalidoException, UsuarioExistenteException;

	
	Produto procurarProduto(String nome);

	boolean removerProduto(String nome) throws NaoExisteException;
	
	Object checarTipo(String cpf);

	boolean fazerPostagem(Produto p, Funcionario f, String postagem);
	
	boolean fazerComentario(Produto p, Cliente c, String comentario);
}