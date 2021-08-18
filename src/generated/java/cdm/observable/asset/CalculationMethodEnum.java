package cdm.observable.asset;


/**
 * What calculation type is required, averaging or compounding. This enumeration is used to represent the definitions of modular calculated rates as described in the 2021 ISDA Definitions, section 7.
 * @version ${project.version}
 */
public enum CalculationMethodEnum {
    

	/**
	 * Averaging, i.e. arithmetic averaging.
	 */
	AVERAGING,
	    

	/**
	 * Compounding, i.e. geometric averaging following an ISDA defined formula.
	 */
	COMPOUNDING,
	    

	/**
	 * A rate based on an index that is computed by a rate administrator.  The user is responsible for backing out the rate by applying a simple formula.
	 */
	COMPOUNDED_INDEX    
	;

	private final String displayName;
	
	CalculationMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
