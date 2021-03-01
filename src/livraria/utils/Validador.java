package livraria.utils;

import livraria.model.Livro;

/**
 * Classe que valida dados inseridos nos models.
 * @author cristovao
 *
 */
public final class Validador {
	
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

}
