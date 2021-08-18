package cdm.product.template;


/**
 * Specifies the duration type of the Security Lending transaction. e.g. Open or Term.
 * @version ${project.version}
 */
public enum DurationTypeEnum {
    

	/**
	 * Specifies a trade with a termination date.
	 */
	TERM,
	    

	/**
	 * Specifies a trade with no termination date.
	 */
	OPEN,
	    

	/**
	 * Specifies a trade where the term date is extended by a pre-determined period until a notice is serviced. Once the notice is served, the trade will not be reset again and goes to term.
	 */
	EVERGREEN    
	;

	private final String displayName;
	
	DurationTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
