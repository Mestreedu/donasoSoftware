package gui;

public class MenuFuncionarioController {

	public void sair(){
		try{
			ScreenManager.getInstance().getTelaInicio();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void visualizarPerfil(){
		try{
			ScreenManager.getInstance().getVisualizarPerfil();
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
}
