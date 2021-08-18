package cdm.product.common.settlement;


/**
 * The enumeration values to specify how the option is to be settled when exercised.
 * @version ${project.version}
 */
public enum SettlementTypeEnum {
    

	/**
	 * The intrinsic value of the option will be delivered by way of a cash settlement amount determined, (i) by reference to the differential between the strike price and the settlement price; or (ii) in accordance with a bilateral agreement between the parties.
	 */
	CASH,
	    

	/**
	 * The securities underlying the transaction will be delivered by (i) in the case of a call, the seller to the buyer, or (ii) in the case of a put, the buyer to the seller versus a settlement amount equivalent to the strike price per share.
	 */
	PHYSICAL,
	    

	/**
	 * Allow Election of either Cash or Physical settlement.
	 */
	ELECTION,
	    

	/**
	 * Allow use of either Cash or Physical settlement without prior Election.
	 */
	CASH_OR_PHYSICAL    
	;

	private final String displayName;
	
	SettlementTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
