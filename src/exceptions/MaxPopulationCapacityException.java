/**
 * 
 */
package exceptions;


public class MaxPopulationCapacityException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MaxPopulationCapacityException() {
		super("	The number of people in the room is either below or above the allowable range");
	}
	

}
