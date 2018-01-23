package negocio;

import dados.IRepositorioFuncionario;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Funcionario;

public interface IControladorFuncionario {

	IRepositorioFuncionario getRepositorioF();

	void setRepositorioF(IRepositorioFuncionario repositorioF);

	boolean cadastrarFuncionario(Funcionario f) throws ValorInvalidoException, UsuarioExistenteException;

	Funcionario procurarFuncionario(String login);

	boolean removerFuncionario(String login) throws NaoExisteException;

	boolean loginFuncionario(String login, String senha);
	

}