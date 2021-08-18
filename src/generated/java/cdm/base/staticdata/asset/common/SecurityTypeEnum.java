package cdm.base.staticdata.asset.common;


/**
 * Identifies the type of security.
 * @version ${project.version}
 */
public enum SecurityTypeEnum {
    

	/**
	 * Identifies a security as a fixed income instrument of debt issued and securitized as a tradable asset.
	 */
	DEBT,
	    

	/**
	 * Identifies a security as an Equity value of holding of shares in listed company
	 */
	EQUITY,
	    

	/**
	 * Identifies a security as an Instrument representing holding in an investment fund.
	 */
	FUND,
	    

	/**
	 * Identifies a security as a Warrant that give the right, but not the obligation, to buy or sell a security — most commonly an equity — at a certain price before expiration, or to receive the cash equivalent.
	 */
	WARRANT,
	    

	/**
	 * Identifies a security as one that that offers a derivative-based economic return which is not structured as a bond, an equity or a warrant. Note that this security type is not a Certificate of Deposit (aka CD).
	 */
	CERTIFICATE,
	    

	/**
	 * Identifies a security as a letter of credit or documentary credit/ bankers commercial credit.  A payment mechanism used in international trade to provide economic guarantee of payment by a creditworthy issuer for payment of exported goods.
	 */
	LETTER_OF_CREDIT    
	;

	private final String displayName;
	
	SecurityTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
