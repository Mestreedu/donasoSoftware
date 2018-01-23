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
	

	Cliente procurarCliente(String login);

	boolean removerCliente(String login) throws NaoExisteException;

	boolean loginCliente(String login, String senha);

	IRepositorioEmpresa getRepositorioE();

	void setRepositorioE(IRepositorioEmpresa repositorioE);

	boolean cadastrarEmpresa(Empresa e) throws ValorInvalidoException, UsuarioExistenteException;

	
	Empresa procurarEmpresa(String login);

	boolean removerEmpresa(String login) throws NaoExisteException;

	boolean loginEmpresa(String login, String senha);

	IRepositorioFuncionario getRepositorioF();

	void setRepositorioF(IRepositorioFuncionario repositorioF);

	boolean cadastrarFuncionario(Funcionario f) throws ValorInvalidoException, UsuarioExistenteException;

	
	Funcionario procurarFuncionario(String login);

	boolean removerFuncionario(String login) throws NaoExisteException;

	boolean loginFuncionario(String login, String senha);

	IRepositorioProduto getRepositorioP();

	void setRepositorioP(IRepositorioProduto repositorioP);

	boolean cadastrarProduto(Produto p) throws ValorInvalidoException, UsuarioExistenteException;

	
	Produto procurarProduto(String nome);

	boolean removerProduto(String nome) throws NaoExisteException;
	
	Object checarTipo(String login);

	boolean fazerPostagem(Produto p, Funcionario f, String postagem);
	
	boolean fazerComentario(Produto p, Cliente c, String comentario);
}