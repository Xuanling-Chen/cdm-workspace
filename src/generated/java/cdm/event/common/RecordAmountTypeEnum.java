package cdm.event.common;


/**
 * The enumeration of the account level for the billing summary.
 * @version ${project.version}
 */
public enum RecordAmountTypeEnum {
    

	/**
	 */
	ACCOUNT_TOTAL,
	    

	/**
	 */
	GRAND_TOTAL,
	    

	/**
	 */
	PARENT_TOTAL    
	;

	private final String displayName;
	
	RecordAmountTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
