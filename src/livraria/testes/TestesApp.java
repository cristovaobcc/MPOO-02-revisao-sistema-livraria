package livraria.testes;

import livraria.model.Estoque;
import livraria.model.Livro;

/**
 * Classe de testes do sistema.
 * @author Cristovao
 *
 */
public class TestesApp {
	
	
	public static void main(String[] args) {
		// testando a composição
		Livro l1 = new Livro("123", "Alice", "Carol", "Arts", true);
		l1 = new Livro("124", "Wizard", "Baum", "Arts", true);
		l1 = new Livro("124", "Wizard", "Baum", "Arts", true);
		l1 = new Livro("125", "I, robot", "Asimov", "Fuctures", true);
		
				
		String dados = Estoque.exibirDados();
		System.out.println(dados);
		
		// Testar buscarLivro()	
		System.out.println("-------> Buscando livro <--------");
		Livro livroBuscado = Estoque.buscarLivro(new Livro("125", "I, robot", "Asimov", "Fuctures", false));
		System.out.println(livroBuscado.toStringToConsole());
		livroBuscado = Estoque.buscarLivro(new Livro("126", "Foundation", "Asimov", "Fuctures", false));
		System.out.println(livroBuscado);
		
		
		// Testar removerLivro()
		System.out.println("------->Removendo livro <--------");
		Estoque.removerLivro(l1);
		dados = Estoque.exibirDados();
		System.out.println(dados);

	}
	
	
}
