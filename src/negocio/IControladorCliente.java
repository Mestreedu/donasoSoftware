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

	Cliente procurarCliente(String cpf);

	boolean removerCliente(String cpf) throws NaoExisteException;
	
	boolean loginCliente(String cpf, String senha);
	

}