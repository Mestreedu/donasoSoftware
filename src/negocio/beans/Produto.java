package negocio.beans;

import java.util.ArrayList;
import java.util.Random;

public class Produto {

	private String nome;
	private String descricao;
	private int id;
	private Cliente cliente;
	private ArrayList<Funcionario> funcionarios;
	private ArrayList<String> comentarios;
	private ArrayList<String> postagens;
	
	public Produto(String nome, String descricao, Cliente cliente, ArrayList<Funcionario> funcionarios){
		this.cliente = cliente;
		this.nome = nome;
		this.descricao = descricao;
		this.funcionarios = funcionarios;
		this.comentarios = new ArrayList<String>();
		this.postagens = new ArrayList<String>();
		Random r = new Random();
		this.id = r.nextInt(999999999);
		
	}
	
	public Produto(){
		
	}
	
	public void addPostagem(String p) {
		postagens.add(p);
	}
	
	public void addComentario(String c) {
		comentarios.add(c);
	}

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
