package cdm.legalagreement.common;


/**
 * The enumerated values to specify the Credit Support Document Terms
 * @version ${project.version}
 */
public enum CreditSupportDocumentTermsEnum {
    

	/**
	 * A specified Credit Support Document is provided
	 */
	SPECIFIED,
	    

	/**
	 * Any guarantee, collateral arrangement and/or other agreement or arrangement which provides for credit support with respect to the party’s obligations under this Agreement.
	 */
	ANY,
	    

	/**
	 * No Credit Support Document is specified.
	 */
	NONE    
	;

	private final String displayName;
	
	CreditSupportDocumentTermsEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
