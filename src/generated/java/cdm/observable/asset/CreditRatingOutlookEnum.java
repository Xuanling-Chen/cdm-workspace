package cdm.observable.asset;


/**
 * The enumerated values to specify the credit rating outlook.
 * @version ${project.version}
 */
public enum CreditRatingOutlookEnum {
    

	/**
	 * A rating may be raised.
	 */
	POSITIVE,
	    

	/**
	 * A rating may be lowered.
	 */
	NEGATIVE,
	    

	/**
	 * A rating is not likely to change.
	 */
	STABLE,
	    

	/**
	 * A rating may be raised, lowered, or affirmed.
	 */
	DEVELOPING    
	;

	private final String displayName;
	
	CreditRatingOutlookEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
