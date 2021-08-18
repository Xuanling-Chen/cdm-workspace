package cdm.base.staticdata.asset.credit;


/**
 * The enumerated values used in both the obligations and deliverable obligations of the credit default swap to represent a class or type of securities which apply.
 * @version ${project.version}
 */
public enum ObligationCategoryEnum {
    

	/**
	 * ISDA term &#39;Payment&#39;.
	 */
	PAYMENT,
	    

	/**
	 * ISDA term &#39;Borrowed Money&#39;.
	 */
	BORROWED_MONEY,
	    

	/**
	 * ISDA term &#39;Reference Obligations Only&#39;.
	 */
	REFERENCE_OBLIGATIONS_ONLY,
	    

	/**
	 * ISDA term &#39;Bond&#39;.
	 */
	BOND,
	    

	/**
	 * ISDA term &#39;Loan&#39;.
	 */
	LOAN,
	    

	/**
	 * ISDA term &#39;Bond or Loan&#39;.
	 */
	BOND_OR_LOAN    
	;

	private final String displayName;
	
	ObligationCategoryEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
