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

import negocio.beans.Cliente;

public class RepositorioClientes implements IRepositorioCliente, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static IRepositorioCliente instanceUser;

	private ArrayList<Cliente> clientes;
	private int next;

	public RepositorioClientes() {
		this.clientes = new ArrayList<Cliente>();
		this.next = 0;
	}

	public static synchronized IRepositorioCliente getInstance() {
		if(instanceUser == null) {
			instanceUser = ler();
		}
		return instanceUser;
	}

	private static void salvar() {
		if (instanceUser == null) {
			return;
		}
		File out = new File("RepositorioClientes.db");
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

	private static RepositorioClientes ler() {
		RepositorioClientes instanciaLocal = null;

		File in = new File("RepositorioClientes.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioClientes) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioClientes();
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
	public boolean cadastrar(Cliente c){	 //mudei pra boolean
		if (c != null) {
			clientes.add(c);
			this.next = next + 1;
			RepositorioClientes.salvar();
			return true;
		}
			return false;

	}



	private int procurarIndice(String cpf) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (cpf.equals(this.clientes.get(indice).getCpf())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}


	@Override
	public Cliente procurar(String cpf) {
		int i = this.procurarIndice(cpf);
		Cliente saida = null;
		if (i != this.next) {
			saida = this.clientes.get(i);
		} else {
			System.out.println("O CLIENTE NAO FOI ENCONTRADO!");
		}

		return saida;
	}


	@Override
	public boolean remover(String cpf) { // mudei pra boolean
		if (this.existe(cpf)) {
			Cliente c = procurar(cpf);
			this.clientes.remove(c);
			RepositorioClientes.salvar();
			return true;
			//System.out.println("Cliente foi removido!");
		} else {
			return false;
			//System.out.println("Houve um problema! Cliente n�o pode ser removido.");
		}

	}

	@Override
	public boolean alterarCliente(String cpf) {
		if (getInstance().existe(cpf)) {
			Cliente c = procurar(cpf);
			clientes.set(clientes.indexOf(c), c);
			RepositorioClientes.salvar();
			return true;
		}
			return false;

	}

	@Override
	public boolean existe(String cpf) {
		boolean existe = false;
		Cliente c = this.procurar(cpf);
		if (c != null) {
			existe = true;
			System.out.println("Cliente existe!");
		} else {
			System.out.println("Cliente nao existe!");
		}
		return existe;
	}

	@Override
	public void printar(Cliente c) {
		try {
			JOptionPane.showMessageDialog(null, c.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
