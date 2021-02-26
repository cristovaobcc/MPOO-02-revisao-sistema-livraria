/**
 * 
 */
package livraria.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Tela que exibirá o estoque de livros.
 * @author cristovao
 *
 */
@SuppressWarnings("serial")
public class TelaEstoque extends Tela {

	private JTextArea infoArea;

	/**
	 * @param largura
	 * @param altura
	 * @param nome
	 * @throws HeadlessException
	 */
	public TelaEstoque(int largura, int altura, String nome) throws HeadlessException {
		super(largura, altura, nome);
		
		setLayout(new BorderLayout());
		
		infoArea = new JTextArea("Dados do estoque", 6, 15);
		infoArea.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(infoArea,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(scroll, BorderLayout.CENTER);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
	
}
