package cdm.legalagreement.common;


/**
 * The enumerated values to specify the length unit in the Resource type.
 * @version ${project.version}
 */
public enum LengthUnitEnum {
    

	/**
	 */
	PAGES,
	    

	/**
	 */
	TIME_UNIT    
	;

	private final String displayName;
	
	LengthUnitEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
