package cdm.base.staticdata.asset.common;


/**
 * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
 * @version ${project.version}
 */
public enum DebtSeniorityEnum {
    

	/**
	 * Denotes debt which is secured over assets of the issuer or a related party (eg guarantor).
	 */
	SECURED,
	    

	/**
	 * Denotes debt  which ranks pari passu with all other unsecured creditors of the issuer.
	 */
	SENIOR,
	    

	/**
	 * Denotes debt  owed to an unsecured creditor that in the event of a liquidation can only be paid after the claims of secured and senior creditors have been met.
	 */
	SUBORDINATED    
	;

	private final String displayName;
	
	DebtSeniorityEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
