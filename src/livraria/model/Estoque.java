package livraria.model;

import java.util.ArrayList;


public class Estoque {
	
	private static ArrayList<Livro> livros;
	private static Estoque estoque;
	
	private Estoque() {
		livros = new ArrayList<Livro>(0);
	}
	
	/**
	 * Devolve a única instância de estoque do sistema.
	 * @return Estoque 
	 */
	public static Estoque getInstance() {
		if (estoque == null) {
			estoque = new Estoque();
		} 
		return estoque;
	}
	
	/**
	 * Add um livro ao estoque.
	 * @param livro Livro
	 * @return boolean true, se add com sucesso; false, do contrário.
	 */
	public static boolean addLivro(Livro livro) {
		return Estoque.livros.add(livro);
	}
	
	/**
	 * Remove um livro do estoque.
	 * @param livro Livro
	 * @return boolean true, se removido com sucesso; false, do contrário.
	 */
	public static boolean removerLivro(Livro livro) {
				
		return livros.remove(livro);
	}
	
	/**
	 * Verifica se o livro passado como argumento existe no 
	 * estoque.
	 * @param livro Livro
	 * @return boolean true, se existe; false, do contrário.
	 */
	public static boolean existeLivro(Livro livro) {
		for (Livro livroAtual : livros) {
			if (livroAtual.getAutor().equalsIgnoreCase(livro.getAutor().toLowerCase()) ||
					livroAtual
					.getTitulo().compareToIgnoreCase(livro.getTitulo().toLowerCase()) == 0) {
				return true;
			} 
		}
		
		return false;
		
	}
	
	/**
	 * Devolve um livro buscado, caso exista. Do contrário, devolve null.
	 * @param livro Livro buscado
	 * @return Livro
	 */
	public static Livro buscarLivro(Livro livro) {
		if (existeLivro(livro)) {
			for (Livro livroAtual : livros) {
				if (livroAtual.equals(livro)) {
					return livroAtual;
				}
			}
		}
		return null;
	}
	
	/**
	 * Devolve a quantidade de um livro passado como
	 * argumento.
	 * @param Livro
	 * @return Integer 
	 */
	public static Integer quantidadeLivro(Livro livro) {
		int qtde = 0;
		
		if (existeLivro(livro)) {
			for (Livro livroAtual : livros) {
				if (livroAtual.equals(livro)) {
					qtde++;
				}
			}
		}
		
		return qtde;
	}
	
	
	/**
	 * Devolve um ArrayList de livros cadastrados no estoque.
	 * @return ArrayList<Livro>
	 */
	public ArrayList<Livro> getLivros() {
		return livros;
	}
	
	public static String exibirDados() {
		StringBuilder livrosSB = new StringBuilder();
		int qtde = 0;
		String livroAtual;
		for (Livro l : livros) {
			qtde = quantidadeLivro(l);
			livroAtual = String.format("Titulo: %s%n"
					+ "Autor: %s%n"
					+ "Editora: %s%n"
					+ "ISBN: %s%n"
					+ "Qtde: %03d%n", 
					l.getTitulo(), l.getAutor(), l.getEditora(), l.getIsbn(), qtde);
			livrosSB.append(livroAtual + "%n---%n");
		}
		return livrosSB.toString();
	}
	
}
