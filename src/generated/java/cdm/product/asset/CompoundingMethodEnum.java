package cdm.product.asset;


/**
 * The enumerated values to specify the type of compounding, e.g. flat, straight.
 * @version ${project.version}
 */
public enum CompoundingMethodEnum {
    

	/**
	 * Flat compounding. Compounding excludes the spread. Note that the first compounding period has it&#39;s interest calculated including any spread then subsequent periods compound this at a rate excluding the spread.
	 */
	FLAT,
	    

	/**
	 * No compounding is to be applied.
	 */
	NONE,
	    

	/**
	 * Straight compounding. Compounding includes the spread.
	 */
	STRAIGHT,
	    

	/**
	 * Spread Exclusive compounding.
	 */
	SPREAD_EXCLUSIVE    
	;

	private final String displayName;
	
	CompoundingMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
