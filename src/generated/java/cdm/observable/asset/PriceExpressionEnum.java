package cdm.observable.asset;


/**
 * he enumerated values to specify whether the price is expressed in absolute or relative terms.
 * @version ${project.version}
 */
public enum PriceExpressionEnum {
    

	/**
	 * The price is expressed as an absolute amount.
	 */
	ABSOLUTE_TERMS,
	    

	/**
	 * The price is expressed in percentage of the notional amount.
	 */
	PERCENTAGE_OF_NOTIONAL    
	;

	private final String displayName;
	
	PriceExpressionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
