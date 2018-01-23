package dados;

import negocio.beans.Produto;

public interface IRepositorioProduto {


	boolean cadastrar(Produto u);

	Produto procurar(String nome);

	boolean remover(String nome);

	boolean existe(String nome);

	void printar(Produto u);

	boolean alterarProduto(String nome);

}