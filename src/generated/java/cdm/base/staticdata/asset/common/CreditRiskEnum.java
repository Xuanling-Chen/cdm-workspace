package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum CreditRiskEnum {
    

	/**
	 * Tranched credit risk, including securitizations.
	 */
	TRANCHED_CREDIT_RISK,
	    

	/**
	 * Untranched credit risk, including repackagings.
	 */
	UNTRANCHED_CREDIT_RISK    
	;

	private final String displayName;
	
	CreditRiskEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
