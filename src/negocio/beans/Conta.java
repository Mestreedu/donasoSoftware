package negocio.beans;

public class Conta {

	private String cpf;
	private String senha;
	
	public Conta(String cpf, String senha)
	{
		this.cpf = cpf;
		this.senha  = senha;
	}
	
	public Conta(){
		
	}
	
	public String getCpf() {
		return cpf;
	}
		
	public String getSenha() {
		return senha;
	}
	
	public boolean equals(Conta conta){
		if(this.cpf.equals(conta.cpf)){
			if(this.senha.equals(conta.senha)){
				return true;
			}
		}
		return false;
	}
}
