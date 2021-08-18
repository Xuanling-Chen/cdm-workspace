package cdm.legalagreement.csa;


/**
 * The enumerated values to specify an elective amount.
 * @version ${project.version}
 */
public enum ElectiveAmountEnum {
    

	/**
	 * The elective amount is zero.
	 */
	ZERO,
	    

	/**
	 * The elective amount has no upper limit.
	 */
	UNLIMITED    
	;

	private final String displayName;
	
	ElectiveAmountEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
