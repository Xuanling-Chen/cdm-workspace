package cdm.base.staticdata.party;


/**
 * Defines the enumerated values to specify the two counterparties to the transaction.
 * @version ${project.version}
 */
public enum CounterpartyRoleEnum {
    

	/**
	 */
	PARTY_1,
	    

	/**
	 */
	PARTY_2    
	;

	private final String displayName;
	
	CounterpartyRoleEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
