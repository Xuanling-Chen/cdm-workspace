package cdm.legalagreement.master;


/**
 * The enumerated values to specify the type of annex to be used with master confirmation agreement governing the transaction.
 * @version ${project.version}
 */
public enum MasterConfirmationAnnexTypeEnum {
    

	/**
	 * The Index Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2004_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER,
	    

	/**
	 * The Share Variance Swap 2004 Annex to the ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement and to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2004_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER,
	    

	/**
	 * The Dispersion Variance Swap Annex to the Revised 2007 ISDA European Variance Swap Master Confirmation Agreement applies.
	 */
	ISDA_2007_DISPERSION_VARIANCE_SWAP_EUROPEAN,
	    

	/**
	 * The EFS (Equity Share Finance Swap) 2007 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2007_EQUITY_FINANCE_SWAP_EUROPEAN,
	    

	/**
	 * The Index Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2007_INDEX_VARIANCE_SWAP_AMERICAS_INTERDEALER,
	    

	/**
	 * The Share Variance Swap 2007 Annex to the Revised ISDA 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2007_SHARE_VARIANCE_SWAP_AMERICAS_INTERDEALER,
	    

	/**
	 * The Variance Option Standard Terms Appendix to the Revised ISDA 2007 European Variance Swap Master Confirmation Agreement applies.
	 */
	ISDA_2007_VARIANCE_OPTION_EUROPEAN,
	    

	/**
	 * The Cash-settled Open Market EFS (Equity Finance Share Swap) 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN,
	    

	/**
	 * The Cash-settled Open Market EFS (Equity Finance Share Swap) Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2008_EQUITY_FINANCE_SWAP_ASIA_EXCLUDING_JAPAN_REV_1,
	    

	/**
	 * The Open Market Equity Option 2008 Annex to the ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN,
	    

	/**
	 * The Open Market Equity Option Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2008_EQUITY_OPTION_ASIA_EXCLUDING_JAPAN_REV_1,
	    

	/**
	 * The Equity Option 2008 Annex to the ISDA 2008 Japanese Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2008_EQUITY_OPTION_JAPAN,
	    

	/**
	 * The Cash-settled Closed Market Index and Share Options 2009 Annex to the Revised ISDA 2008 AEJ (Asia Excluding Japan) Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2009_CLOSED_MARKETS_OPTIONS_ASIA_EXCLUDING_JAPAN,
	    

	/**
	 * The Index Swap 2009 Annex to the ISDA 2007 European Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2009_EQUITY_EUROPEAN_IS,
	    

	/**
	 * The Interdealer Share Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2009_EQUITY_EUROPEAN_INTERDEALER_SS,
	    

	/**
	 * The Index and Share Options 2009 Annex to the ISDA 2009 Americas Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2009_INDEX_SHARE_OPTION_AMERICAS,
	    

	/**
	 * The Interdealer Index Swap 2009 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2009_INDEX_SWAP_EUROPEAN_INTERDEALER,
	    

	/**
	 * The Index Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2009_INDEX_SWAP_PAN_ASIA_INTERDEALER,
	    

	/**
	 * The Share Swap 2009 Annex to the ISDA 2009 Pan-Asia Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2009_SHARE_SWAP_PAN_ASIA,
	    

	/**
	 * The Fair Value Interdealer Share Swap 2010 Annex to the ISDA 2009 European Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2010_FAIR_VALUE_SHARE_SWAP_EUROPEAN_INTERDEALER,
	    

	/**
	 * The Cash-settled Index Option/Cash/Physically-settled Share Option 2010 Annex to the ISDA 2010 EMEA EM Interdealer Master Equity Derivatives Confirmation Agreement applies.
	 */
	ISDA_2010_INDEX_SHARE_OPTION_EMEA_INTERDEALER    
	;

	private final String displayName;
	
	MasterConfirmationAnnexTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
