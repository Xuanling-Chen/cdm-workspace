package cdm.observable.asset;


/**
 * The enumerated values to specify the type of quotation rate to be obtained from each cash settlement reference bank.
 * @version ${project.version}
 */
public enum QuotationRateTypeEnum {
    

	/**
	 * A bid rate.
	 */
	BID,
	    

	/**
	 * An ask rate.
	 */
	ASK,
	    

	/**
	 * A mid-market rate.
	 */
	MID,
	    

	/**
	 * If optional early termination is applicable to a swap transaction, the rate, which may be a bid or ask rate, which would result, if seller is in-the-money, in the higher absolute value of the cash settlement amount, or, is seller is out-of-the-money, in the lower absolute value of the cash settlement amount.
	 */
	EXERCISING_PARTY_PAYS    
	;

	private final String displayName;
	
	QuotationRateTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
