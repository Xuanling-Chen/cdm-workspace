package cdm.legalagreement.csa;


/**
 * The enumerated values to specify condition(s) required by a party from the other party to hold its posted collateral. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h)(i): Eligibility to Hold Posted Collateral (VM); Custodians (VM).
 * @version ${project.version}
 */
public enum HoldingPostedCollateralEnum {
    

	/**
	 * The provisions specified in Paragraph 6 (c) of the SDA 2016 Credit Support Annex for Variation Margin apply as such.
	 */
	NO_ELECTION,
	    

	/**
	 * The custodian is acceptable to the other party to the agreement.
	 */
	ACCEPTABLE_CUSTODIAN    
	;

	private final String displayName;
	
	HoldingPostedCollateralEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
