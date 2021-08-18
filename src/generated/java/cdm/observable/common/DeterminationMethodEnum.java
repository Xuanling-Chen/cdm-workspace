package cdm.observable.common;


/**
 * The enumerated values to specify the method according to which an amount or a date is determined.
 * @version ${project.version}
 */
public enum DeterminationMethodEnum {
    

	/**
	 * Agreed separately between the parties.
	 */
	AGREED_INITIAL_PRICE,
	    

	/**
	 * As specified in Master Confirmation.
	 */
	AS_SPECIFIED_IN_MASTER_CONFIRMATION,
	    

	/**
	 * Determined by the Calculation Agent.
	 */
	CALCULATION_AGENT,
	    

	/**
	 * Official Closing Price.
	 */
	CLOSING_PRICE,
	    

	/**
	 * Determined by the Currency of Equity Dividends.
	 */
	DIVIDEND_CURRENCY,
	    

	/**
	 * The initial Index Level is the level of the Expiring Contract as provided in the Master Confirmation.
	 */
	EXPIRING_CONTRACT_LEVEL,
	    

	/**
	 * Determined by the Hedging Party.
	 */
	HEDGE_EXECUTION,
	    

	/**
	 * Issuer Payment Currency.
	 */
	ISSUER_PAYMENT_CURRENCY,
	    

	/**
	 * Net Asset Value.
	 */
	NAV,
	    

	/**
	 * Opening Price of the Market.
	 */
	OPEN_PRICE,
	    

	/**
	 * Official Settlement Price.
	 */
	OSP_PRICE,
	    

	/**
	 * Settlement Currency.
	 */
	SETTLEMENT_CURRENCY,
	    

	/**
	 * Date on which the strike is determined in respect of a forward starting swap.
	 */
	STRIKE_DATE_DETERMINATION,
	    

	/**
	 * Official Trade-Weighted Average Price.
	 */
	TWAP_PRICE,
	    

	/**
	 * Price determined at valuation time.
	 */
	VALUATION_TIME,
	    

	/**
	 * Official Volume-Weighted Average Price.
	 */
	VWAP_PRICE    
	;

	private final String displayName;
	
	DeterminationMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
