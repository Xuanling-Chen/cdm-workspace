package cdm.legalagreement.common;


/**
 * The enumerated values to specify a set of standard contract definitions relevant to the transaction.
 * @version ${project.version}
 */
public enum ContractualDefinitionsEnum {
    

	/**
	 * ISDA 1991 Definitions
	 */
	ISDA1991,
	    

	/**
	 * ISDA 1993 Commodity Derivatives Definitions
	 */
	ISDA_1993_COMMODITY,
	    

	/**
	 * ISDA 1996 Equity Derivatives Definitions
	 */
	ISDA_1996_EQUITY,
	    

	/**
	 * ISDA 1997 Bullion Definitions
	 */
	ISDA_1997_BULLION,
	    

	/**
	 * ISDA 1997 Government Bond Option Definitions
	 */
	ISDA_1997_GOVERNMENT_BOND,
	    

	/**
	 * ISDA 1998 FX and Currency Option Definitions
	 */
	ISDA1998FX,
	    

	/**
	 * ISDA 1999 Credit Derivatives Definitions
	 */
	ISDA_1999_CREDIT,
	    

	/**
	 * ISDA 2000 Definitions
	 */
	ISDA2000,
	    

	/**
	 * ISDA 2002 Equity Derivatives Definitions
	 */
	ISDA_2002_EQUITY,
	    

	/**
	 * ISDA 2003 Credit Derivatives Definitions
	 */
	ISDA_2003_CREDIT,
	    

	/**
	 * ISDA 2004 Novation Definitions
	 */
	ISDA_2004_NOVATION,
	    

	/**
	 * ISDA 2005 Commodity Derivatives Definitions
	 */
	ISDA_2005_COMMODITY,
	    

	/**
	 * ISDA 2006 Definitions
	 */
	ISDA2006,
	    

	/**
	 * ISDA 2006 Inflation Derivatives Definitions
	 */
	ISDA_2006_INFLATION,
	    

	/**
	 * ISDA 2008 Inflation Derivatives Definitions
	 */
	ISDA_2008_INFLATION,
	    

	/**
	 * ISDA 2011 Equity Derivatives Definitions
	 */
	ISDA_2011_EQUITY,
	    

	/**
	 * ISDA 2014 Credit Derivatives Definitions
	 */
	ISDA_2014_CREDIT    
	;

	private final String displayName;
	
	ContractualDefinitionsEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
