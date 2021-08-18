package cdm.product.template;


/**
 * This indicator defines which type of assets (cash or securities) is specified to apply as margin to the repo transaction.
 * @version ${project.version}
 */
public enum MarginTypeEnum {
    

	/**
	 * When the margin type is Cash, the margin factor is applied to the cash value of the transaction.
	 */
	CASH,
	    

	/**
	 * When the margin type is Instrument, the margin factor is applied to the instrument value for the transaction. In the &#39;instrument&#39; case, the haircut would be applied to the securities.
	 */
	INSTRUMENT    
	;

	private final String displayName;
	
	MarginTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
