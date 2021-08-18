package cdm.legalagreement.common;


/**
 * @version ${project.version}
 */
public enum TerminationCurrencyConditionEnum {
    

	/**
	 * A currency in which payments would be due under one or more Transactions.
	 */
	PAYMENTS_DUE,
	    

	/**
	 * A currency that is freely available.
	 */
	FREELY_AVAILABLE,
	    

	/**
	 * A currency in which payments would be due under one or more Transactions and that is freely available.
	 */
	PAYMENTS_DUE_AND_FREELY_AVAILABLE,
	    

	/**
	 * Termination Currency Conditions are specified.
	 */
	SPECIFIED    
	;

	private final String displayName;
	
	TerminationCurrencyConditionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
