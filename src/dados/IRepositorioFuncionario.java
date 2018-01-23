package dados;

import negocio.beans.Funcionario;

public interface IRepositorioFuncionario {

	boolean cadastrar(Funcionario c);

	Funcionario procurar(String cpf);
	
	boolean remover(String cpf);

	boolean existe(String cpf);

	void printar(Funcionario c);

	boolean alterarCliente(String cpf);

}