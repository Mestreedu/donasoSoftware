package gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ScreenManager {

	BorderPane border, paneLoginCliente, paneMenuCliente, paneMenuEmpresa;
	BorderPane paneMenuFuncionario, paneTelaInicio, paneCriarConta, paneVisualizarPerfil, paneEditarPerfil;
	BorderPane paneCadastrarProduto, paneTelaProduto;
	FXMLLoader loginCliente, menuCliente, menuEmpresa, menuFuncionario, telaInicio, criarConta, visualizarPerfil, editarPerfil, 
				cadastrarProduto, telaProduto;

	
	public static ScreenManager instancia;
	
	public static synchronized ScreenManager getInstance(){
		if(instancia == null){
			instancia = new ScreenManager();
		}
		return instancia;
	}
	
	private ScreenManager(){
		try {
			loginCliente = new FXMLLoader(this.getClass().getResource("LoginCliente.fxml"));
			this.paneLoginCliente = loginCliente.load();
			criarConta = new FXMLLoader(this.getClass().getResource("CriarConta.fxml"));
			this.paneCriarConta = criarConta.load();
			menuCliente = new FXMLLoader(this.getClass().getResource("MenuCliente.fxml"));
			this.paneMenuCliente = menuCliente.load();
			menuEmpresa = new FXMLLoader(this.getClass().getResource("MenuEmpresa.fxml"));
			this.paneMenuEmpresa = menuEmpresa.load();
			menuFuncionario = new FXMLLoader(this.getClass().getResource("MenuFuncionario.fxml"));
			this.paneMenuFuncionario = menuFuncionario.load();
			telaInicio = new FXMLLoader(this.getClass().getResource("TelaInicio.fxml"));
			this.paneTelaInicio = telaInicio.load();
			visualizarPerfil = new FXMLLoader(this.getClass().getResource("VisualizarPerfil.fxml"));
			this.paneVisualizarPerfil = visualizarPerfil.load();
			editarPerfil = new FXMLLoader(this.getClass().getResource("EditarPerfil.fxml"));
			this.paneEditarPerfil = editarPerfil.load();
			cadastrarProduto = new FXMLLoader(this.getClass().getResource("CadastrarProduto.fxml"));
			this.paneCadastrarProduto = cadastrarProduto.load();
			telaProduto = new FXMLLoader(this.getClass().getResource("TelaProduto.fxml"));
			this.paneTelaProduto = telaProduto.load();
			
			this.border = Main.getRoot();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void getCriarConta(){	
		border.setCenter(this.paneCriarConta);
	}
	
	public void getLoginCliente(){	
		border.setCenter(this.paneLoginCliente);	
	}
	
	public void getMenuCliente(){
		border.setCenter(this.paneMenuCliente);
	}
	
	public void getTelaInicio(){	
		border.setCenter(this.paneTelaInicio);
	}

	public void getMenuEmpresa(){	
		border.setCenter(this.paneMenuEmpresa);
	}
	
	public void getMenuFuncionario(){	
		border.setCenter(this.paneMenuFuncionario);
	}
	
	public void getVisualizarPerfil(){	
		border.setCenter(this.paneVisualizarPerfil);
	}
	
	public void getEditarPerfil(){	
		border.setCenter(this.paneEditarPerfil);
	}
	
	public void getCadastrarProduto(){	
		border.setCenter(this.paneCadastrarProduto);
	}
	
	public void getTelaProduto(){	
		border.setCenter(this.paneTelaProduto);
	}
	
}
