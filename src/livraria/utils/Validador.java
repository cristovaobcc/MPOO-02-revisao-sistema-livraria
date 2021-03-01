package livraria.utils;

import livraria.model.Cliente;
import livraria.model.Livro;

/**
 * Classe que valida dados inseridos nos models.
 * @author cristovao
 *
 */
public final class Validador {
	
	/**
	 * Verifica se o Livro l contém todos os seus dados preenchidos de acordo
	 * com os as regras de negócios.
	 * @param l {@link Livro}
	 * @return boolean true, se é válido; false, caso contrário.
	 */
	public static boolean isLivroValido(Livro l) {
		
		if (l.getAutor() != null &&
				l.getTitulo() != null &&
				l.getIsbn() != null &&
				l.getEditora() != null) {
			
			if (l.getAutor().length() > 1 &&
					l.getTitulo().length() > 1 &&
					l.getIsbn().length() > 1 &&
					l.getEditora().length() > 1) {
				return true;
			}
		}
		Destructor.destroy(l);
		return false;
	}
	
	/**
	 * Verifica se o Cliente c contém todos os seus dados preenchidos de acordo
	 * com os as regras de negócios.
	 * @param c {@link Cliente}
	 * @return boolean
	 */
	public static boolean isClienteValido(Cliente c) {
		
		if (c.getCpf() != null && 
				c.getNome() != null) {
			
			if (c.getCpf().length()== 11 &&
					c.getNome().length() > 1) {
				return true;
			}
		}
		
		return false;
	}

}
