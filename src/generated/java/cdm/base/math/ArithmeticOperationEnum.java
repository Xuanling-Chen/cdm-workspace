package cdm.base.math;


/**
 * An arithmetic operator that can be passed to a function
 * @version ${project.version}
 */
public enum ArithmeticOperationEnum {
    

	/**
	 * Addition
	 */
	ADD,
	    

	/**
	 * Subtraction
	 */
	SUBTRACT,
	    

	/**
	 * Multiplication
	 */
	MULTIPLY,
	    

	/**
	 * Division
	 */
	DIVIDE,
	    

	/**
	 * Max of 2 values
	 */
	MAX,
	    

	/**
	 * Min of 2 values
	 */
	MIN    
	;

	private final String displayName;
	
	ArithmeticOperationEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
