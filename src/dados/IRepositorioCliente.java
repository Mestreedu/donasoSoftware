package dados;

import negocio.beans.Cliente;

public interface IRepositorioCliente {

	
//	boolean cadastrar(Cliente c);

	void cadastrar(Cliente c);
	
	Cliente procurar(String login);

	boolean remover(String login);

	boolean existe(String login);

	void printar(Cliente c);
	
	void alterarCliente(String login);

	

}