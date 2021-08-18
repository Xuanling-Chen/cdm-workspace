package cdm.product.asset;


/**
 * Denotes the method by which the pricing days are distributed across the pricing period.
 * @version ${project.version}
 */
public enum DayDistributionEnum {
    

	/**
	 */
	ALL,
	    

	/**
	 */
	FIRST,
	    

	/**
	 */
	LAST,
	    

	/**
	 */
	PENULTIMATE    
	;

	private final String displayName;
	
	DayDistributionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
