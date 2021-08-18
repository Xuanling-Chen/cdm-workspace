package cdm.base.staticdata.party;


/**
 * The enumerated values for the natural person&#39;s role.
 * @version ${project.version}
 */
public enum NaturalPersonRoleEnum {
    

	/**
	 * The person who arranged with a client to execute the trade.
	 */
	BROKER,
	    

	/**
	 * Acquirer of the legal title to the financial instrument.
	 */
	BUYER,
	    

	/**
	 * The party or person with legal responsibility for authorization of the execution of the transaction.
	 */
	DECISION_MAKER,
	    

	/**
	 * Person within the firm who is responsible for execution of the transaction.
	 */
	EXECUTION_WITHIN_FIRM,
	    

	/**
	 * Person who is responsible for making the investment decision.
	 */
	INVESTMENT_DECISION_MAKER,
	    

	/**
	 * Seller of the legal title to the financial instrument.
	 */
	SELLER,
	    

	/**
	 * The person who executed the trade.
	 */
	TRADER    
	;

	private final String displayName;
	
	NaturalPersonRoleEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
