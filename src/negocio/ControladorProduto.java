package negocio;

import dados.IRepositorioProduto;
import dados.RepositorioProduto;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Produto;

public class ControladorProduto implements IControladorProduto {
	private IRepositorioProduto repositorioP;

	public ControladorProduto(){
		this.repositorioP = RepositorioProduto.getInstance(); 
	}

	@Override
	public IRepositorioProduto getRepositorioP() {
		return repositorioP;
	}

	@Override
	public void setRepositorioP(IRepositorioProduto repositorioP) {
		this.repositorioP = repositorioP;
	}


	@Override
	public boolean cadastrarProduto(Produto p) throws ValorInvalidoException, UsuarioExistenteException {

		Produto produtooExiste = this.repositorioP.procurar(p.getNome());
		if (produtooExiste != null) {
			throw new UsuarioExistenteException();
		}

		if (this.repositorioP.cadastrar(p) == true) {
			if (p != null) {
				return true;
			}
		}
		throw new ValorInvalidoException();
	}

	@Override
	public Produto procurarProduto(String login) {
		return this.repositorioP.procurar(login);
	}

	
	@Override
	public boolean removerProduto(String login) throws NaoExisteException {
		if (login != null) {
			return this.repositorioP.remover(login);
		}
		throw new NaoExisteException();
	}


}
