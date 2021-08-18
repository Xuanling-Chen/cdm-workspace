package cdm.base.datetime;


/**
 * The enumerated values to specify a time period containing the additional value of Term.
 * @version ${project.version}
 */
public enum PeriodExtendedEnum {
    

	/**
	 * Term. The period commencing on the effective date and ending on the termination date. The T period always appears in association with periodMultiplier = 1, and the notation is intended for use in contexts where the interval thus qualified (e.g. accrual period, payment period, reset period, ...) spans the entire term of the trade.
	 */
	T,
	    

	/**
	 * CalculationPeriod - the period corresponds to the calculation period   For example, used in the Commodity Markets to indicate that a reference contract is the one that corresponds to the period of the calculation period.
	 */
	C,
	    

	/**
	 * Day
	 */
	D,
	    

	/**
	 * Week
	 */
	W,
	    

	/**
	 * Month
	 */
	M,
	    

	/**
	 * Year
	 */
	Y    
	;

	private final String displayName;
	
	PeriodExtendedEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
