package dados;

import negocio.beans.Funcionario;

public interface IRepositorioFuncionario {

	boolean cadastrar(Funcionario c);

	Funcionario procurar(String login);
	
	boolean remover(String login);

	boolean existe(String login);

	void printar(Funcionario c);

	boolean alterarCliente(String login);

}