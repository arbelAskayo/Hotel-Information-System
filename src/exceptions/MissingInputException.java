
package exceptions;

public class MissingInputException extends Exception {
	private static final long serialVersionUID = 1L;
	public MissingInputException(String massage) {
		super(massage+ " is empty, please fill it");
	}

}