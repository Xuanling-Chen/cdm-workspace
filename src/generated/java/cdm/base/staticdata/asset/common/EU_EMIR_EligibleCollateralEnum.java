package cdm.base.staticdata.asset.common;


/**
 * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules. Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities. Please note: EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
 * @version ${project.version}
 */
public enum EU_EMIR_EligibleCollateralEnum {
    

	/**
	 * Denotes Cash in the form of money credited to an account in any currency, or similar claims for the repayment of money, such as money market deposits.
	 */
	EU_EMIR_TYPE_A,
	    

	/**
	 *  Denotes gold in the form of allocated pure gold bullion of recognised good delivery.
	 */
	EU_EMIR_TYPE_B,
	    

	/**
	 *  Denotes debt securities issued by Member States&#39; central governments or central banks.
	 */
	EU_EMIR_TYPE_C,
	    

	/**
	 *  Denotes debt securities issued by Member States&#39; regional governments or local authorities whose exposures are treated as exposures to the central government of that Member State in accordance with Article 115(2) of Regulation (EU) No 575/2013.
	 */
	EU_EMIR_TYPE_D,
	    

	/**
	 *  Denotes debt securities issued by Member States&#39; public sector entities whose exposures are treated as exposures to the central government, regional government or local authority of that Member State in accordance with Article 116(4) of Regulation (EU) No 575/2013.
	 */
	EU_EMIR_TYPE_E,
	    

	/**
	 *  Denotes debt securities issued by Member States&#39; regional governments or local authorities other than those referred to in (TypeD.)
	 */
	EU_EMIR_TYPE_F,
	    

	/**
	 *  Denotes debt securities issued by Member States&#39; public sector entities other than those referred to in (TypeE).
	 */
	EU_EMIR_TYPE_G,
	    

	/**
	 *  Denotes debt securities issued by multilateral development banks listed in Article 117(2) of Regulation (EU) No 575/2013.
	 */
	EU_EMIR_TYPE_H,
	    

	/**
	 *  Denotes debt securities issued by the international organisations listed in Article 118 of Regulation (EU) No 575/2013.
	 */
	EU_EMIR_TYPE_I,
	    

	/**
	 *  Denotes debt securities issued by third countries&#39; governments or central banks.
	 */
	EU_EMIR_TYPE_J,
	    

	/**
	 *  Denotes debt securities issued by third countries&#39; regional governments or local authorities that meet the requirements of (TypeD) and (TypeE).
	 */
	EU_EMIR_TYPE_K,
	    

	/**
	 *  Denotes debt securities issued by third countries&#39; regional governments or local authorities other than those referred to in (TypeD) and (TypeE).
	 */
	EU_EMIR_TYPE_L,
	    

	/**
	 *  Denotes debt securities issued by credit institutions or investment firms including bonds referred to in Article 52(4) of Directive 2009/65/EC of the European Parliament and of the Council.
	 */
	EU_EMIR_TYPE_M,
	    

	/**
	 *  Denotes corporate bonds.
	 */
	EU_EMIR_TYPE_N,
	    

	/**
	 *  Denotes the most senior tranche of a securitisation, as defined in Article 4(61) of Regulation (EU) No 575/2013, that is not a re-securitisation as defined in Article 4(63) of that Regulation.
	 */
	EU_EMIR_TYPE_O,
	    

	/**
	 *  Denotes convertible bonds provided that they can be converted only into equities which are included in an index specified pursuant to point (a) of Article 197 (8) of Regulation (EU) No 575/2013.
	 */
	EU_EMIR_TYPE_P,
	    

	/**
	 *  Denotes equities included in an index specified pursuant to point (a) of Article 197(8) of Regulation (EU) No 575/2013.
	 */
	EU_EMIR_TYPE_Q,
	    

	/**
	 *  Denotes shares or units in undertakings for collective investments in transferable securities (UCITS), provided that the conditions set out in Article 5 of EU Regulation 2016/2251 are met.
	 */
	EU_EMIR_TYPE_R    
	;

	private final String displayName;
	
	EU_EMIR_EligibleCollateralEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
