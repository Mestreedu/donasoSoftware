package dados;

import negocio.beans.Empresa;

public interface IRepositorioEmpresa {

//	void salvar();

	boolean cadastrar(Empresa u);

	Empresa procurar(String login);

	boolean remover(String login);

	boolean existe(String login);

	void printar(Empresa u);

	boolean alterarEmpresa(String login);

}