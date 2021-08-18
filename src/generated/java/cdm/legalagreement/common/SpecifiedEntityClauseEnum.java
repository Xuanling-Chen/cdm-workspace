package cdm.legalagreement.common;


/**
 * The enumerated values to specify the Event of Default or Termination event for which Specified Entities terms are being defined.
 * @version ${project.version}
 */
public enum SpecifiedEntityClauseEnum {
    

	/**
	 */
	DEFAULT_UNDER_SPECIFIED_TRANSACTION,
	    

	/**
	 */
	CROSS_DEFAULT,
	    

	/**
	 */
	BANKRUPTCY,
	    

	/**
	 */
	CREDIT_EVENT_UPON_MERGER    
	;

	private final String displayName;
	
	SpecifiedEntityClauseEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
