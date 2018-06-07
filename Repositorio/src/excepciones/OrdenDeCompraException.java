package excepciones;

public class OrdenDeCompraException  extends Exception{
	private static final long serialVersionUID = 6380259435307419894L;

	public OrdenDeCompraException (String mensaje){
		super(mensaje);
	}

}
