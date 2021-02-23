package livraria.utils;

/**
 * Classe que serve de destrutor para qualquer objeto.
 * @author Cristovao
 *
 */
public final class Destructor {
	
	private Destructor() {};
	
	/**
	 * Destrói o objeto passado como argumento.
	 * @param obj Object to destroy.
	 */
	public static void destroy(Object obj) {
		obj = null;
		System.gc();
	}
	
}
