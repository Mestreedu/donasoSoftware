package gui;

import javax.swing.JOptionPane;

import negocio.Fachada;
import negocio.IFachada;
import negocio.beans.Cliente;
import negocio.beans.Funcionario;
import negocio.beans.Produto;

public class TelaProdutoController {
	IFachada fachada = new Fachada();
	TelaLoginController telaLogin = new TelaLoginController();
	Object quemSouEu = telaLogin.getWhoIsLogged();
	
	
	
	public Object getQuemSouEu() {
		return quemSouEu;
	}



	public void setQuemSouEu(Object quemSouEu) {
		this.quemSouEu = quemSouEu;
	}



	/*public boolean postarButton(Produto p, Object o, String msg) {  \\Fiquei travado, depois continuo
		boolean permissao = false;
		if(getQuemSouEu() instanceof Funcionario) {
			o = (Funcionario) getQuemSouEu();
			fachada.fazerPostagem(p, o, msg);
			permissao = true;
		} else if(getQuemSouEu() instanceof Cliente){
			o = (Cliente) getQuemSouEu();
			fachada.fazerComentario(p, o, msg);
			permissao = true;
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Postagem nao permitida!");
		}
		return permissao;
	}*/
	
	


}