package cdm.product.asset;


/**
 * The enumerated values to specify a long or short spread value.
 * @version ${project.version}
 */
public enum SpreadScheduleTypeEnum {
    

	/**
	 * Represents a Long Spread Schedule. Spread schedules defined as &#39;Long&#39; will be applied to Long Positions.
	 */
	LONG,
	    

	/**
	 * Represents a Short Spread Schedule. Spread schedules defined as &#39;Short&#39; will be applied to Short Positions.
	 */
	SHORT    
	;

	private final String displayName;
	
	SpreadScheduleTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
