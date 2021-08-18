package cdm.observable.asset;


/**
 * The enumerated values to specify the credit watch rating.
 * @version ${project.version}
 */
public enum CreditRatingCreditWatchEnum {
    

	/**
	 * A rating may be raised.
	 */
	POSITIVE,
	    

	/**
	 * A rating may be lowered.
	 */
	NEGATIVE,
	    

	/**
	 * A rating may be raised, lowered, or affirmed.
	 */
	DEVELOPING    
	;

	private final String displayName;
	
	CreditRatingCreditWatchEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
