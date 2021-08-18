package cdm.legalagreement.common;


/**
 * The enumerated values to specify the specified entity terms for the Event of Default or Termination Event specified.
 * @version ${project.version}
 */
public enum SpecifiedEntityTermsEnum {
    

	/**
	 * No Specified Entity is provided
	 */
	NONE,
	    

	/**
	 * Any Affiliate is a Specified Entity.
	 */
	ANY_AFFILIATE,
	    

	/**
	 * The Specified Entity is provided.
	 */
	NAMED_SPECIFIED_ENTITY,
	    

	/**
	 * Any Material Subsidiary.
	 */
	MATERIAL_SUBSIDIARY,
	    

	/**
	 * Non standard Specified Entity terms are provided.
	 */
	OTHER_SPECIFIED_ENTITY    
	;

	private final String displayName;
	
	SpecifiedEntityTermsEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
