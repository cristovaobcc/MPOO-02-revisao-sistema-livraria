package livraria.model;

import java.util.ArrayList;

public class Estoque {
	
	private static ArrayList<Livro> livros;
	
	/**
	 * Add um livro ao estoque.
	 * @param livro Livro
	 * @return boolean true, se add com sucesso; false, do contrário.
	 */
	public static boolean addLivro(Livro livro) {
		//TODO: implementar conforme requisitos.
		return false;
	}
	
	/**
	 * Remove um livro do estoque.
	 * @param livro Livro
	 * @return boolean true, se removido com sucesso; false, do contrário.
	 */
	public static boolean removerLivro(Livro livro) {
		//TODO: implementar conforme requisitos.
		return false;
	}
	
	/**
	 * Verifica se o livro passado como argumento existe no 
	 * estoque.
	 * @param livro Livro
	 * @return boolean true, se existe; false, do contrário.
	 */
	public static boolean existeLivro(Livro livro) {
		//TODO: implementar conforme requisitos.
		return false;
	}
	
	/**
	 * 
	 * @param livro
	 * @return Livro
	 */
	public static Livro buscarLivro(Livro livro) {
		//TODO: implementar conforme requisitos.
		return null;
	}
	
	/**
	 * Devolve a quantidade de um livro passado como
	 * argumento.
	 * @param Livro
	 * @return Integer 
	 */
	public static Integer quantidadeLivro(Livro livro) {
		
		//TODO: implementar conforme requisitos.
		return 0;
	}
	
	
	/**
	 * Devolve um ArrayList de livros cadastrados no estoque.
	 * @return ArrayList<Livro>
	 */
	private static ArrayList<Livro> getLivros() {
		//TODO: implementar conforme requisitos.
		return livros;
	}
}
