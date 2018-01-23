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
	public Cliente procurarCliente(String cpf) {
		return controladorCliente.procurarCliente(cpf);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#removerCliente(java.lang.String)
	 */
	@Override
	public boolean removerCliente(String cpf) throws NaoExisteException {
		return controladorCliente.removerCliente(cpf);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#loginCliente(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginCliente(String cpf, String senha) {
		Login.setUsuario(cpf);
		Login.setSenha(senha);
		return controladorCliente.loginCliente(cpf, senha);
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
	public Empresa procurarEmpresa(String cnpj) {
		return controladorEmpresa.procurarEmpresa(cnpj);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#removerEmpresa(java.lang.String)
	 */
	@Override
	public boolean removerEmpresa(String cnpj) throws NaoExisteException {
		return controladorEmpresa.removerEmpresa(cnpj);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#loginEmpresa(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginEmpresa(String cnpj, String senha) {
		Login.setUsuario(cnpj);
		Login.setSenha(senha);
		return controladorEmpresa.loginEmpresa(cnpj, senha);
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
	public Funcionario procurarFuncionario(String cpf) {
		return controladorFuncionario.procurarFuncionario(cpf);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#removerFuncionario(java.lang.String)
	 */
	@Override
	public boolean removerFuncionario(String cpf) throws NaoExisteException {
		return controladorFuncionario.removerFuncionario(cpf);
	}

	/* (non-Javadoc)
	 * @see negocio.IFachada#loginFuncionario(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean loginFuncionario(String cpf, String senha) {
		Login.setUsuario(cpf);
		Login.setSenha(senha);
		return controladorFuncionario.loginFuncionario(cpf, senha);
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

	public Object checarTipo(String cpf_Cnpj) {
		if(this.procurarCliente(cpf_Cnpj) != null) {
			return this.procurarCliente(cpf_Cnpj).getClass();
		} else if(this.procurarEmpresa(cpf_Cnpj) != null) {
			return this.procurarEmpresa(cpf_Cnpj).getClass();
		} else if(this.procurarFuncionario(cpf_Cnpj) != null) {
			return this.procurarFuncionario(cpf_Cnpj).getClass();
		} else {
			return Object.class;
		}
	}
	
	public boolean fazerPostagem(Produto p, Funcionario f, String postagem) {
		boolean permissao = false;
		String msg = null;
		if(p!=null && f!= null && p.getFuncionarios().contains(f)) {
			msg = f.getCpf() + ": " + postagem;
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
		if(p!=null && c!=null && p.getCliente().getCpf() == c.getCpf()) {
			msg = c.getCpf() + ": " + comentario;
			p.addComentario(msg);
			permissao = true;
		} else {
			System.out.println("Comentario nao permitido");
		}
		return permissao;
	}

	public String getNomeUsuarioLogado () {
		return Login.getUsuario();
	}

	public void setNomeUsuarioLogado(String usuario) {
		Login.setUsuario(usuario);
	}
	
	public String getSenhaUsuarioLogado() {
		return Login.getSenha();
	}
	
	public void setSenhaUsuarioLogado(String senha) {
		Login.setSenha(senha);
	}

}

class Login{
	  private static String usuario;
	  private static String senha;
	  public static void setUsuario(String usuario){
	     Login.usuario = usuario;
	  }
	  public static String getUsuario(){
	     return usuario;
	  }
	  public static String getSenha() {
		 return senha;
	  }
	  public static void setSenha(String senha){
		  Login.senha = senha;
	  }
	  public static boolean autentica(){
	    return true;
	  }
}