
package exceptions;

public class DepManagerDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1L;
	public DepManagerDoesNotExistException(String massage) {
		super("Department Manager: "+massage+ " Does not exist in the system.");
	}

}
