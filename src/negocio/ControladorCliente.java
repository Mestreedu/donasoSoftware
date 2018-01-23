package negocio;

import javax.swing.JOptionPane;

import dados.IRepositorioCliente;
import dados.RepositorioClientes;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Cliente;

public class ControladorCliente implements IControladorCliente {

	private IRepositorioCliente repositorioC;
	
	public ControladorCliente(){
		this.repositorioC = RepositorioClientes.getInstance(); 
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#getRepositorioC()
	 */
	public void salvarCliente() {
		repositorioC.salvar();
	}
	
	@Override
	public IRepositorioCliente getRepositorioC() {
		return repositorioC;
	}

	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#setRepositorioC(dados.IRepositorioCliente)
	 */
	@Override
	public void setRepositorioC(IRepositorioCliente repositorioC) {
		this.repositorioC = repositorioC;
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#cadastrar(negocio.beans.Cliente)
	 */
	@Override
	public boolean cadastrarCliente(Cliente c) throws ValorInvalidoException, UsuarioExistenteException{
		
		Cliente clienteExiste = this.repositorioC.procurar(c.getLogin());
		if(clienteExiste != null){
			throw new UsuarioExistenteException();
		}		
	
		if(this.repositorioC.cadastrar(c)==true){
			if(c!=null){
				return true;
			}
		}
		throw new ValorInvalidoException();
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#procurar(java.lang.String)
	 */
	@Override
	public Cliente procurarCliente(String login){
		return this.repositorioC.procurar(login);
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#remover(java.lang.String)
	 */
	@Override
	public boolean removerCliente(String login) throws NaoExisteException{
		if(login!=null){
			return this.repositorioC.remover(login);
		}
		throw new NaoExisteException();
	}
	
	
	
	public void printar(Cliente c) {
		repositorioC.printar(c);
	}

	public boolean loginCliente(String login, String senha) {
		boolean logado = false;
		if (repositorioC.existe(login) && repositorioC.procurar(login).getSenha().equals(senha)) {
			logado = true;
			JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
		} else {
			JOptionPane.showMessageDialog(null, "LOGIN N�O REALIZADO");
		}
		return logado;
	}

	
}
