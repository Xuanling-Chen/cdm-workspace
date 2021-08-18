package cdm.event.workflow;


/**
 * The enumeration values to qualify the type of credit limits.
 * @version ${project.version}
 */
public enum CreditLimitTypeEnum {
    

	/**
	 * The type of credit line expressed in CS01. The sensitivity with respect to changes in the CDS spread.
	 */
	CS01,
	    

	/**
	 * The type of credit line expressed in DV01. The dollar value of a one basis point decrease in interest rates. It shows the change in a bond&#39;s price compared to a decrease in the bond&#39;s yield.
	 */
	DV01,
	    

	/**
	 * The type of credit line expressed in Initial Margin value.
	 */
	IM,
	    

	/**
	 * The type of credit line expressed in Notional amount.
	 */
	NOTIONAL,
	    

	/**
	 * The type of credit line expressed as a Net Present Value.
	 */
	NPV,
	    

	/**
	 * The type of credit line expressed in PV01. The value of a one dollar or one basis point annuity.
	 */
	PV01    
	;

	private final String displayName;
	
	CreditLimitTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
