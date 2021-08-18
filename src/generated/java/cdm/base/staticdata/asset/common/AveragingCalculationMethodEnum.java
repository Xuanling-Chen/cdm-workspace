package cdm.base.staticdata.asset.common;


/**
 * Specifies enumerations for the type of averaging calculation.
 * @version ${project.version}
 */
public enum AveragingCalculationMethodEnum {
    

	/**
	 * Refers to the calculation of an average by taking the sum of observations divided by the count of observations.
	 */
	ARITHMETIC,
	    

	/**
	 * Refers to the calculation of an average by taking the nth root of the product of n observations.
	 */
	GEOMETRIC,
	    

	/**
	 * Refers to the calculation of an average by taking the reciprocal of the arithmetic mean of the reciprocals of the observations.
	 */
	HARMONIC    
	;

	private final String displayName;
	
	AveragingCalculationMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
