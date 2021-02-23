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
		Livro l1 = new Livro("123", "Alice", "Carol", "Arts");
		Livro l2 = new Livro("124", "Wizard", "Baum", "Arts");
		Livro l3 = new Livro("124", "Wizard", "Baum", "Arts");
		Livro l4 = new Livro("125", "I, robot", "Asimov", "Fuctures");
		
		
		
		Estoque.addLivro(l1);
		Estoque.addLivro(l2);
		Estoque.addLivro(l3);
		Estoque.addLivro(l4);
		
		String dados = Estoque.exibirDados();
		System.out.println(dados);
		
		// TODO: testar os outros métodos da classe Estoque.

	}
	
	
}
