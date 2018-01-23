package negocio.beans;

public class Funcionario extends Conta{

	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	
	public Funcionario(String nome, String cpf, String endereco, String email, String login, String senha){
		
		super(login, senha);
		this.nome = nome; 
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
	}

	public Funcionario(){
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
