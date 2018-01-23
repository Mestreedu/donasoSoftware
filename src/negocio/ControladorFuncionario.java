package negocio;

import javax.swing.JOptionPane;
import dados.IRepositorioFuncionario;
import dados.RepositorioFuncionario;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Funcionario;

public class ControladorFuncionario implements IControladorFuncionario {
	private IRepositorioFuncionario repositorioF;

	public ControladorFuncionario(){
		this.repositorioF = RepositorioFuncionario.getInstance(); 
	}

	/* (non-Javadoc)
	 * @see negocio.IControladorFuncionario#getRepositorioF()
	 */
	@Override
	public IRepositorioFuncionario getRepositorioF() {
		return repositorioF;
	}

	/* (non-Javadoc)
	 * @see negocio.IControladorFuncionario#setRepositorioF(dados.IRepositorioFuncionario)
	 */
	@Override
	public void setRepositorioF(IRepositorioFuncionario repositorioF) {
		this.repositorioF = repositorioF;
	}

	/* (non-Javadoc)
	 * @see negocio.IControladorFuncionario#cadastrar(negocio.beans.Funcionario)
	 */
	@Override
	public boolean cadastrarFuncionario(Funcionario f) throws ValorInvalidoException, UsuarioExistenteException {

		Funcionario funcionarioExiste = this.repositorioF.procurar(f.getCpf());
		if (funcionarioExiste != null) {
			throw new UsuarioExistenteException();
		}

		if (this.repositorioF.cadastrar(f) == true) {
			if (f != null) {
				return true;
			}
		}
		throw new ValorInvalidoException();
	}

	/* (non-Javadoc)
	 * @see negocio.IControladorFuncionario#procurar(java.lang.String)
	 */
	@Override
	public Funcionario procurarFuncionario(String cpf) {
		return this.repositorioF.procurar(cpf);
	}

	
	public boolean alterarCliente(String cpf) {
		return repositorioF.alterarCliente(cpf);
	}

	/* (non-Javadoc)
	 * @see negocio.IControladorFuncionario#remover(java.lang.String)
	 */
	@Override
	public boolean removerFuncionario(String login) throws NaoExisteException {
		if (login != null) {
			return this.repositorioF.remover(login);
		}
		throw new NaoExisteException();
	}
	


	/* (non-Javadoc)
	 * @see negocio.IControladorFuncionario#login(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginFuncionario(String cpf, String senha) {
		boolean logado = false;
		if (repositorioF.existe(cpf) && repositorioF.procurar(cpf).getSenha().equals(senha)) {
			logado = true;
			JOptionPane.showMessageDialog(null, "LOGIN REALIZADO COM SUCESSO");
		} else {
			JOptionPane.showMessageDialog(null, "LOGIN NAO REALIZADO");
		}
		return logado;
	}

}