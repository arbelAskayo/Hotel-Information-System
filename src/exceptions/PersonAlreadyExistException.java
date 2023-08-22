package exceptions;

public class PersonAlreadyExistException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PersonAlreadyExistException(String fname, String lname) {
		super(fname +" "+lname+" already exists in the system, will not be added again");
	}
	public PersonAlreadyExistException() {
		super("  Person Already Exist In The System, will not be added again");
	}
	

}
