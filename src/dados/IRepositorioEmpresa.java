package dados;

import negocio.beans.Empresa;

public interface IRepositorioEmpresa {

//	void salvar();

	boolean cadastrar(Empresa u);

	Empresa procurar(String cnpj);

	boolean remover(String cnpj);

	boolean existe(String cnpj);

	void printar(Empresa u);

	boolean alterarEmpresa(String cnpj);

}