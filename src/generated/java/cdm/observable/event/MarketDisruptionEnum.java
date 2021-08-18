package cdm.observable.event;


/**
 * The enumerated values to specify the handling of an averaging date market disruption for an equity derivative transaction.
 * @version ${project.version}
 */
public enum MarketDisruptionEnum {
    

	/**
	 * As defined in section 6.7 paragraph (c) sub-paragraph (iii) of the ISDA 2002 Equity Derivative definitions.
	 */
	MODIFIED_POSTPONEMENT,
	    

	/**
	 * As defined in section 6.7 paragraph (c) sub-paragraph (i) of the ISDA 2002 Equity Derivative definitions.
	 */
	OMISSION,
	    

	/**
	 * As defined in section 6.7 paragraph (c) sub-paragraph (ii) of the ISDA 2002 Equity Derivative definitions.
	 */
	POSTPONEMENT    
	;

	private final String displayName;
	
	MarketDisruptionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
