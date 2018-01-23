package dados;

import negocio.beans.Cliente;

public interface IRepositorioCliente {

	
//	boolean cadastrar(Cliente c);

	boolean cadastrar(Cliente c);
	
	Cliente procurar(String cpf);

	boolean remover(String cpf);

	boolean existe(String cpf);

	void printar(Cliente c);
	
	boolean alterarCliente(String cpf);

	

}