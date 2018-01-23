package negocio;

import javax.swing.JOptionPane;

import dados.IRepositorioEmpresa;
import dados.RepositorioEmpresa;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Empresa;

public class ControladorEmpresa implements IControladorEmpresa {
private IRepositorioEmpresa repositorioE;
	
	public ControladorEmpresa(){
		this.repositorioE = RepositorioEmpresa.getInstance(); 
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#getRepositorioC()
	 */
	/* (non-Javadoc)
	 * @see negocio.IControladorEmpresa#getRepositorioE()
	 */
	@Override
	public IRepositorioEmpresa getRepositorioE() {
		return repositorioE;
	}

	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#setRepositorioC(dados.IRepositorioCliente)
	 */
	/* (non-Javadoc)
	 * @see negocio.IControladorEmpresa#setRepositorioE(dados.IRepositorioEmpresa)
	 */
	@Override
	public void setRepositorioE(IRepositorioEmpresa repositorioE) {
		this.repositorioE = repositorioE;
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorCliente#cadastrar(negocio.beans.Cliente)
	 */
	public boolean cadastrarEmpresa(Empresa e) throws ValorInvalidoException, UsuarioExistenteException{
		
		Empresa empresaExiste = this.repositorioE.procurar(e.getLogin());
		if(empresaExiste != null){
			throw new UsuarioExistenteException();
		}		
	
		if(this.repositorioE.cadastrar(e)==true){
			if(e!=null){
				return true;
			}
		}
		throw new ValorInvalidoException();
	}
	
	
	/* (non-Javadoc)
	 * @see negocio.IControladorEmpresa#procurar(java.lang.String)
	 */
	@Override
	public Empresa procurarEmpresa(String login){
		return this.repositorioE.procurar(login);
	}
	
	
	/* (non-Javadoc)
	 * @see negocio.IControladorEmpresa#remover(java.lang.String)
	 */
	@Override
	public boolean removerEmpresa(String login) throws NaoExisteException{
		if(login!=null){
			return this.repositorioE.remover(login);
		}
		throw new NaoExisteException();
	}
	
	/* (non-Javadoc)
	 * @see negocio.IControladorEmpresa#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginEmpresa(String login, String senha) {
		boolean logado = false;
		if (repositorioE.existe(login) && repositorioE.procurar(login).getSenha().equals(senha)) {
			logado = true;
			JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
		} else {
			JOptionPane.showMessageDialog(null, "LOGIN N�O REALIZADO");
		}
		return logado;
	}


}
