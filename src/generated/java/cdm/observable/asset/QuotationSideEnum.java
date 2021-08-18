package cdm.observable.asset;


/**
 * The enumerated values to specify the side from which perspective a value is quoted.
 * @version ${project.version}
 */
public enum QuotationSideEnum {
    

	/**
	 * Denotes a value &#39;bid&#39; by a buyer for an asset, i.e. the value a buyer is willing to pay.
	 */
	BID,
	    

	/**
	 * Denotes a value &#39;asked&#39; by a seller for an asset, i.e. the value at which a seller is willing to sell.
	 */
	ASK,
	    

	/**
	 * Denotes a value midway between the bid and the ask value.
	 */
	MID,
	    

	/**
	 * Denotes a value from the settlement price, for example for a listed derivative at the end of the day.
	 */
	SETTLEMENT    
	;

	private final String displayName;
	
	QuotationSideEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
