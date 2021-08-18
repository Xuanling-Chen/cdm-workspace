package cdm.legalagreement.csa;


/**
 * The enumerated values to specify the instances where the independent amount eligible collateral is not defined as a set of eligible collateral assets. 
 * @version ${project.version}
 */
public enum IndependentAmountEligibilityEnum {
    

	/**
	 * None.
	 */
	NONE,
	    

	/**
	 * None, unless otherwise specified in a Confirmation.
	 */
	NONE_UNLESS_SPECIFIED_IN_CONFIRMATION    
	;

	private final String displayName;
	
	IndependentAmountEligibilityEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
