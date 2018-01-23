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

	Funcionario procurarFuncionario(String cpf);

	boolean removerFuncionario(String cpf) throws NaoExisteException;

	boolean loginFuncionario(String cpf, String senha);
	

}