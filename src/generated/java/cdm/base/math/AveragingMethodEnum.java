package cdm.base.math;


/**
 * The enumerated values to specify the method of calculation to be used when averaging rates. Per ISDA 2000 Definitions, Section 6.2. Certain Definitions Relating to Floating Amounts.
 * @version ${project.version}
 */
public enum AveragingMethodEnum {
    

	/**
	 * The arithmetic mean of the relevant rates for each reset date.
	 */
	UNWEIGHTED,
	    

	/**
	 * The arithmetic mean of the relevant rates in effect for each day in a calculation period calculated by multiplying each relevant rate by the number of days such relevant rate is in effect, determining the sum of such products and dividing such sum by the number of days in the calculation period.
	 */
	WEIGHTED    
	;

	private final String displayName;
	
	AveragingMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
