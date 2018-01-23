package gui;

import javafx.fxml.FXML;
import negocio.Fachada;
import negocio.IFachada;
import negocio.beans.Cliente;
import negocio.beans.Empresa;
import negocio.beans.Funcionario;

import com.jfoenix.controls.JFXTextField;

import exceptions.ValorInvalidoException;

public class CriarContaController {

	IFachada fachada = Fachada.getInstance();
	
	@FXML JFXTextField tfNome, tfCpf, tfEmail, tfEndereco, tfSenha;
	
	public void inserirCliente() throws ValorInvalidoException{
		try{
			Cliente c = new Cliente();
			c.setNome(tfNome.getText());
			c.setNome(tfCpf.getText());
			c.setNome(tfEmail.getText());
			c.setNome(tfEndereco.getText());
			c.setNome(tfSenha.getText());
				
			//Fachada.getInstance().getRepositorioC().cadastrar(c);
			Fachada.getInstance().cadastrarCliente(c);
			ScreenManager.getInstance().getMenuCliente();
			
		}
		catch(Exception ValorInvalidoException){
			throw new ValorInvalidoException();
		}
	}
	

	public void inserirEmpresa() throws ValorInvalidoException{
		try{
			Empresa c = new Empresa();
			c.setNome(tfNome.getText());
			c.setNome(tfCpf.getText());
			c.setNome(tfEmail.getText());
			c.setNome(tfEndereco.getText());
			c.setNome(tfSenha.getText());
				
			Fachada.getInstance().cadastrarEmpresa(c);
			ScreenManager.getInstance().getMenuEmpresa();
			
		}
		catch(Exception ValorInvalidoException){
			throw new ValorInvalidoException();
		}
	}
	
	public void inserirFuncionario() throws ValorInvalidoException{
		try{
			Funcionario c = new Funcionario();
			c.setNome(tfNome.getText());
			c.setNome(tfCpf.getText());
			c.setNome(tfEmail.getText());
			c.setNome(tfEndereco.getText());
			c.setNome(tfSenha.getText());
				
			Fachada.getInstance().cadastrarFuncionario(c);
			ScreenManager.getInstance().getMenuFuncionario();
		
		}
		catch(Exception ValorInvalidoException){
			throw new ValorInvalidoException();
		}
	}
}
