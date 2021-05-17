package model.exceptions;

//RuntimeException o compilador n�o obriga a tratar.
public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;//declara��o para vers�o de uma classe serializable.
	public DomainException(String msg) {
		super(msg);
	}
	
}
