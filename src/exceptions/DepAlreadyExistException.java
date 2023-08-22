package exceptions;

public class DepAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DepAlreadyExistException() {
		super("Department already exists in the system, will not be added again");
	}
	

}

