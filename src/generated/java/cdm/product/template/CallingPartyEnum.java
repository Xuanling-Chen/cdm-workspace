package cdm.product.template;


/**
 * Identifies a party to the on-demand repo transaction that has a right to demand for termination of the Security Finance transaction.
 * @version ${project.version}
 */
public enum CallingPartyEnum {
    

	/**
	 * Initial buyer to the repo transaction.
	 */
	INITIAL_BUYER,
	    

	/**
	 * Initial seller to the repo transaction.
	 */
	INITIAL_SELLER,
	    

	/**
	 * Either, Buyer or Seller to the repo transaction.
	 */
	EITHER,
	    

	/**
	 * As defined in Master Agreement.
	 */
	AS_DEFINED_IN_MASTER_AGREEMENT    
	;

	private final String displayName;
	
	CallingPartyEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
