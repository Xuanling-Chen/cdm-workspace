package cdm.base.staticdata.party;


/**
 * The enumerated values to specify the reference entity types corresponding to a list of types defined in the ISDA First to Default documentation.
 * @version ${project.version}
 */
public enum EntityTypeEnum {
    

	/**
	 * Entity Type of Asian.
	 */
	ASIAN,
	    

	/**
	 * Entity Type of Australian and New Zealand.
	 */
	AUSTRALIAN_AND_NEW_ZEALAND,
	    

	/**
	 * Entity Type of European Emerging Markets.
	 */
	EUROPEAN_EMERGING_MARKETS,
	    

	/**
	 * Entity Type of Japanese.
	 */
	JAPANESE,
	    

	/**
	 * Entity Type of North American High Yield.
	 */
	NORTH_AMERICAN_HIGH_YIELD,
	    

	/**
	 * Entity Type of North American Insurance.
	 */
	NORTH_AMERICAN_INSURANCE,
	    

	/**
	 * Entity Type of North American Investment Grade.
	 */
	NORTH_AMERICAN_INVESTMENT_GRADE,
	    

	/**
	 * Entity Type of Singaporean.
	 */
	SINGAPOREAN,
	    

	/**
	 * Entity Type of Western European.
	 */
	WESTERN_EUROPEAN,
	    

	/**
	 * Entity Type of Western European Insurance.
	 */
	WESTERN_EUROPEAN_INSURANCE    
	;

	private final String displayName;
	
	EntityTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
