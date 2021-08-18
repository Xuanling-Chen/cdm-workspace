package cdm.observable.event;


/**
 * The enumerated values to specify the consequences of extraordinary events relating to the underlying.
 * @version ${project.version}
 */
public enum ShareExtraordinaryEventEnum {
    

	/**
	 * The trade continues such that the underlying now consists of the New Shares and/or the Other Consideration, if any, and the proceeds of any redemption, if any, that the holder of the underlying Shares would have been entitled to.
	 */
	ALTERNATIVE_OBLIGATION,
	    

	/**
	 * The trade is cancelled and a cancellation fee will be paid by one party to the other.
	 */
	CANCELLATION_AND_PAYMENT,
	    

	/**
	 * The trade will be adjusted by the Calculation Agent in accordance with the adjustments made by any exchange on which options on the underlying are listed.
	 */
	OPTIONS_EXCHANGE,
	    

	/**
	 * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments may not be made to account solely for changes in volatility, expected dividends, stock loan rate or liquidity.
	 */
	CALCULATION_AGENT,
	    

	/**
	 * The Calculation Agent will determine what adjustment is required to offset any change to the economics of the trade. If the Calculation Agent cannot achieve this, the trade goes to Cancellation and Payment with the Calculation Agent deciding on the value of the cancellation fee. Adjustments to account for changes in volatility, expected dividends, stock loan rate or liquidity are allowed.
	 */
	MODIFIED_CALCULATION_AGENT,
	    

	/**
	 * Applies to Basket Transactions. The portion of the Basket made up by the affected Share will be cancelled and a cancellation fee will be paid from one party to the other. The remainder of the trade continues.
	 */
	PARTIAL_CANCELLATION_AND_PAYMENT,
	    

	/**
	 * If this is a Share-for-Combined merger event (Shares are replaced with New Shares and Other Consideration), then different treatment can be applied to each component if the parties have specified this.
	 */
	COMPONENT    
	;

	private final String displayName;
	
	ShareExtraordinaryEventEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
