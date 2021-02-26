package livraria.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Tela extends JFrame {
	
	@SuppressWarnings("unused")
	private int largura;
	@SuppressWarnings("unused")
	private int altura;
	@SuppressWarnings("unused")
	private String nome;
	
	/**
	 * Recebe os dados básicos da tela.
	 * @param largura int
	 * @param altura int
	 * @param nome String
	 * @throws HeadlessException
	 */
	public Tela(int largura, int altura, String nome) throws HeadlessException {
		super(nome);
		this.largura = largura;
		this.altura = altura;
		this.nome = nome;
		
		setSize(largura, altura);
	}
	
	

}
