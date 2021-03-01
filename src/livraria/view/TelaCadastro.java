package livraria.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TelaCadastro extends Tela {
	
	
	private JRadioButton livroRadioButton,
				clienteRadioButton;
	
	private ButtonGroup radioButtonGroup;
	
	private JLabel isbnLabel,
				tituloLabel,
				autorLabel,
				editoraLabel,
				nomeLabel,
				cpfLabel,
				avisoLabel;
	
	private JTextField isbnTextField,
		tituloTextField,
		autorTextField,
		editoraTextField,
		nomeTextField,
		cpfTextField;
	
	
	private JButton addButton;
	
	private JPanel radioButtonsPanel,
					livroPanel,
					clientePanel,
					addButtonPanel;
	
	/**
	 * Melhor tamanho observado para Linux app: 
	 * Melhor tamanho observado para Windows app: TODO: ver o melhor tamanho
	 * @param largura int
	 * @param altura int
	 * @param nome String
	 * @throws HeadlessException
	 */
	public TelaCadastro(int largura, int altura, String nome) throws HeadlessException {
		super(largura, altura, nome);
		
		setLayout(new FlowLayout());
				
		instanciaComponentes();
		
		radioButtonGroup.add(clienteRadioButton);
		radioButtonGroup.add(livroRadioButton);
		livroRadioButton.isSelected();
		
		radioButtonsPanel.add(livroRadioButton);
		radioButtonsPanel.add(clienteRadioButton);
		livroRadioButton.setSelected(true);
		
		livroPanel.add(isbnLabel);
		livroPanel.add(isbnTextField);
		livroPanel.add(tituloLabel);
		livroPanel.add(tituloTextField);
		livroPanel.add(autorLabel);
		livroPanel.add(autorTextField);
		livroPanel.add(editoraLabel);
		livroPanel.add(editoraTextField);
		
		clientePanel.add(nomeLabel);
		clientePanel.add(nomeTextField);
		clientePanel.add(cpfLabel);
		clientePanel.add(cpfTextField);
		
		addButtonPanel.add(avisoLabel);
		addButtonPanel.add(addButton);
		
		add(radioButtonsPanel);
		add(livroPanel);
		add(clientePanel);
		add(addButtonPanel);
		
		clientePanel.setVisible(true);
		
		setVisible(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	private void instanciaComponentes() {
		
		livroRadioButton = new JRadioButton("Livro");
		clienteRadioButton = new JRadioButton("Cliente");
		
		radioButtonGroup = new ButtonGroup();
		
		isbnLabel = new JLabel("ISBN:");
		tituloLabel = new JLabel("Titulo:");
		autorLabel = new JLabel("Autor:");
		editoraLabel = new JLabel("Editora:");
		nomeLabel = new JLabel("Nome:");
		cpfLabel = new JLabel("CPF:");
		avisoLabel = new JLabel("Todos os campos são obrigatórios");

		isbnTextField = new JTextField(15);
		tituloTextField = new JTextField(15);
		autorTextField = new JTextField(15);
		editoraTextField = new JTextField(15);
		nomeTextField = new JTextField(15);
		cpfTextField = new JTextField(15);
		
		addButton = new JButton("Add");
		
		radioButtonsPanel = new JPanel(new FlowLayout());
		livroPanel = new JPanel(new GridLayout(8, 1));
		clientePanel = new JPanel(new GridLayout(4, 1));
		addButtonPanel  = new JPanel(new GridLayout(2,1));
		
	}

	/**
	 * @return the livroRadioButton
	 */
	public JRadioButton getLivroRadioButton() {
		return livroRadioButton;
	}

	/**
	 * @return the clienteRadioButton
	 */
	public JRadioButton getClienteRadioButton() {
		return clienteRadioButton;
	}
	

	/**
	 * @return the isbnTextField
	 */
	public JTextField getIsbnTextField() {
		return isbnTextField;
	}

	/**
	 * @return the tituloTextField
	 */
	public JTextField getTituloTextField() {
		return tituloTextField;
	}

	/**
	 * @return the autorTextField
	 */
	public JTextField getAutorTextField() {
		return autorTextField;
	}

	/**
	 * @return the editoraTextField
	 */
	public JTextField getEditoraTextField() {
		return editoraTextField;
	}

	/**
	 * @return the nomeTextField
	 */
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	/**
	 * @return the cpfTextField
	 */
	public JTextField getCpfTextField() {
		return cpfTextField;
	}

	/**
	 * @return the addButton
	 */
	public JButton getAddButton() {
		return addButton;
	}

		
	
}
