
package exceptions;

public class UserAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserAlreadyExistException() {
		super("User already exists in the system, will not be added again");
	}
	

}