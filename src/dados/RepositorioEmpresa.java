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

import negocio.beans.Empresa;

public class RepositorioEmpresa implements IRepositorioEmpresa, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static IRepositorioEmpresa instanceUser;

	private ArrayList<Empresa> empresas;
	private int next;

	public RepositorioEmpresa() {
		this.empresas = new ArrayList<Empresa>();
		this.next = 0;
	}

	public static synchronized IRepositorioEmpresa getInstance() {
		if(instanceUser == null) {
			instanceUser = ler();
		}
		return instanceUser;
	}

	private static void salvar() {
		if (instanceUser == null) {
			return;
		}
		File out = new File("RepositorioEmpresa.db");
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

	private static RepositorioEmpresa ler() {
		RepositorioEmpresa instanciaLocal = null;

		File in = new File("RepositorioEmpresa.db");
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioEmpresa) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioEmpresa();
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
	public boolean cadastrar(Empresa e){
		if (e != null) {
			empresas.add(e);
			this.next = next + 1;
			RepositorioEmpresa.salvar();
			return true;
		}
		return false;
	}

	private int procurarIndice(String cnpj) {
		int indice = 0;
		boolean found = false;
		while (found != true && indice < this.next) {
			if (cnpj.equals(this.empresas.get(indice).getCnpj())) {
				found = true;
			} else {
				indice = indice + 1;
			}
		}
		return indice;
	}

	@Override
	public Empresa procurar(String cnpj) {
		int i = this.procurarIndice(cnpj);
		Empresa saida = null;
		if (i != this.next) {
			saida = this.empresas.get(i);
		} else {
			System.out.println("A EMPRESA NAO FOI ENCONTRADA!");
		}

		return saida;
	}

	@Override
	public boolean remover(String cnpj) {
		if (existe(cnpj)) {
			Empresa c = procurar(cnpj);
			this.empresas.remove(c);
			RepositorioEmpresa.salvar();
			return true;
		}
		return false;
	}

	@Override
	public boolean alterarEmpresa(String cnpj) {
		if (getInstance().existe(cnpj)) {
			Empresa c = procurar(cnpj);
			empresas.set(empresas.indexOf(c), c);
			RepositorioEmpresa.salvar();
			return true;
		}
		return false;
	}


	@Override
	public boolean existe(String cnpj) {
		boolean existe = false;
		Empresa u = this.procurar(cnpj);
		if (u != null) {
			existe = true;
			System.out.println("Empresa existe!");
		} else {
			System.out.println("Empresa nao existe!");
		}
		return existe;
	}

	@Override
	public void printar(Empresa emp) {
		try {
			JOptionPane.showMessageDialog(null, emp.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}