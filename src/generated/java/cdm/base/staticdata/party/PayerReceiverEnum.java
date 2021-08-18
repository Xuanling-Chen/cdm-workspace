package cdm.base.staticdata.party;


/**
 * The enumerated values to specify an interest rate stream payer or receiver party.
 * @version ${project.version}
 */
public enum PayerReceiverEnum {
    

	/**
	 * The party identified as the stream payer.
	 */
	PAYER,
	    

	/**
	 * The party identified as the stream receiver.
	 */
	RECEIVER    
	;

	private final String displayName;
	
	PayerReceiverEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
