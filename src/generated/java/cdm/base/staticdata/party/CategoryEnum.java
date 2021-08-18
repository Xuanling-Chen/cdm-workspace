package cdm.base.staticdata.party;


/**
 * The enumerated values to specify the type of organisation involved in the transaction.
 * @version ${project.version}
 */
public enum CategoryEnum {
    

	/**
	 * The trade or trade report represents the information from the perspective of the sender of the report, typically a clearing member firm or dealer (acting as an agent).
	 */
	AGENT,
	    

	/**
	 * The trade or trade report represents the information from the perspective of the counterparty of the sender of the report, which is typically a clearing member firm or dealer.
	 */
	COUNTERPARTY,
	    

	/**
	 * The trade or trade report represents the information from the perspective of a client opposite the sender of the report, which is typically a clearing member firm or dealer.
	 */
	CUSTOMER,
	    

	/**
	 * The trade or trade report represents the information from the perspective of the sender of the report, typically a clearing member firm or dealer (acting as a principal).
	 */
	PRINCIPAL    
	;

	private final String displayName;
	
	CategoryEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
