package cdm.product.asset;


/**
 * The enumerated values to specify the relevant settled entity matrix source.
 * @version ${project.version}
 */
public enum SettledEntityMatrixSourceEnum {
    

	/**
	 * The Relevant Settled Entity Matrix shall be the list agreed for this purpose by the parties. The list is not included as part of the electronic confirmation.
	 */
	CONFIRMATION_ANNEX,
	    

	/**
	 * The term is not applicable.
	 */
	NOT_APPLICABLE,
	    

	/**
	 * The Settled Entity Matrix published by the Index Publisher.
	 */
	PUBLISHER    
	;

	private final String displayName;
	
	SettledEntityMatrixSourceEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
