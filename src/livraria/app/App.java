/**
 * 
 */
package livraria.app;

import livraria.controller.Controller;
import livraria.view.Tela;
import livraria.view.TelaCadastro;
import livraria.view.TelaEstoque;
import livraria.view.TelaMenu;
import livraria.view.TelaVenda;

/**
 * Classe que inicia a aplicação.
 * @author cristovao
 *
 */
public class App {

	/**
	 * Inicia a app.
	 * @param args
	 */
	public static void main(String[] args) {
	
		Tela telaMenu = new TelaMenu(495,75,"Menu");
		Tela telaCadastro = new TelaCadastro(240, 300, "Cadastro");
		Tela telaVenda = new TelaVenda(180, 150, "Venda");
		Tela telaEstoque = new TelaEstoque(150, 300, "Estoque");
		
		new Controller(telaMenu, telaCadastro, telaVenda, telaEstoque);
	}

}
