package livraria.view;

import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Representa a tela de Menu principal da app.
 * @author cristovao
 *
 */
@SuppressWarnings("serial")
public class TelaMenu extends Tela {
	
	private JButton cadastroButton,
					vendaButton,
					consultaButton,
					sairButton;

	/**
	 * Melhor tamanho observado para Linux app: 495x75.
	 * Melhor tamanho observado para Windows app: TODO: ver o melhor tamanho
	 * @param largura
	 * @param altura
	 * @param nome
	 * @throws HeadlessException
	 */
	public TelaMenu(int largura, int altura, String nome) throws HeadlessException {
		super(largura, altura, nome);
		
		// Instanciar os botões.
		cadastroButton = new JButton("Realizar Cadastro");
		vendaButton = new JButton("Realizar Venda");
		consultaButton = new JButton("Consultar");
		sairButton = new JButton("Sair");
		
		// Configurar o gerenciador de layout para esse JFrame.
		setLayout(new FlowLayout());
		
		// Adicionar os componentes no JFrame.
		// Como o gerenciador de componentes é o FlowLayout, temos 
		// a ordem de inserção deles preservada conforme o código abaixo.
		add(cadastroButton);
		add(vendaButton);
		add(consultaButton);
		add(sairButton);
		
		// Configurar a exibição no processo de instanciação da tela.
		setVisible(true);
		// Configura o comportamento de fechamento da tela via "X" ou "alt+F4"
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	/**
	 * @return the cadastroButton
	 */
	public JButton getCadastroButton() {
		return cadastroButton;
	}

	/**
	 * @return the vendaButton
	 */
	public JButton getVendaButton() {
		return vendaButton;
	}

	/**
	 * @return the consultaButton
	 */
	public JButton getConsultaButton() {
		return consultaButton;
	}

	/**
	 * @return the sairButton
	 */
	public JButton getSairButton() {
		return sairButton;
	}
	
}
