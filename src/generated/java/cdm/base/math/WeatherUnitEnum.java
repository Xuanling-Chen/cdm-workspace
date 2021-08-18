package cdm.base.math;


/**
 * Provides enumerated values for weather units, generally used in the context of defining quantities for commodities.
 * @version ${project.version}
 */
public enum WeatherUnitEnum {
    

	/**
	 * Denotes Cooling Degree Days as a standard unit.
	 */
	CDD,
	    

	/**
	 * Denotes Critical Precipitation Day as a standard unit.
	 */
	CPD,
	    

	/**
	 * Heating Degree Day as a standard unit.
	 */
	HDD    
	;

	private final String displayName;
	
	WeatherUnitEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
