package cdm.observable.asset;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the list of information providers.
 * @version ${project.version}
 */
public enum InformationProviderEnum {
    

	/**
	 * The Association of Banks in Singapore.
	 */
	ASSOC_BANKS_SINGAPORE,
	    

	/**
	 * The central bank of Canada.
	 */
	BANK_OF_CANADA,
	    

	/**
	 * The Bank Of England.
	 */
	BANK_OF_ENGLAND,
	    

	/**
	 * The central bank of Japan.
	 */
	BANK_OF_JAPAN,
	    

	/**
	 * Bloomberg LP.
	 */
	@RosettaSynonym(value = "0", source = "FIX_5_0_SP2")
	BLOOMBERG,
	    

	/**
	 * The European Central Bank.
	 */
	EURO_CENTRAL_BANK,
	    

	/**
	 * The Federal Home Loan Bank of San Francisco, or its successor.
	 */
	FHLBSF,
	    

	/**
	 * The Federal Reserve, the central bank of the United States.
	 */
	FEDERAL_RESERVE,
	    

	/**
	 * International Swaps and Derivatives Association, Inc.
	 */
	ISDA,
	    

	/**
	 */
	@RosettaSynonym(value = "99", source = "FIX_5_0_SP2")
	OTHER,
	    

	/**
	 * The Reserve Bank of Australia.
	 */
	RESERVE_BANK_AUSTRALIA,
	    

	/**
	 * The Reserve Bank of New Zealand.
	 */
	RESERVE_BANK_NEW_ZEALAND,
	    

	/**
	 * Reuters Group Plc.
	 */
	@RosettaSynonym(value = "1", source = "FIX_5_0_SP2")
	REUTERS,
	    

	/**
	 * South African Futures Exchange, or its successor.
	 */
	SAFEX,
	    

	/**
	 * Telerate, Inc.
	 */
	@RosettaSynonym(value = "2", source = "FIX_5_0_SP2")
	TELERATE    
	;

	private final String displayName;
	
	InformationProviderEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
