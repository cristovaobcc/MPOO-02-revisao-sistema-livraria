package livraria.model;
/**
 * Classe que representa um livro.
 * @author Cristovao
 *
 */
public class Livro {
		
	private String isbn;
	private String titulo;
	private String autor;
	private String editora;
	/**
	 * @param isbn
	 * @param titulo
	 * @param autor
	 * @param editora
	 */
	public Livro(String isbn, String titulo, String autor, String editora) {
		
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		Estoque.addLivro(this);
	}
	
	
	
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}
	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * @return the editora
	 */
	public String getEditora() {
		return editora;
	}
	/**
	 * @param editora the editora to set
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	/**
	 * O ISBN é utilizado para gerar o hashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}
	
	/**
	 * O ISBN é usado para distinguir um livro do outro.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Livro other = (Livro) obj;
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "Livro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + "]";
	}
	
}
