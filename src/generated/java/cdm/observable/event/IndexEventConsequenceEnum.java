package cdm.observable.event;


/**
 * The enumerated values to specify the consequences of Index Events.
 * @version ${project.version}
 */
public enum IndexEventConsequenceEnum {
    

	/**
	 * Calculation Agent Adjustment.
	 */
	CALCULATION_AGENT_ADJUSTMENT,
	    

	/**
	 * Negotiated Close Out.
	 */
	NEGOTIATED_CLOSE_OUT,
	    

	/**
	 * Cancellation and Payment.
	 */
	CANCELLATION_AND_PAYMENT,
	    

	/**
	 * Related Exchange.
	 */
	RELATED_EXCHANGE    
	;

	private final String displayName;
	
	IndexEventConsequenceEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
