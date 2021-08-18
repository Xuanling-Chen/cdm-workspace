package cdm.base.staticdata.party;


/**
 * The enumeration values to qualify the type of account.
 * @version ${project.version}
 */
public enum AccountTypeEnum {
    

	/**
	 * Aggregate client account, as defined under ESMA MiFIR.
	 */
	AGGREGATE_CLIENT,
	    

	/**
	 * The account contains trading activity or positions that belong to a client of the firm that opened the account.
	 */
	CLIENT,
	    

	/**
	 * The account contains proprietary trading activity or positions, belonging to the firm that is the owner of the account.
	 */
	HOUSE    
	;

	private final String displayName;
	
	AccountTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
