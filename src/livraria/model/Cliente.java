/**
 * 
 */
package livraria.model;

import java.util.ArrayList;

/**
 * Representa um cliente que será cadastrado para comprar
 * um livro.
 * @author Cristovao
 *
 */
public class Cliente extends Pessoa {
	
	private Integer matricula;
	
	private ArrayList<Livro> livrosComprados;
	
	/**
	 * 
	 * @param cpf String
	 */
	public Cliente(String cpf) {
		super("", cpf);

	}

	/**
	 * 
	 * @param nome String
	 * @param cpf String
	 * @param matricula Integer
	 */
	public Cliente(String nome, String cpf, Integer matricula) {
		super(nome, cpf);
		this.matricula = matricula;
		livrosComprados = new ArrayList<Livro>();
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public ArrayList<Livro> getLivrosComprados() {
		return livrosComprados;
	}

	public void setLivrosComprados(ArrayList<Livro> livrosComprados) {
		this.livrosComprados = livrosComprados;
	}
	
	
	@Override
	public String toString() {
		return "Cliente [matricula=" + matricula + ", toString()=" + super.toString() + "]";
	}

		
	

}
