
package exceptions;

public class CustomerDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1L;
	public CustomerDoesNotExistException(String massage) {
		super("Customer: "+massage+ " Does not exist in the system.");
	}

}
