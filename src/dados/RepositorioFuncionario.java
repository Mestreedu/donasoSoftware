package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.beans.Funcionario;

public class RepositorioFuncionario implements IRepositorioFuncionario, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static IRepositorioFuncionario instanceUser;

	private ArrayList<Funcionario> funcionarios;
	private int next;

	public RepositorioFuncionario() {
		this.funcionarios = new ArrayList<Funcionario>();
		this.next = 0;
	}

	public static synchronized IRepositorioFuncionario getInstance() {
		if(instanceUser == null) {
			instanceUser = ler();
		}
		return instanceUser;
	}

	private static void salvar() {
		if (instanceUser == null) {
			return;
		}
		File out = new File("RepositorioFuncionarios.db");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instanceUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private static RepositorioFuncionario ler() {
		RepositorioFuncionario instanciaLocal = null;

		File in = new File("RepositorioFuncionarios.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioFuncionario) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioFuncionario();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}
		return instanciaLocal;
	}


	@Override
	public boolean cadastrar(Funcionario f){
		if (f != null) {
			funcionarios.add(f);
			this.next = next + 1;
			RepositorioFuncionario.salvar();
			return true;
		}
		return false;
	}

	private int procurarIndice(String cpf) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (cpf.equals(this.funcionarios.get(indice).getCpf())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	@Override
	public Funcionario procurar(String cpf) {
		int i = this.procurarIndice(cpf);
		Funcionario saida = null;
		if (i != this.next) {
			saida = this.funcionarios.get(i);
		} else {
			System.out.println("O FUNCIONARIO NAO FOI ENCONTRADO!");
		}

		return saida;
	}

	@Override
	public boolean remover(String cpf) {
		if (existe(cpf)) {
			Funcionario f = procurar(cpf);
			this.funcionarios.remove(f);
			RepositorioFuncionario.salvar();
			return true;
		}
		return false;
	}

	@Override
	public boolean alterarCliente(String cpf) {
		if (getInstance().existe(cpf)) {
			Funcionario c = procurar(cpf);
			funcionarios.set(funcionarios.indexOf(c), c);
			RepositorioFuncionario.salvar();
			return true;
		}
		return false;
	}



	@Override
	public boolean existe(String cpf) {
		boolean existe = false;
		Funcionario c = this.procurar(cpf);
		if (c != null) {
			existe = true;
			System.out.println("Funcionario existe!");
		} else {
			System.out.println("Funcionario nao existe!");
		}
		return existe;
	}

	@Override
	public void printar(Funcionario f) {
		try {
			JOptionPane.showMessageDialog(null, f.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
