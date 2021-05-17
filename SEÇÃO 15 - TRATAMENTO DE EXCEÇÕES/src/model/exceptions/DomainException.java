package model.exceptions;

//RuntimeException o compilador não obriga a tratar.
public class DomainException extends Exception {

	private static final long serialVersionUID = 1L;//declaração para versão de uma classe serializable.
	public DomainException(String msg) {
		super(msg);
	}
	
}
