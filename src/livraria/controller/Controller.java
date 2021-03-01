package livraria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import livraria.model.Estoque;
import livraria.model.Livro;
import livraria.utils.Destructor;
import livraria.utils.Validador;
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
public class Controller implements ActionListener {
	
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
		
		if (isAcionadoAddButton(e) && 
				((TelaCadastro) telaCadastro).getLivroRadioButton().isSelected()) {
			
			TelaCadastro tela = (TelaCadastro) telaCadastro;
			Livro livro = carregaDadosPreenchidos(tela);
			if(Validador.isLivroValido(livro) ) {
				Estoque.addLivro(livro);
				Destructor.destroy(livro);
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso !");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro.");
			}
			// Códigos de testes:
			System.out.println("********************");
			String dados = Estoque.exibirDados();
			System.out.println(dados);
		}
		
	}
	
	private Livro carregaDadosPreenchidos(TelaCadastro tela) {
		return new Livro(tela.getIsbnTextField().getText(), 
				tela.getTituloTextField().getText(), 
				tela.getAutorTextField().getText(), 
				tela.getEditoraTextField().getText(), 
				false);	
	}
	
	private boolean isAcionadoAddButton(ActionEvent e) {
		if (e.getSource() == ((TelaCadastro) telaCadastro).getAddButton()) {
			return true;
		}
		
		return false;
	}

}
