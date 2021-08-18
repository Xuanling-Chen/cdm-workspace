package cdm.product.common.settlement;


/**
 * The enumerated values to specify whether a trade is settling using standard settlement instructions as well as whether it is a candidate for settlement netting.
 * @version ${project.version}
 */
public enum StandardSettlementStyleEnum {
    

	/**
	 * This trade will settle using standard predetermined funds settlement instructions.
	 */
	STANDARD,
	    

	/**
	 * This trade is a candidate for settlement netting.
	 */
	NET,
	    

	/**
	 * This trade will settle using standard predetermined funds settlement instructions and is a candidate for settlement netting.
	 */
	STANDARD_AND_NET    
	;

	private final String displayName;
	
	StandardSettlementStyleEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
