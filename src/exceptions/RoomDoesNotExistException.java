package exceptions;

public class RoomDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1L;
	public RoomDoesNotExistException(String massage) {
		super("Room Number :"+massage+ " Does not exist in the system.");
	}

}
