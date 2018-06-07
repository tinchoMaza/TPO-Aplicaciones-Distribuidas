package excepciones;

public class OrdenDePedidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public OrdenDePedidoException (String mensaje){
		super(mensaje);
	}

}
