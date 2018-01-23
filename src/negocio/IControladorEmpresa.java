package negocio;

import dados.IRepositorioEmpresa;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Empresa;

public interface IControladorEmpresa {

	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#getRepositorioC()
	 */
	IRepositorioEmpresa getRepositorioE();

	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#setRepositorioC(dados.IRepositorioCliente)
	 */
	void setRepositorioE(IRepositorioEmpresa repositorioE);

	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#cadastrar(negocio.beans.Cliente)
	 */
	boolean cadastrarEmpresa(Empresa e) throws ValorInvalidoException, UsuarioExistenteException;

	Empresa procurarEmpresa(String login);

	boolean removerEmpresa(String login) throws NaoExisteException;

	boolean loginEmpresa(String login, String senha);
	

}