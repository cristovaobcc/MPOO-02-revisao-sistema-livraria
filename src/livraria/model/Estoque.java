package livraria.model;

import java.util.ArrayList;


public class Estoque {
	
	private static ArrayList<Livro> livros = new ArrayList<Livro>();
		
	
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
	 * Verifica se o livro(com o título e autor configurados) passado 
	 * como argumento existe no estoque.
	 * @param livro Livro
	 * @return boolean true, se existe; false, do contrário.
	 */
	public static boolean existeLivro(Livro livro) {
		for (Livro livroAtual : livros) {
			if (livroAtual.getAutor().equalsIgnoreCase(livro.getAutor().toLowerCase()) &&
					livroAtual
					.getTitulo().compareToIgnoreCase(livro.getTitulo().toLowerCase()) == 0) {
				
				//livro = livroAtual; // Não funciona! Lembre que em java a passagem de parametros é por cópia!
				livro.setIsbn(livroAtual.getIsbn()); // Aqui, de fato, acessamos o objeto na memória e o configuramos com uma variável da stack do método!
				livro.setEditora(livroAtual.getEditora());
				return true;
			} 
		}
		
		return false;
		
	}
	
	/**
	 * Devolve um livro buscado (com base no título e autor configurados),
	 * caso exista. Do contrário, devolve null.
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
	public static ArrayList<Livro> getLivros() {
		return livros;
	}
	
	/**
	 * Exibe os dados dos livros de forma organizada para 
	 * exibir na tela.
	 * @return String
	 */
	public static String exibirDados() {
		//TODO: corrigir a repetição de dados de livros.
		StringBuilder livrosSB = new StringBuilder();
		int qtde = 0;
		String livroAtual;
		for (Livro l : livros) {
			qtde = quantidadeLivro(l);
			livroAtual = String.format("Titulo: %s%n"
					+ "Autor: %s%n"
					+ "Editora: %s%n"
					+ "ISBN: %s%n"
					+ "Qtde: %03d", 
					l.getTitulo(), l.getAutor(), l.getEditora(), l.getIsbn(), qtde);
			livrosSB.append(livroAtual + String.format("%n%n---%n%n"));
		}
		return livrosSB.toString();
	}
	
}
