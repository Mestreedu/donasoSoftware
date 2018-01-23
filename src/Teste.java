import exceptions.UsuarioExistenteException;
import exceptions.ValorInvalidoException;
import negocio.Fachada;
import negocio.IFachada;
import negocio.beans.Cliente;
import negocio.beans.Empresa;

public class Teste {

	public static void main(String[] args) throws ValorInvalidoException, UsuarioExistenteException {
		IFachada teste = new Fachada();

		Cliente lizandra = new Cliente("Lizandra", "12345", "vitoria, rua direita", "lizandra@email.com", "lizandra", "senha");

		teste.cadastrarCliente(lizandra);

		Empresa empresa = new Empresa("donaso", "123456", "UFRPE, Recife", "eu@donaso.com", "donaso", "senha");

		teste.cadastrarEmpresa(empresa);
	}

}
