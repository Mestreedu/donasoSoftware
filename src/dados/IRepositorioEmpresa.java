package dados;

import negocio.beans.Empresa;

public interface IRepositorioEmpresa {

//	void salvar();

	void cadastrar(Empresa u);

	Empresa procurar(String login);

	void remover(String login);

	boolean existe(String login);

	void printar(Empresa u);

	void alterarEmpresa(String login);

}