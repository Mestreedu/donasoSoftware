package negocio;

import dados.IRepositorioCliente;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Cliente;

public interface IControladorCliente {

	IRepositorioCliente getRepositorioC();

	void setRepositorioC(IRepositorioCliente repositorioC);

	boolean cadastrarCliente(Cliente c) throws ValorInvalidoException, UsuarioExistenteException;

	Cliente procurarCliente(String login);

	boolean removerCliente(String login) throws NaoExisteException;
	
	boolean loginCliente(String login, String senha);
	

}