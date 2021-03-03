package livraria.testes;

import livraria.controller.Controller;
import livraria.model.BaseDados;
import livraria.model.Cliente;
import livraria.model.Estoque;
import livraria.model.Livro;
import livraria.model.Transacao;
import livraria.view.Tela;
import livraria.view.TelaCadastro;
import livraria.view.TelaEstoque;
import livraria.view.TelaMenu;
import livraria.view.TelaVenda;

/**
 * Classe de testes do sistema.
 * @author Cristovao
 *
 */
public class TestesApp {


	@SuppressWarnings("unused")
	public static void mainDeTeste(String[] args) {
		testeDeLivroEEstoque();
		testeDeOutrosComponentesDoModel();
		
		Tela telaMenu = new TelaMenu(495, 75, "Menu");
		
		TelaCadastro telaCadastro = new TelaCadastro(240, 300, "Cadastro");
				
		TelaVenda telaVenda = new TelaVenda(180, 150, "Venda");
		
		TelaEstoque telaEstoque = new TelaEstoque(150, 150, "Estoque");
		
		Controller controller = new Controller(telaMenu, telaCadastro, telaVenda, telaEstoque);
		
		
		
	}
	
	private static void testeDeOutrosComponentesDoModel() {
		Livro l1 = new Livro("456", "1Q84 -  vol1", "Haruki Murakami", "Fucture", true);
		l1 = new Livro("457", "Tsukuru Tazaki e seus anos de peregrinação", "Haruki Murakami", "Fucture", true);
		
		Cliente c1 = new Cliente("Knuth", "123", 1);
		BaseDados.addCliente(c1);
		c1 = new Cliente("Feynman", "124", 2);
		BaseDados.addCliente(c1);
		
		Cliente clienteAComprarLivro = new Cliente("123");
		clienteAComprarLivro = BaseDados.getCliente(clienteAComprarLivro);
		@SuppressWarnings("unused")
		boolean vendido = Transacao.venda(clienteAComprarLivro, l1);
		
		clienteAComprarLivro = new Cliente("124");
		clienteAComprarLivro = BaseDados.getCliente(clienteAComprarLivro);
		vendido = Transacao.venda(clienteAComprarLivro, l1);
		
		l1 = new Livro("Alice", "Carol");
		
		vendido = Transacao.venda(clienteAComprarLivro, l1);
		
		String dadosTransacoes = Transacao.exibirTransacoes();
		System.out.println("------------------");
		System.out.println(dadosTransacoes);
	}

	private static void testeDeLivroEEstoque() {
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
