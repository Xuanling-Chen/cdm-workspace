package cdm.base.staticdata.party;


/**
 * Defines the enumerated values to specify the ancillary roles to the transaction. The product is agnostic to the actual parties involved in the transaction, with the party references abstracted away from the product definition and replaced by the AncillaryRoleEnum. The AncillaryRoleEnum can then be positioned in the product and the AncillaryParty type, which is positioned outside of the product definition, allows the AncillaryRoleEnum to be associated with an actual party reference.
 * @version ${project.version}
 */
public enum AncillaryRoleEnum {
    

	/**
	 * Specifies the party which determines additional disruption events.
	 */
	DISRUPTION_EVENTS_DETERMINING_PARTY,
	    

	/**
	 * Specifies the party which determines if dividends are extraordinary in relation to normal levels.
	 */
	EXTRAORDINARY_DIVIDENDS_PARTY,
	    

	/**
	 * Specifies the clearing organization (CCP, DCO) which the trade should be cleared.
	 */
	PREDETERMINED_CLEARING_ORGANIZATION_PARTY,
	    

	/**
	 * Specifies the party to which notice of a manual exercise should be given.
	 */
	EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL,
	    

	/**
	 * Specifies the party to which notice of a optional early termination exercise should be given.
	 */
	EXERCISE_NOTICE_RECEIVER_PARTY_OPTIONAL_EARLY_TERMINATION,
	    

	/**
	 * Specifies the party to which notice of a cancelable provision exercise should be given.
	 */
	EXERCISE_NOTICE_RECEIVER_PARTY_CANCELABLE_PROVISION,
	    

	/**
	 * Specifies the party to which notice of a extendible provision exercise should be given.
	 */
	EXERCISE_NOTICE_RECEIVER_PARTY_EXTENDIBLE_PROVISION,
	    

	/**
	 * Specifies the party responsible for performing calculation agent duties as defined in the applicable product definition.
	 */
	CALCULATION_AGENT_INDEPENDENT,
	    

	/**
	 * Specifies the party responsible for performing calculation agent duties associated with an optional early termination.
	 */
	CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION,
	    

	/**
	 * Specifies the party responsible for performing calculation agent duties associated with an mandatory early termination.
	 */
	CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION,
	    

	/**
	 * Specifies the party responsible for deciding the fallback rate.
	 */
	CALCULATION_AGENT_FALLBACK,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	ARRANGING_BROKER,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	BENEFICIARY,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	CLEARING_FIRM,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	COUNTERPARTY_AFFLILATE,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	GUARANTOR,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	OTHER_PARTY,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	PRIME_BROKER,
	    

	/**
	 * Specifies the role of the party which either pays or receives a cashflow payment.
	 */
	SETTLEMENT_AGENT    
	;

	private final String displayName;
	
	AncillaryRoleEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
