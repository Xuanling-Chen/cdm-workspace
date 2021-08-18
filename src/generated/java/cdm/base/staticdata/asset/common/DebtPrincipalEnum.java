package cdm.base.staticdata.asset.common;


/**
 * Specifies the general rule for repayment of principal.
 * @version ${project.version}
 */
public enum DebtPrincipalEnum {
    

	/**
	 * Denotes that the principal is paid all at once on maturity of the debt insrument. Bullet debt instruments cannot be redeemed early by an issuer, which means they are non-callable.
	 */
	BULLET,
	    

	/**
	 * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the issuer.
	 */
	CALLABLE,
	    

	/**
	 * Denotes that the principal on the debt can be repaid early, in whole or in part, at the option of the holder.
	 */
	PUTTABLE,
	    

	/**
	 * Denotes that the principal on the debt is paid down regularly, along with its interest expense over the life of the debt instrument.  Includes amortising instruments with a bullet balance repayment at maturity.
	 */
	AMORTISING,
	    

	/**
	 * SDenotes that the principal on the debt is calculated with reference to one or more specified inflation rates.
	 */
	INFLATION_LINKED,
	    

	/**
	 * Denotes that the  principal on the debt is calculated with reference to one or more price or other indices (other than inflation rates).
	 */
	INDEX_LINKED,
	    

	/**
	 * Denotes that the  principal on the debt is calculated with reference to other underlyings (not being floating interest rates, inflation rates or indices) or with a non-linear relationship to floating interest rates, inflation rates or indices.
	 */
	OTHER_STRUCTURED,
	    

	/**
	 * Denotes a stripped bond representing only the principal component.
	 */
	PRINCIPAL_ONLY    
	;

	private final String displayName;
	
	DebtPrincipalEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
