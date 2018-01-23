package dados;

import negocio.beans.Cliente;

public interface IRepositorioCliente {

	
//	boolean cadastrar(Cliente c);

	boolean cadastrar(Cliente c);
	
	Cliente procurar(String login);

	boolean remover(String login);

	boolean existe(String login);

	void printar(Cliente c);
	
	boolean alterarCliente(String login);

	

}