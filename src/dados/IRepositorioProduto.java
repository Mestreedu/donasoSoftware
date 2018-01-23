package dados;

import negocio.beans.Produto;

public interface IRepositorioProduto {


	void cadastrar(Produto u);

	Produto procurar(String nome);

	void remover(String nome);

	boolean existe(String nome);

	void printar(Produto u);

	void alterarProduto(String nome);

}