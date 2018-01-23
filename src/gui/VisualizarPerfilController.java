package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class VisualizarPerfilController {

	@FXML Label labelNome, labelCpf, labelEmail, labelEndereco;
	
	public void voltar(){
		try{
			ScreenManager.getInstance().getMenuCliente();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void sair(){
		try{
			ScreenManager.getInstance().getTelaInicio();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void editar(){
		try{
			ScreenManager.getInstance().getEditarPerfil();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void produto(){
		try{
			ScreenManager.getInstance().getTelaProduto();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/*
	public void setDados(Sessao selecionado) {
		this.sessao = selecionado;
		labelNome.setText(this.sessao.getNome());
		atualizarSessao();
	}*/
	
}
