package negocio;

import dados.IRepositorioCliente;
import dados.IRepositorioEmpresa;
import dados.IRepositorioFuncionario;
import dados.IRepositorioProduto;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Cliente;
import negocio.beans.Empresa;
import negocio.beans.Funcionario;
import negocio.beans.Produto;

public class Fachada implements IFachada {
	private IControladorCliente controladorCliente;
	private IControladorEmpresa controladorEmpresa;
	private IControladorFuncionario controladorFuncionario;
	private IControladorProduto controladorProduto;
	
	private static IFachada instance;

	public Fachada() {
		this.controladorCliente = new ControladorCliente();
		this.controladorEmpresa = new ControladorEmpresa();
		this.controladorFuncionario = new ControladorFuncionario();
		this.controladorProduto = new ControladorProduto();
	}

	public static IFachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#getRepositorioC()
	 */
	@Override
	public IRepositorioCliente getRepositorioC() {
		return controladorCliente.getRepositorioC();
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#setRepositorioC(dados.IRepositorioCliente)
	 */
	@Override
	public void setRepositorioC(IRepositorioCliente repositorioC) {
		controladorCliente.setRepositorioC(repositorioC);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#cadastrarCliente(negocio.beans.Cliente)
	 */
	@Override
	public boolean cadastrarCliente(Cliente c) throws ValorInvalidoException, UsuarioExistenteException {
		return controladorCliente.cadastrarCliente(c);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#procurarCliente(java.lang.String)
	 */
	
	@Override
	public Cliente procurarCliente(String login) {
		return controladorCliente.procurarCliente(login);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#removerCliente(java.lang.String)
	 */
	@Override
	public boolean removerCliente(String login) throws NaoExisteException {
		return controladorCliente.removerCliente(login);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#loginCliente(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginCliente(String login, String senha) {
		return controladorCliente.loginCliente(login, senha);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#getRepositorioE()
	 */
	@Override
	public IRepositorioEmpresa getRepositorioE() {
		return controladorEmpresa.getRepositorioE();
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#setRepositorioE(dados.IRepositorioEmpresa)
	 */
	@Override
	public void setRepositorioE(IRepositorioEmpresa repositorioE) {
		controladorEmpresa.setRepositorioE(repositorioE);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#cadastrarEmpresa(negocio.beans.Empresa)
	 */
	@Override
	public boolean cadastrarEmpresa(Empresa e) throws ValorInvalidoException, UsuarioExistenteException {
		return controladorEmpresa.cadastrarEmpresa(e);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#procurarEmpresa(java.lang.String)
	 */

	
	@Override
	public Empresa procurarEmpresa(String login) {
		return controladorEmpresa.procurarEmpresa(login);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#removerEmpresa(java.lang.String)
	 */
	@Override
	public boolean removerEmpresa(String login) throws NaoExisteException {
		return controladorEmpresa.removerEmpresa(login);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#loginEmpresa(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginEmpresa(String login, String senha) {
		return controladorEmpresa.loginEmpresa(login, senha);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#getRepositorioF()
	 */
	@Override
	public IRepositorioFuncionario getRepositorioF() {
		return controladorFuncionario.getRepositorioF();
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#setRepositorioF(dados.IRepositorioFuncionario)
	 */
	@Override
	public void setRepositorioF(IRepositorioFuncionario repositorioF) {
		controladorFuncionario.setRepositorioF(repositorioF);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#cadastrarFuncionario(negocio.beans.Funcionario)
	 */
	@Override
	public boolean cadastrarFuncionario(Funcionario f) throws ValorInvalidoException, UsuarioExistenteException {
		return controladorFuncionario.cadastrarFuncionario(f);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#procurarFuncionario(java.lang.String)
	 */

	
	@Override
	public Funcionario procurarFuncionario(String login) {
		return controladorFuncionario.procurarFuncionario(login);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#removerFuncionario(java.lang.String)
	 */
	@Override
	public boolean removerFuncionario(String login) throws NaoExisteException {
		return controladorFuncionario.removerFuncionario(login);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#loginFuncionario(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginFuncionario(String login, String senha) {
		return controladorFuncionario.loginFuncionario(login, senha);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#getRepositorioP()
	 */
	@Override
	public IRepositorioProduto getRepositorioP() {
		return controladorProduto.getRepositorioP();
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#setRepositorioP(dados.IRepositorioProduto)
	 */
	@Override
	public void setRepositorioP(IRepositorioProduto repositorioP) {
		controladorProduto.setRepositorioP(repositorioP);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#cadastrarProduto(negocio.beans.Produto)
	 */
	@Override
	public boolean cadastrarProduto(Produto p) throws ValorInvalidoException, UsuarioExistenteException {
		return controladorProduto.cadastrarProduto(p);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#procurarProduto(java.lang.String)
	 */

	
	@Override
	public Produto procurarProduto(String nome) {
		return controladorProduto.procurarProduto(nome);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#removerProduto(java.lang.String)
	 */
	@Override
	public boolean removerProduto(String nome) throws NaoExisteException {
		return controladorProduto.removerProduto(nome);
	}

	public Object checarTipo(String login) {
		if(this.procurarCliente(login) != null) {
			return this.procurarCliente(login).getClass();
		} else if(this.procurarEmpresa(login) != null) {
			return this.procurarEmpresa(login).getClass();
		} else if(this.procurarFuncionario(login) != null) {
			return this.procurarFuncionario(login).getClass();
		} else {
			return Object.class;
		}
	}
	
	public boolean fazerPostagem(Produto p, Funcionario f, String postagem) {
		boolean permissao = false;
		String msg = null;
		if(p!=null && f!= null && p.getFuncionarios().contains(f)) {
			msg = f.getLogin() + ": " + postagem;
			p.addPostagem(msg);
			permissao = true;
		} else {
			System.out.println("Postagem nao permitida!");
		}
		return permissao;
	}
	
	public boolean fazerComentario(Produto p, Cliente c, String comentario) {
		boolean permissao = false;
		String msg = null;
		if(p!=null && c!=null && p.getCliente().getLogin() == c.getLogin()) {
			msg = c.getLogin() + ": " + comentario;
			p.addComentario(msg);
			permissao = true;
		} else {
			System.out.println("Comentario nao permitido");
		}
		return permissao;
	}
	
	
}
