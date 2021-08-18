package cdm.observable.asset;


/**
 * An indicator to estalish an agency rating to be identified as a simple scale boundary of minimum or maximum.
 * @version ${project.version}
 */
public enum CreditNotationBoundaryEnum {
    

	/**
	 * Minumum Boundary
	 */
	MINIMUM,
	    

	/**
	 * Maxiumum Boundary
	 */
	MAXIMUM    
	;

	private final String displayName;
	
	CreditNotationBoundaryEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
