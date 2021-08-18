package cdm.observable.event;


/**
 * Defines the consequences of nationalization, insolvency and delisting events relating to the underlying.
 * @version ${project.version}
 */
public enum NationalizationOrInsolvencyOrDelistingEventEnum {
    

	/**
	 * The parties may, but are not obliged, to terminate the transaction on mutually acceptable terms and if the terms are not agreed then the transaction continues.
	 */
	NEGOTIATED_CLOSEOUT,
	    

	/**
	 * The trade is terminated.
	 */
	CANCELLATION_AND_PAYMENT    
	;

	private final String displayName;
	
	NationalizationOrInsolvencyOrDelistingEventEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
