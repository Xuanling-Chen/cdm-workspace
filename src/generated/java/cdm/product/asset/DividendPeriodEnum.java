package cdm.product.asset;


/**
 * 2002 ISDA Equity Derivatives Definitions: First Period, Second Period |
 * @version ${project.version}
 */
public enum DividendPeriodEnum {
    

	/**
	 * 2002 ISDA Equity Derivatives Definitions: First Period means each period from, and including, one Cash Settlement Payment Date or Settlement Date, as the case may be, to, but excluding, the next following Cash Settlement Payment Date or Settlement Date, as the case may be, except that (i) the initial Dividend Period will commence on, and include, the Clearance System Business Day that is one Settlement Cycle following the Trade Date and (ii) the final Dividend Period will end on, but exclude, the final Cash Settlement Payment Date or Settlement Date, as the case may be.
	 */
	FIRST_PERIOD,
	    

	/**
	 * 2002 ISDA Equity Derivatives Definitions: Second Period means each period from, but excluding, one Valuation Date to, and including, the next Valuation Date, except that (i) the initial Dividend Period will commence on, but exclude, the Trade Date and (ii) the final Dividend Period will end on, and include, the final Valuation Date or, in respect of a Physically-settled Forward Transaction to which Variable Obligation is not applicable, the date that is one Settlement Cycle prior to the Settlement Date.
	 */
	SECOND_PERIOD    
	;

	private final String displayName;
	
	DividendPeriodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
