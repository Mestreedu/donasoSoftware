package negocio.beans;

import java.util.ArrayList;

public class Empresa extends Conta{

	private String nome;
	private String cnpj;
	private String endereco;
	private String email;
	private ArrayList<Pedido> pedidos;
	
	public Empresa(String nome, String cnpj, String endereco, String email, String login, String senha){
		
		super(login, senha);
		this.nome = nome; 
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.email = email;
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public Empresa(){
		
	}
	
	public void addPedido(Pedido p) {
		pedidos.add(p);
	}
	
	public void deletePedido(Pedido p) {
		if(p!=null) {
			for (int j = 0; j < pedidos.size(); j++) {
				if(p.getId() == pedidos.get(j).getId())
					pedidos.remove(j);
			}
		} else {
			System.out.println("Pedido Invalido!");
		}
		
	}


	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
