package cdm.observable.asset;


/**
 * The enumerated values to specify how an exchange rate is quoted.
 * @version ${project.version}
 */
public enum QuoteBasisEnum {
    

	/**
	 * The amount of currency1 for one unit of currency2
	 */
	CURRENCY_1_PER_CURRENCY_2,
	    

	/**
	 * The amount of currency2 for one unit of currency1
	 */
	CURRENCY_2_PER_CURRENCY_1    
	;

	private final String displayName;
	
	QuoteBasisEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
