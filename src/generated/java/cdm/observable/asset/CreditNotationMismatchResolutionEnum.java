package cdm.observable.asset;


/**
 * If several agency issue ratings but not equivalent, reference will be made to label characteritics of the rating such as the lowest/highest available.
 * @version ${project.version}
 */
public enum CreditNotationMismatchResolutionEnum {
    

	/**
	 * Denotes the lowest credit notation if several notations are listed.
	 */
	LOWEST,
	    

	/**
	 * Denotes the highest credit notation if several notations are listed.
	 */
	HIGHEST,
	    

	/**
	 * Denotes that a credit notation issued from a defined reference agency is used if several notations are listed.
	 */
	REFERENCE_AGENCY,
	    

	/**
	 * Denotes the average credit notation if several notations are listed 
	 */
	AVERAGE,
	    

	/**
	 * Denotes the second best credit notaiton if several notatons are listed
	 */
	SECOND_BEST    
	;

	private final String displayName;
	
	CreditNotationMismatchResolutionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
