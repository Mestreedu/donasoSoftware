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

import negocio.beans.Produto;

public class RepositorioProduto implements IRepositorioProduto, Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	private static IRepositorioProduto instanceUser;
	private ArrayList<Produto> produtos;
	private int next;

	public RepositorioProduto() {
		this.produtos = new ArrayList<Produto>();
		this.next = 0;
	}

	public static synchronized IRepositorioProduto getInstance() {
		if(instanceUser == null) {
			instanceUser = ler();
		}
		return instanceUser;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#salvar()
	 */
	private static void salvar() {
		if (instanceUser == null) {
			return;
		}
		File out = new File("RepositorioProdutos.db");
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

	private static RepositorioProduto ler() {
		RepositorioProduto instanciaLocal = null;

		File in = new File("RepositorioProdutos.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioProduto) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioProduto();
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

	public boolean cadastrar(Produto p){
		if (p != null) {
			produtos.add(p);
			this.next = next + 1;
			RepositorioProduto.salvar();
			return true;
		}
		return false;
	}

	private int procurarIndice(String nome) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (nome.equals(this.produtos.get(indice).getNome())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	@Override
	public Produto procurar(String nome) {
		int i = this.procurarIndice(nome);
		Produto saida = null;
		if (i != this.next) {
			saida = this.produtos.get(i);
		} else {
			System.out.println("O PRODUTO N�O FOI ENCONTRADO!");
		}

		return saida;
	}

	@Override
	public boolean remover(String nome) {
		if (existe(nome)) {
			Produto p = procurar(nome);
			this.produtos.remove(p);
			RepositorioProduto.salvar();
			return true;
		}
		return false;
	}

	@Override
	public boolean alterarProduto(String nome) {
		if (getInstance().existe(nome)) {
			Produto c = procurar(nome);
			produtos.set(produtos.indexOf(c), c);
			RepositorioProduto.salvar();
			return true;
		}
		return false;

	}

	@Override
	public boolean existe(String nome) {
		boolean existe = false;
		Produto u = this.procurar(nome);
		if (u != null) {
			existe = true;
			System.out.println("Produto existe!");
		} else {
			System.out.println("Produto n�o existe!");
		}
		return existe;
	}

	/* (non-Javadoc)
	 * @see dados.IRepositorioProduto#printar(negocio.beans.Empresa)
	 */
	@Override
	public void printar(Produto p) {
		try {
			JOptionPane.showMessageDialog(null, p.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}