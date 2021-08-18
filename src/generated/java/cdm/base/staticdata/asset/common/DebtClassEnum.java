package cdm.base.staticdata.asset.common;


/**
 * Identifies the type of debt.
 * @version ${project.version}
 */
public enum DebtClassEnum {
    

	/**
	 * Identifies a debt instrument that has periodic income payments and value derived from or backed by a specified pool of underlying assets which could be mortgages or other obligations
	 */
	ASSET_BACKED,
	    

	/**
	 * Identifies a debt instrument that can be converted into common shares
	 */
	CONVERTIBLE,
	    

	/**
	 * Identifies a debt instrument as one issued by financial institutions to count towards regulatory capital, including term and perpetual subordinated debt, contingently convertible and others.  Excludes preferred share capital.
	 */
	REG_CAP,
	    

	/**
	 * Identifies a debt instrument athat has non-standard interest or principal features, with full recourse to the issuer.
	 */
	STRUCTURED,
	    

	/**
	 * Identifies a debt instrument that has a periodic coupon, a defined maturity, and is not backed by any specific asset. The seniority and the structure of the income and principal payments can optionally be defined in DebtType.DebtEconomics.
	 */
	VANILLA,
	    

	/**
	 * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of the Issuer
	 */
	HOLDER_CONVERTIBLE,
	    

	/**
	 * Identifies a debt instrument that can be converted primarily at the election of the holder into common shares of a party other than the Issuer
	 */
	HOLDER_EXCHANGEABLE,
	    

	/**
	 * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of the Issuer.  Also known as reverse convertible.
	 */
	ISSUER_CONVERTIBLE,
	    

	/**
	 * Identifies a debt instrument that can be converted at the election of the Issuer into common shares of a party other than the Issuer.  Also known as reverse exchangeable 
	 */
	ISSUER_EXCHANGEABLE    
	;

	private final String displayName;
	
	DebtClassEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
