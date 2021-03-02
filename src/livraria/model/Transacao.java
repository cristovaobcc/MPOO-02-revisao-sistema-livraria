package livraria.model;

import java.util.ArrayList;

/**
 * Representa as transações realizadas por um cliente.
 * @author cristovao
 *
 */
public class Transacao {
	
	private static ArrayList<String> historicoTransacoes = new ArrayList<String>();
	
	/**
	 * Registra uma venda de livro a um cliente.
	 * @param cliente Cliente
	 * @param livro Livro
	 * @return boolean true, se houve a venda; false, do contrário.
	 */
	public static boolean venda(Cliente cliente, Livro livro) {
		Livro livroBuscado = Estoque.buscarLivro(livro);
		
		if (livroBuscado != null) {
			cliente.getLivrosComprados().add(livro);
			Estoque.removerLivro(livroBuscado);
			return historicoTransacoes.add(livroBuscado.toStringToConsole());
			
		}
		
		return false;
	}
	
	/**
	 * Devolve uma lista com todos os livros vendidos no formato abaixo:
	 * 
	 * Livro:\n
	 * Titulo: [titulo]\n
	 * Autor: [autor]\n
	 * Editora: [editora]\n
	 * ISBN: [isbn]\n
	 * 
	 * @return String
	 */
	public static String exibirTransacoes() {
		
		StringBuilder dadosSB = new StringBuilder();
		
		for (String string : historicoTransacoes) {
			dadosSB.append(string);
		}		
		
		return dadosSB.toString();
		
	}
}
