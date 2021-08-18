package cdm.product.asset;


/**
 * The enumerated values to specify whether the dividend is paid with respect to the Dividend Period.
 * @version ${project.version}
 */
public enum DividendAmountTypeEnum {
    

	/**
	 * The record date for a dividend occurs during a dividend period.
	 */
	RECORD_AMOUNT,
	    

	/**
	 * The ex-date for a dividend occurs during a dividend period.
	 */
	EX_AMOUNT,
	    

	/**
	 * The payment date for a dividend occurs during a dividend period.
	 */
	PAID_AMOUNT,
	    

	/**
	 * The Amount is determined as provided in the relevant Master Confirmation.
	 */
	AS_SPECIFIED_IN_MASTER_CONFIRMATION    
	;

	private final String displayName;
	
	DividendAmountTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
