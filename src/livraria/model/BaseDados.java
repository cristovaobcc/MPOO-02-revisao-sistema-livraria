package livraria.model;

import java.util.ArrayList;

/**
 * Classe que representa a base de dados de clientes
 * do sistema.
 *  
 * @author Cristovao
 *
 */
public class BaseDados {
	// TODO: criar exceções para essa classe. Por exemplo: getCliente pode lança exceção.
	
	private static int matricula = 0;	
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	/**
	 * Adiciona o cliente na base de dados.
	 * @param cliente Cliente
	 * @return boolean true, se add com sucesso; false, do contrário.
	 */
	public static boolean addCliente(Cliente cliente) {
		cliente.setMatricula(++matricula);
		return clientes.add(cliente);
	}
	
	/**
	 * Obtém um cliente cadastrado na base de dados.
	 * @param cliente Cliente buscado
	 * @return Cliente
	 */
	public static Cliente getCliente(Cliente cliente) {
		int index = clientes.indexOf(cliente);
		return clientes.get(index);
	}
	
	/**
	 * Atualiza os dados de um cliente conforme o cliente do parametro.
	 * @param Cliente cliente 
	 * @return 
	 */
	public static boolean updateCliente(Cliente cliente) {
		int index = clientes.indexOf(cliente);
		Cliente clienteReposto = clientes.set(index, cliente);
		return clienteReposto != null ? true : false;
	}
	
	/**
	 * Remove um cliente passado no parametro.
	 * @param cliente Cliente
	 * @return boolean true, se add com sucesso; false, do contrário.
	 */
	public static boolean removeCliente(Cliente cliente) {
		return clientes.remove(cliente);
	}

	/**
	 * @return the matricula
	 */
	public static int getMatricula() {
		return matricula;
	}
	
	
}
