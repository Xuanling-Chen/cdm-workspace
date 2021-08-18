package cdm.legalagreement.common;


/**
 * The enumerated values to define the supplements to a base set of ISDA Definitions that are applicable to the transaction.
 * @version ${project.version}
 */
public enum ContractualSupplementEnum {
    

	/**
	 * Standard Terms Supplement for ABX Transactions.
	 */
	ABX,
	    

	/**
	 * Standard Terms Supplement for Asset-Backed Tranche Transactions.
	 */
	ABX_TRANCHE,
	    

	/**
	 * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Leveraged Loans.
	 */
	CD_SON_LEVERAGED_LOANS,
	    

	/**
	 * ISDA Standard Terms Supplement for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement.
	 */
	CD_SON_MBS,
	    

	/**
	 * Standard Terms Supplement for CDX Untranched Transactions.
	 */
	CDX,
	    

	/**
	 * Standard Terms Supplement for CDX Emerging Markets Untranched Transactions.
	 */
	CDX_EMERGING_MARKETS,
	    

	/**
	 * Standard Terms Supplement for CDX Emerging Markets Diversified Untranched Transactions..
	 */
	CDX_EMERGING_MARKETS_DIVERSIFIED,
	    

	/**
	 * Standard Terms Supplement for CDX Swaption Transactions.
	 */
	CDX_SWAPTION,
	    

	/**
	 * Standard Terms Supplement for Dow Jones CDX Tranche Transactions.
	 */
	CDX_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for CMBX Transactions.
	 */
	CMBX,
	    

	/**
	 * Standard Terms Supplement for Single Name European CMBS Transactions.
	 */
	EUROPEAN_CMBS,
	    

	/**
	 * Standard Terms Supplement for Single Name European RMBS Transactions.
	 */
	EUROPEAN_RMBS,
	    

	/**
	 * Standard Terms Supplement for IOS Transactions.
	 */
	IOS,
	    

	/**
	 * Supplement to the 1999 ISDA Credit Derivatives Definitions Relating to Convertible, Exchangeable or Accreting Obligations dated November 9, 2001.
	 */
	ISDA_1999_CREDIT_CONVERTIBLE_EXCHANGEABLE_ACCRETING_OBLIGATIONS,
	    

	/**
	 * Restructuring Supplement to the 1999 ISDA Credit Derivatives Definitions dated May 11, 2001.
	 */
	ISDA_1999_CREDIT_RESTRUCTURING,
	    

	/**
	 * Supplement Relating to Successor and Credit Events to the 1999 ISDA Credit Derivatives Definitions dated November 28, 2001.
	 */
	ISDA_1999_CREDIT_SUCCESSOR_AND_CREDIT_EVENTS,
	    

	/**
	 * Additional Provisions for LPN dated December 6, 2007.
	 */
	ISDA_2003_ADDITIONAL_PROVISIONS_LPN,
	    

	/**
	 * Additional Provisions for Contingent Credit Spread Transactions dated August 15, 2008.
	 */
	ISDA_2003_CONTINGENT_CREDIT_SPREAD_TRANSACTION,
	    

	/**
	 * 2005 Matrix Supplement to the 2003 ISDA Credit Derivatives.
	 */
	ISDA_2003_CREDIT_2005_MATRIX_SUPPLEMENT,
	    

	/**
	 * Additional Provisions for the Argentine Republic: Excluded Obligations and Excluded Deliverable Obligations dated December 21, 2005.
	 */
	ISDA_2003_CREDIT_ARGENTINE_REPUBLIC,
	    

	/**
	 * ISDA Credit Derivatives Determinations Committees and Auction Settlement Supplement to the 2003 ISDA Credit Derivatives Definitions (published on [TBD]).
	 */
	ISDA_2003_CREDIT_AUCTION_SUPPLEMENT,
	    

	/**
	 * May 2003 Supplement to the 2003 ISDA Credit Derivatives Definitions.
	 */
	ISDA_2003_CREDIT_MAY_2003,
	    

	/**
	 * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated May 9, 2003.
	 */
	ISDA_2003_CREDIT_MONOLINE_INSURERS,
	    

	/**
	 * Additional Provisions for Physically Settled Default Swaps Monoline Insurer as Reference Entity dated January 21, 2005.
	 */
	ISDA_2003_CREDIT_MONOLINE_INSURERS_2005,
	    

	/**
	 * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
	 */
	ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY,
	    

	/**
	 * Additional Provisions for the Republic of Hungary: Obligation Characteristics and Deliverable Obligation Characteristics dated February 14, 2005. 
	 */
	ISDA_2003_CREDIT_REPUBLIC_OF_HUNGARY_2005,
	    

	/**
	 * Additional Provisions for the Russian Federation: Obligation Characteristics and Deliverable Obligation Characteristics dated August 13, 2004.
	 */
	ISDA_2003_CREDIT_RUSSIAN_FEDERATION,
	    

	/**
	 * Additional Provisions for Credit Derivative Transactions - U.S. Municipal Entity as Reference Entity dated September 17, 2004.
	 */
	ISDA_2003_CREDIT_US_MUNICIPALS,
	    

	/**
	 * Additional Provisions for STMicroelectronics NV dated December 6, 2007.
	 */
	ISDA_2003_ST_MICROELECTRONICS_NV,
	    

	/**
	 * 2007 Full Lookthrough Depository Receipt Supplement to the 2002 Equity Derivatives Definitions.
	 */
	ISDA_2007_FULL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT,
	    

	/**
	 * 2007 Partial Lookthrough Depository Receipt Supplement to the 2002 ISDA Equity Derivatives Definitions.
	 */
	ISDA_2007_PARTIAL_LOOKTHROUGH_DEPOSITORY_RECEIPT_SUPPLEMENT,
	    

	/**
	 * Additional Provisions for Physically Settled Default Swaps Monoline Insurer.
	 */
	ISDA_CREDIT_MONOLINE_INSURERS,
	    

	/**
	 * Additional Provisions for Fixed Recovery Credit Default Swap Transactions
	 */
	ISDA_DELIVERY_RESTRICTIONS,
	    

	/**
	 * Additional Provisions for Fixed Recovery Credit Default Swap Transactions.
	 */
	ISDA_FIXED_RECOVERY,
	    

	/**
	 * Additional Provisions for LPN Reference Entities.
	 */
	ISDALPN_REFERENCE_ENTITIES,
	    

	/**
	 * Canadian Supplement to the 2004 Americas Interdealer Master Equity Derivatives Confirmation Agreement dated March 29, 2004.
	 */
	ISDA_MARCH_2004_EQUITY_CANADIAN_SUPPLEMENT,
	    

	/**
	 * Additional Provisions for Recovery Lock Credit Default Swap Transactions.
	 */
	ISDA_RECOVERY_LOCK,
	    

	/**
	 * Additional Provisions for Secured Deliverable Obligation Characteristic.
	 */
	ISDA_SECURED_DELIVERABLE_OBLIGATION_CHARACTERISTIC,
	    

	/**
	 * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Transactions.
	 */
	LCDX,
	    

	/**
	 * Standard Terms Supplement for Syndicated Secured Loan Credit Default Swap Index Tranche Transactions.
	 */
	LCDX_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for MBX Transactions.
	 */
	MBX,
	    

	/**
	 * Standard Terms Supplement for Municipal CDX Untranched Transactions.
	 */
	MCDX,
	    

	/**
	 * Standard Terms Supplement for PO Index Transactions.
	 */
	PO,
	    

	/**
	 * Standard Terms Supplement for PrimeX Transactions.
	 */
	PRIME_X,
	    

	/**
	 * Standard Terms Supplement for Standard CDX Tranche Transactions.
	 */
	STANDARD_CDX_TRANCHE,
	    

	/**
	 * Standard Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
	 */
	STANDARD_LCDS,
	    

	/**
	 * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions.
	 */
	STANDARD_LCDS_BULLET,
	    

	/**
	 * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions.
	 */
	STANDARD_LCDX_BULLET,
	    

	/**
	 * Standard Terms Supplement for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions.
	 */
	STANDARD_LCDX_BULLET_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for Standard iTraxx Europe Tranched Transactions.
	 */
	STANDARDI_TRAXX_EUROPE_TRANCHE,
	    

	/**
	 * Syndicated Secured Loan Credit Default Swap Standard Terms Supplement.
	 */
	SYNDICATED_SECURED_LOAN_CDS,
	    

	/**
	 * Standard Terms Supplement for TRX Transactions.
	 */
	TRX,
	    

	/**
	 * Standard Terms Supplement for TRX.II Transactions.
	 */
	TRX_II("TRX.II"),
	

	/**
	 * Standard Terms Supplement for iTraxx Asia Excluding Japan.
	 */
	I_TRAXX_ASIA_EX_JAPAN,
	    

	/**
	 * Standard Terms Supplement for iTraxx Asia Ex-Japan Swaption Transactions.
	 */
	I_TRAXX_ASIA_EX_JAPAN_SWAPTION,
	    

	/**
	 * Standard Terms Supplement for iTraxx Asia Excluding Japan Tranched Transactions.
	 */
	I_TRAXX_ASIA_EX_JAPAN_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for iTraxx Australia.
	 */
	I_TRAXX_AUSTRALIA,
	    

	/**
	 * Standard Terms Supplement for iTraxx Australia Swaption Transactions.
	 */
	I_TRAXX_AUSTRALIA_SWAPTION,
	    

	/**
	 * Standard Terms Supplement for iTraxx Australia Tranched Transactions.
	 */
	I_TRAXX_AUSTRALIA_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for iTraxx CJ.
	 */
	I_TRAXX_CJ,
	    

	/**
	 * Standard Terms Supplement for iTraxx CJ Tranched Transactions.
	 */
	I_TRAXX_CJ_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for iTraxx Europe Transactions.
	 */
	I_TRAXX_EUROPE,
	    

	/**
	 * Standard Terms Supplement for iTraxx Europe Dealer Form.
	 */
	I_TRAXX_EUROPE_DEALER,
	    

	/**
	 * Standard Terms Supplement for iTraxx Europe Non-Dealer Form.
	 */
	I_TRAXX_EUROPE_NON_DEALER,
	    

	/**
	 * Standard Terms Supplement for iTraxx Europe Swaption Transactions.
	 */
	I_TRAXX_EUROPE_SWAPTION,
	    

	/**
	 * Standard Terms Supplement for iTraxx Europe Tranched Transactions.
	 */
	I_TRAXX_EUROPE_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for iTraxx Japan.
	 */
	I_TRAXX_JAPAN,
	    

	/**
	 * Standard Terms Supplement for iTraxx Japan Swaption Transactions.
	 */
	I_TRAXX_JAPAN_SWAPTION,
	    

	/**
	 * Standard Terms Supplement for iTraxx Japan Tranched Transactions.
	 */
	I_TRAXX_JAPAN_TRANCHE,
	    

	/**
	 * Standard Terms Supplement for iTraxx LevX.
	 */
	I_TRAXX_LEV_X,
	    

	/**
	 * Standard Terms Supplement for iTraxx SDI 75 Dealer Transactions.
	 */
	I_TRAXX_SDI_75_DEALER,
	    

	/**
	 * Standard Terms Supplement for iTraxx SDI 75 Non-Dealer Transactions.
	 */
	I_TRAXX_SDI_75_NON_DEALER,
	    

	/**
	 * Standard Terms Supplement for iTraxx SovX.
	 */
	I_TRAXX_SOV_X    
	;

	private final String displayName;
	
	ContractualSupplementEnum() {
		this.displayName = null;
	}

	ContractualSupplementEnum(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
