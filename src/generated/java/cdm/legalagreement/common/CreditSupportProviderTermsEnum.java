package cdm.legalagreement.common;


/**
 * The enumerated values to specify the Credit Support Provider Terms
 * @version ${project.version}
 */
public enum CreditSupportProviderTermsEnum {
    

	/**
	 * A specified Credit Support Provider is provided
	 */
	SPECIFIED,
	    

	/**
	 * Any party or parties who now or in the future may provide a Credit Support Document or other form of credit support.
	 */
	ANY,
	    

	/**
	 * No Credit Support Provider is specified.
	 */
	NONE    
	;

	private final String displayName;
	
	CreditSupportProviderTermsEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
