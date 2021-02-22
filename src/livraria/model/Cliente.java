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
	 * @param nome
	 * @param cpf
	 * @param matricula
	 */
	public Cliente(String nome, String cpf, Integer matricula) {
		super(nome, cpf);
		this.matricula = matricula;
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
	
	/**
	 * Faz o hashCode de matrícula e cpf.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}
	
	/**
	 * Verifica a igualdade por cpf e matrícula.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (matricula == null) {
			if (other.matricula != null) {
				return false;
			}
		} else if (!matricula.equals(other.matricula)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [matricula=" + matricula + ", toString()=" + super.toString() + "]";
	}

		
	

}
