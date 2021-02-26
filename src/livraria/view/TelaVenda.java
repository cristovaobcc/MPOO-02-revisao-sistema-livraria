package livraria.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Representa a tela de venda ao cliente.
 * 
 * @author cristovao
 *
 */
@SuppressWarnings("serial")
public class TelaVenda extends Tela {
	
	private JLabel tituloLabel,
					autorLabel,
					cpfLabel;
	private JTextField tituloTextField,
						autorTextField,
						cpfTextField;
	private JButton confirmarButton;
	private JPanel jPanel1, jPanel2;
	
	
	
	/**
	 * @param largura
	 * @param altura
	 * @param nome
	 * @throws HeadlessException
	 */
	public TelaVenda(int largura, int altura, String nome) throws HeadlessException {
		super(largura, altura, nome);
		
		instanciaComponentes();
		
		setLayout(new GridLayout(2, 1));
		jPanel1.add(tituloLabel);
		jPanel1.add(tituloTextField);
		jPanel1.add(autorLabel);
		jPanel1.add(autorTextField);
		jPanel1.add(cpfLabel);
		jPanel1.add(cpfTextField);
		
		jPanel2.add(confirmarButton);
		add(jPanel1);
		add(jPanel2);
		
		setVisible(false);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	private void instanciaComponentes() {
		
		tituloLabel = new JLabel("Titulo: ", SwingConstants.RIGHT);
		autorLabel = new JLabel("Autor: ",SwingConstants.RIGHT);
		cpfLabel = new JLabel("CPF: ",SwingConstants.RIGHT);
		
		tituloTextField = new JTextField(25);
		autorTextField = new JTextField(15);
		cpfTextField = new JTextField(15);
		
		confirmarButton = new JButton("Confirmar");
		
		jPanel1 = new JPanel(new GridLayout(3, 2));
		jPanel2 = new JPanel(new FlowLayout());
			
	}

}
