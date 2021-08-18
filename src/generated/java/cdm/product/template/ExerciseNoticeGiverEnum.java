package cdm.product.template;


/**
 * Defines the principal party to the trade that has the right to exercise.
 * @version ${project.version}
 */
public enum ExerciseNoticeGiverEnum {
    

	/**
	 * Specifies that only the option buyer has the right to exercise.
	 */
	BUYER,
	    

	/**
	 * Specifies that only the option seller has the right to exercise.
	 */
	SELLER,
	    

	/**
	 * Specifies that both the option buyer and option seller has the right to exercise.
	 */
	BOTH,
	    

	/**
	 * Specifies that the Master Agreement defines the principal party to the trade that has the right to exercise.
	 */
	AS_SPECIFIED_IN_MASTER_AGREEMENT    
	;

	private final String displayName;
	
	ExerciseNoticeGiverEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
