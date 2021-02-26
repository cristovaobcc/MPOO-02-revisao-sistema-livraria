package livraria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import livraria.view.Tela;
import livraria.view.TelaCadastro;
import livraria.view.TelaVenda;

/**
 * Classe que representa o controle, fazendo a intermediação entre
 * o model e a view. Aqui também foram inseridas regras de negócios
 * pertinentes ao sistema Livraria.
 * @author Cristovao
 *
 */
public class Controller implements ActionListener{
	
	private Tela telaMenu,
				telaCadastro,
				telaVenda,
				telaEstoque;

	/**
	 * @param telaMenu
	 * @param telaCadastro
	 * @param telaVenda
	 * @param telaEstoque
	 */
	public Controller(Tela telaMenu, Tela telaCadastro, Tela telaVenda, Tela telaEstoque) {
		
		this.telaMenu = telaMenu;
		this.telaCadastro = telaCadastro;
		this.telaVenda = telaVenda;
		this.telaEstoque = telaEstoque;
		
		control();
		
	}
	
	/**
	 * Configura os eventListeners desta classe.
	 */
	private void control() {
		JButton button = ((TelaCadastro) telaCadastro).getAddButton();
		button.addActionListener(this);
		button = ((TelaVenda) telaVenda).getConfirmarButton();
		button.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ((TelaCadastro) telaCadastro).getAddButton()) {
			System.out.println("Apertou o AddButton!");
		}
		
	}
	
	

}
