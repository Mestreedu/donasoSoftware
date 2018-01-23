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
		
		Cliente clienteExiste = this.repositorioC.procurar(c.getCpf());
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
	public Cliente procurarCliente(String cpf){
		return this.repositorioC.procurar(cpf);
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#remover(java.lang.String)
	 */
	@Override
	public boolean removerCliente(String cpf) throws NaoExisteException{
		if(cpf !=null){
			return this.repositorioC.remover(cpf);
		}
		throw new NaoExisteException();
	}
	
	public boolean alterarCliente(String cpf) {
		return repositorioC.alterarCliente(cpf);
	}
	
	
	public void printar(Cliente c) {
		repositorioC.printar(c);
	}

	public boolean loginCliente(String cpf, String senha) {
		boolean logado = false;
		if (repositorioC.existe(cpf) && repositorioC.procurar(cpf).getSenha().equals(senha)) {
			logado = true;
			JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
		} else {
			JOptionPane.showMessageDialog(null, "LOGIN N�O REALIZADO");
		}
		return logado;
	}

	
}
