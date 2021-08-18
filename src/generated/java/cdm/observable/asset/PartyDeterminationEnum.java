package cdm.observable.asset;


/**
 * The enumerated values to specify how a calculation agent will be determined.
 * @version ${project.version}
 */
public enum PartyDeterminationEnum {
    

	/**
	 * The party that gives notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (d).
	 */
	EXERCISING_PARTY,
	    

	/**
	 * The party that is given notice of exercise. Per 2000 ISDA Definitions, Section 11.1. Parties, paragraph (e).
	 */
	NON_EXERCISING_PARTY,
	    

	/**
	 * The Calculation Agent is determined by reference to the relevant master agreement.
	 */
	AS_SPECIFIED_IN_MASTER_AGREEMENT,
	    

	/**
	 * The Calculation Agent is determined by reference to the relevant standard terms supplement.
	 */
	AS_SPECIFIED_IN_STANDARD_TERMS_SUPPLEMENT,
	    

	/**
	 * Both parties with joined rights to be a calculation agent.
	 */
	BOTH    
	;

	private final String displayName;
	
	PartyDeterminationEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
