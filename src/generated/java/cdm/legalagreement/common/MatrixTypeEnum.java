package cdm.legalagreement.common;


/**
 * The enumerated values to specify the identification the form of applicable matrix.
 * @version ${project.version}
 */
public enum MatrixTypeEnum {
    

	/**
	 * The ISDA-published Credit Derivatives Physical Settlement Matrix.
	 */
	CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX,
	    

	/**
	 * The ISDA-published Equity Derivatives Matrix.
	 */
	EQUITY_DERIVATIVES_MATRIX,
	    

	/**
	 * The ISDA-published 2000 ISDA Definitions Settlement Matrix for Early Terminations and Swaptions.
	 */
	SETTLEMENT_MATRIX    
	;

	private final String displayName;
	
	MatrixTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
