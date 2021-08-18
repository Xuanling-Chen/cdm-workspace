package cdm.product.common;


/**
 * The enumerated values to specify the conditions that govern the adjustment to the number of units of the return swap.
 * @version ${project.version}
 */
public enum NotionalAdjustmentEnum {
    

	/**
	 * The adjustments to the number of units are governed by an execution clause.
	 */
	EXECUTION,
	    

	/**
	 * The adjustments to the number of units are governed by a portfolio rebalancing clause.
	 */
	PORTFOLIO_REBALANCING,
	    

	/**
	 * The adjustments to the number of units are not governed by any specific clause.
	 */
	STANDARD    
	;

	private final String displayName;
	
	NotionalAdjustmentEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
