package excepciones;

public class FacturaException  extends Exception{
	private static final long serialVersionUID = 418643886633736142L;

	public FacturaException (String mensaje){
		super(mensaje);
	}

}
