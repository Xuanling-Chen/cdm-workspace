package cdm.observable.event;


/**
 * The enumerated values to specify the form of the restructuring credit event that is applicable to the credit default swap.
 * @version ${project.version}
 */
public enum RestructuringEnum {
    

	/**
	 * Restructuring (Section 4.7) and Modified Restructuring Maturity Limitation and Conditionally Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
	 */
	MOD_MOD_R,
	    

	/**
	 * Restructuring (Section 4.7) and Restructuring Maturity Limitation and Fully Transferable Obligation (2014 Definitions: Section 3.31, 2003 Definitions: 2.32) apply.
	 */
	MOD_R,
	    

	/**
	 * Restructuring as defined in the applicable ISDA Credit Derivatives Definitions. (2003 or 2014).
	 */
	R    
	;

	private final String displayName;
	
	RestructuringEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
