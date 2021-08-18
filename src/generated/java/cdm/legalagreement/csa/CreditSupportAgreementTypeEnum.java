package cdm.legalagreement.csa;


/**
 * The enumerated values to specify the type of ISDA Credit Support Agreement governing the transaction.
 * @version ${project.version}
 */
public enum CreditSupportAgreementTypeEnum {
    

	/**
	 * The ISDA 1994 Credit Support Annex New York Law (pledge) applies.
	 */
	ISDA_1994_CREDIT_SUPPORT_ANNEX_NEW_YORK_LAW,
	    

	/**
	 * The ISDA 1995 Credit Support Annex English Law (title transfer) applies.
	 */
	ISDA_1995_CREDIT_SUPPORT_ANNEX_ENGLISH_LAW,
	    

	/**
	 * The ISDA 1995 Credit Support Annex Japanese Law applies.
	 */
	ISDA_1995_CREDIT_SUPPORT_ANNEX_JAPANESE_LAW,
	    

	/**
	 * The ISDA 1995 Credit Support Deed English Law (charge) applies.
	 */
	ISDA_1995_CREDIT_SUPPORT_DEED_ENGLISH_LAW,
	    

	/**
	 * The ISDA 2001 Margin Provisions applies.
	 */
	ISDA_2001_MARGIN_PROVISIONS,
	    

	/**
	 * The ISDA 2013 Standard Credit Support Agreement.
	 */
	ISDA_2013_STANDARD_CREDIT_SUPPORT_AGREEMENT,
	    

	/**
	 * The ISDA 2014 Standard Credit Support Agreement.
	 */
	ISDA_2014_STANDARD_CREDIT_SUPPORT_AGREEMENT    
	;

	private final String displayName;
	
	CreditSupportAgreementTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
