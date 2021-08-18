package cdm.observable.asset;


/**
 * The enumerated values to specify the actual quotation style (e.g. PointsUpFront, TradedSpread) used to quote a credit default swap fee leg.
 * @version ${project.version}
 */
public enum QuotationStyleEnum {
    

	/**
	 * When quotation style is &#39;PointsUpFront&#39;, the initialPoints element of the Credit Default Swap feeLeg should be populated
	 */
	POINTS_UP_FRONT,
	    

	/**
	 * When quotation style is &#39;TradedSpread&#39;, the marketFixedRate element of the Credit Default Swap feeLeg should be populated
	 */
	TRADED_SPREAD,
	    

	/**
	 * When quotation style is &#39;Price&#39;, the marketPrice element of the Credit Default Swap feeLeg should be populated
	 */
	PRICE    
	;

	private final String displayName;
	
	QuotationStyleEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
