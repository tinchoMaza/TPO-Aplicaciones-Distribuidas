package excepciones;

public class LoteException extends Exception {
 
	private static final long serialVersionUID = 1L;

	public LoteException (String mensaje){
		super(mensaje);
	}

}
