package livraria.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import livraria.model.BaseDados;
import livraria.model.Cliente;
import livraria.model.Estoque;
import livraria.model.Livro;
import livraria.model.Transacao;
import livraria.utils.Destructor;
import livraria.utils.Validador;
import livraria.view.Tela;
import livraria.view.TelaCadastro;
import livraria.view.TelaEstoque;
import livraria.view.TelaMenu;
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
		configuraClasseInternaAnonima();
		
	}
	
	/**
	 * Configura os eventListeners com classes internas
	 * anônimas.
	 */
	private void configuraClasseInternaAnonima() {
		
		TelaMenu telaM = (TelaMenu) telaMenu;
		telaM.getCadastroButton().addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						telaMenu.setVisible(false);
						telaCadastro.setVisible(true);
						
					}
				}
				
				);
		
		telaM.getVendaButton().addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						telaMenu.setVisible(false);
						telaVenda.setVisible(true);
						
					}
					
				}
				);
		
		telaM.getConsultaButton().addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						telaM.setVisible(true);
						String dados = Estoque.exibirDados();
						((TelaEstoque) telaEstoque).getInfoArea().setText(dados);
						telaEstoque.setVisible(true);
						
					}
					
				}
				
				);
		
		telaM.getSairButton().addActionListener(
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
					}
					
				}
				
				);
		
		TelaCadastro telaCad = (TelaCadastro) telaCadastro;
		
		telaCad.getLivroRadioButton().addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (telaCad.getLivroRadioButton().isSelected()) {
							telaCad.getClientePanel().setVisible(false);
							telaCad.getLivroPanel().setVisible(true);
						}						
					}
				}
				);
		
		telaCad.getClienteRadioButton().addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (telaCad.getClienteRadioButton().isSelected()) {
							telaCad.getClientePanel().setVisible(true);
							telaCad.getLivroPanel().setVisible(false);
						}
						
					}
				}
				
				);
						
		telaCad.addWindowListener(
				
				new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						telaCadastro.setVisible(false);
						telaMenu.setVisible(true);
					}
					
				}
				
				);
		
		TelaVenda telaVen = (TelaVenda) telaVenda;
		telaVen.addWindowListener(
				
				new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						telaVenda.setVisible(false);
						telaMenu.setVisible(true);
					}
					
				}
				
				);
		
		TelaEstoque telaEst = (TelaEstoque) telaEstoque;
		telaEst.addWindowListener(
				
				new WindowAdapter() {

					@Override
					public void windowClosed(WindowEvent e) {
						telaEstoque.setVisible(false);
						telaMenu.setVisible(true);
					}
					
				}
				
				);

	}

	/**
	 * Configura os eventListeners desta classe. 
	 * 
	 */
	private void control() {
		JButton button = ((TelaCadastro) telaCadastro).getAddButton();
		button.addActionListener(this);
		button = ((TelaVenda) telaVenda).getConfirmarButton();
		button.addActionListener(this);
		
	}
	
	/**
	 * Trata os eventos nesta classe.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {		
		
		// Cadastramento de livro
		if (isAcionadoAddButton(e) && 
				((TelaCadastro) telaCadastro).getLivroRadioButton().isSelected()) {
			
			Livro livro = carregaDadosPreenchidosDeLivro(telaCadastro);
			if(Validador.isLivroValido(livro) ) {
				Estoque.addLivro(livro);
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro.");
			}
			Destructor.destroy(livro);
		}
		// Cadastramento de cliente
		else if (isAcionadoAddButton(e) &&
				((TelaCadastro) telaCadastro).getClienteRadioButton().isSelected()) {
			
			Cliente cliente = carregaDadosPreenchidosDeCliente(telaCadastro);
			if(Validador.isClienteValido(cliente)) {
				BaseDados.addCliente(cliente);
				JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null,"Erro ao cadastrar cliente.");
			}
			Destructor.destroy(cliente);
			
			
		}
		else if (e.getSource() == ((TelaVenda) telaVenda).getConfirmarButton()) {
			Livro livro = carregaDadosPreenchidosDeLivro(telaVenda);
			Cliente cliente = carregaDadosPreenchidosDeCliente(telaVenda);
			cliente = BaseDados.getCliente(cliente);
			if (Estoque.existeLivro(livro) && cliente != null) {
				livro = Estoque.buscarLivro(livro);
				if (Transacao.venda(cliente, livro)) {
					JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
					Transacao.exibirTransacoes();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao realizar a venda");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao realizar a venda");
			}
			
			Destructor.destroy(cliente);
			Destructor.destroy(livro);
		}
		

	}
	
	
	/**
	 * Devolve um Cliente com os dados preenchidos da tela de cadastro de cliente ou tela de venda
	 * de livro. Devolve null caso a tela passada não seja de cadastro ou de venda.
	 * @param tela {@link Tela}
	 * @return {@link Cliente} 
	 */
	private Cliente carregaDadosPreenchidosDeCliente(Tela tela) {
		Cliente cliente;
		if(tela instanceof TelaCadastro) {
			TelaCadastro telaCad = (TelaCadastro) tela;
			cliente = new Cliente(telaCad.getNomeTextField().getText(), telaCad.getCpfTextField().getText());
			Destructor.destroy(telaCad);
			return cliente;
		} else if (tela instanceof TelaVenda) {
			TelaVenda telaVenda = (TelaVenda) tela;
			cliente = new Cliente(telaVenda.getCpfTextField().getText());
			Destructor.destroy(telaVenda);
			return cliente;
			
		}
		return null;
	}
	
	/**
	 * Devolve um Livro com os dados preenchidos da tela de cadastro de livros ou tela de venda
	 * de livro. Devolve null caso a tela passada não seja de cadastro ou de venda.
	 * @param tela {@link Tela}
	 * @return {@link Livro}
	 */
	private Livro carregaDadosPreenchidosDeLivro(Tela tela) {
		if(tela instanceof TelaCadastro) {
			TelaCadastro telaCad = (TelaCadastro) tela;
			return new Livro(telaCad.getIsbnTextField().getText(), 
					telaCad.getTituloTextField().getText(), 
					telaCad.getAutorTextField().getText(), 
					telaCad.getEditoraTextField().getText(), 
					false);
		}
		else if (tela instanceof TelaVenda) {
			TelaVenda telaVenda = (TelaVenda) tela;
			return new Livro(telaVenda.getTituloTextField().getText(), telaVenda.getAutorTextField().getText());
		}
		return 	null;
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
