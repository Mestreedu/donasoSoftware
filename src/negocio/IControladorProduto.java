package negocio;

import dados.IRepositorioProduto;
import exceptions.NaoExisteException;
import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.beans.Produto;

public interface IControladorProduto {

	IRepositorioProduto getRepositorioP();

	void setRepositorioP(IRepositorioProduto repositorioP);

	boolean cadastrarProduto(Produto p) throws ValorInvalidoException, UsuarioExistenteException;

	Produto procurarProduto(String nome);

	boolean removerProduto(String nome) throws NaoExisteException;
	

}