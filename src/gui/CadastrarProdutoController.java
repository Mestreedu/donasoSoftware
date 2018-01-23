package gui;

public class CadastrarProdutoController {

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
	
	public void perfil(){
		try{
			ScreenManager.getInstance().getVisualizarPerfil();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
