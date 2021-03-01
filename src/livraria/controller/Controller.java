package livraria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import livraria.model.BaseDados;
import livraria.model.Cliente;
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
		
		TelaCadastro tela;
		// Cadastramento de livro
		if (isAcionadoAddButton(e) && 
				((TelaCadastro) telaCadastro).getLivroRadioButton().isSelected()) {
			
			tela = (TelaCadastro) telaCadastro;
			Livro livro = carregaDadosPreenchidosDeLivro(tela);
			if(Validador.isLivroValido(livro) ) {
				Estoque.addLivro(livro);
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro.");
			}
			Destructor.destroy(livro);
			Destructor.destroy(tela);
		}
		// Cadastramento de cliente
		if (isAcionadoAddButton(e) &&
				((TelaCadastro) telaCadastro).getClienteRadioButton().isSelected()) {
			tela = (TelaCadastro) telaCadastro;
			Cliente cliente = carregaDadosPreenchidosDeCliente(tela);
			if(Validador.isClienteValido(cliente)) {
				BaseDados.addCliente(cliente);
				JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null,"Erro ao cadastrar cliente.");
			}
			Destructor.destroy(cliente);
			Destructor.destroy(tela);
			
		}
		
		
	}
	
	
	/**
	 * Devolve um Cliente com os dados preenchidos da tela de cadastro de cliente.
	 * @param tela {@link TelaCadastro}
	 * @return {@link Cliente}
	 */
	private Cliente carregaDadosPreenchidosDeCliente(TelaCadastro tela) {
		// TODO: pensar numa implementação para a gerar numero de matricula do cliente.
		return new Cliente(tela.getNomeTextField().getText(), tela.getCpfTextField().getText(), null);
	}
	
	/**
	 * Devolve um Livro com os dados preenchidos da tela de cadastro de livros.
	 * @param tela {@link TelaCadastro}
	 * @return {@link Livro}
	 */
	private Livro carregaDadosPreenchidosDeLivro(TelaCadastro tela) {
		return new Livro(tela.getIsbnTextField().getText(), 
				tela.getTituloTextField().getText(), 
				tela.getAutorTextField().getText(), 
				tela.getEditoraTextField().getText(), 
				false);	
	}
	
	/**
	 * Verifica se o botão acionado foi o AddButton da TelaCadastro.
	 * @param e {@link ActionEvent}
	 * @return boolean
	 */
	private boolean isAcionadoAddButton(ActionEvent e) {
		if (e.getSource() == ((TelaCadastro) telaCadastro).getAddButton()) {
			return true;
		}
		
		return false;
	}

}
