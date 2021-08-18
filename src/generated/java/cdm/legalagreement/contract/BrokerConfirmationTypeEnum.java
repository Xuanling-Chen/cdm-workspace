package cdm.legalagreement.contract;


/**
 * The enumerated values to specify the type of Broker Confirm that the FpML trade represents.
 * @version ${project.version}
 */
public enum BrokerConfirmationTypeEnum {
    

	/**
	 * Broker Confirmation Type representing ABX index trades.
	 */
	ABX,
	    

	/**
	 * Broker Confirmation Type of Asia Corporate.
	 */
	ASIA_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of Asia Sovereign.
	 */
	ASIA_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type of Australia Corporate.
	 */
	AUSTRALIA_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of Australia Sovereign.
	 */
	AUSTRALIA_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for use with Credit Derivative Transactions on Leveraged Loans.
	 */
	CD_SON_LEVERAGED_LOANS,
	    

	/**
	 * Broker Confirmation Type for use with Credit Derivative Transactions on Mortgage-backed Security with Pay-As-You-Go or Physical Settlement.
	 */
	CD_SON_MBS,
	    

	/**
	 * Broker Confirmation Type for CDX Emerging Markets Untranched Transactions.
	 */
	CDX_EMERGING_MARKETS,
	    

	/**
	 * Broker Confirmation Type for CDX Emerging Markets Diversified Untranched Transactions.
	 */
	CDX_EMERGING_MARKETS_DIVERSIFIED,
	    

	/**
	 * Broker Confirmation Type for CDX Swaption Transactions.
	 */
	CDX_SWAPTION,
	    

	/**
	 * Broker Confirmation Type for Dow Jones CDX Tranche Transactions.
	 */
	CDX_TRANCHE,
	    

	/**
	 * Broker Confirmation Type representing CMBX index trades.
	 */
	CMBX,
	    

	/**
	 * Broker Confirmation Type for CDS Index trades relating to Dow Jones CDX.EM index series.
	 */
	DJ_CDX_EM_("DJ.CDX.EM "),
	

	/**
	 * Broker Confirmation Type for CDS Index trades relating to Dow Jones CDX.NA.IG and Dow Jones CDX.NA.HY index series.
	 */
	DJ_CDX_NA("DJ.CDX.NA"),
	

	/**
	 * Broker Confirmation Type of Emerging European and Middle Eastern Sovereign.
	 */
	EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for EMERGING EUROPEAN CORPORATE.
	 */
	EMERGING_EUROPEAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type for EMERGING EUROPEAN CORPORATE LPN.
	 */
	EMERGING_EUROPEAN_CORPORATE_LPN,
	    

	/**
	 * Broker Confirmation Type for Single Name European CMBS Transactions.
	 */
	EUROPEAN_CMBS,
	    

	/**
	 * Broker Confirmation Type of European Corporate.
	 */
	EUROPEAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type for Single Name European RMBS Transactions.
	 */
	EUROPEAN_RMBS,
	    

	/**
	 * Broker Confirmation Type of Japan Corporate.
	 */
	JAPAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of Japan Sovereign.
	 */
	JAPAN_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type of Latin America Corporate.
	 */
	LATIN_AMERICA_CORPORATE,
	    

	/**
	 * Broker Confirmation Type for LATIN AMERICA CORPORATE B.
	 */
	LATIN_AMERICA_CORPORATE_BOND,
	    

	/**
	 * Broker Confirmation Type for LATIN AMERICA CORPORATE BL.
	 */
	LATIN_AMERICA_CORPORATE_BOND_OR_LOAN,
	    

	/**
	 * Broker Confirmation Type of Latin America Sovereign.
	 */
	LATIN_AMERICA_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for MBX Transactions.
	 */
	MBX,
	    

	/**
	 * Broker Confirmation Type for Municipal CDX Untranched Transactions.
	 */
	MCDX,
	    

	/**
	 * Broker Confirmation Type of New Zealand Corporate.
	 */
	NEW_ZEALAND_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of New Zealand Sovereign.
	 */
	NEW_ZEALAND_SOVEREIGN,
	    

	/**
	 * Broker ConfirmationType of North American Corporate.
	 */
	NORTH_AMERICAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type for PO Index Transactions.
	 */
	PO,
	    

	/**
	 * Broker Confirmation Type of Singapore Corporate.
	 */
	SINGAPORE_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of Singapore Sovereign.
	 */
	SINGAPORE_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type of STANDARD ASIA CORPORATE.
	 */
	STANDARD_ASIA_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD ASIA SOVEREIGN.
	 */
	STANDARD_ASIA_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type of STANDARD AUSTRALIA CORPORATE.
	 */
	STANDARD_AUSTRALIA_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD AUSTRALIA SOVEREIGN.
	 */
	STANDARD_AUSTRALIA_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for Standard CDX Tranche Transactions.
	 */
	STANDARD_CDX_TRANCHE,
	    

	/**
	 * Broker Confirmation Type of STANDARD EMERGING EUROPEAN AND MIDDLE EASTERN SOVEREIGN.
	 */
	STANDARD_EMERGING_EUROPEAN_AND_MIDDLE_EASTERN_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type of STANDARD EMERGING EUROPEAN CORPORATE.
	 */
	STANDARD_EMERGING_EUROPEAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD EMERGING EUROPEAN CORPORATE LPN.
	 */
	STANDARD_EMERGING_EUROPEAN_CORPORATE_LPN,
	    

	/**
	 * Broker Confirmation Type for STANDARD EUROPEAN CORPORATE.
	 */
	STANDARD_EUROPEAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD JAPAN CORPORATE.
	 */
	STANDARD_JAPAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD JAPAN SOVEREIGN.
	 */
	STANDARD_JAPAN_SOVEREIGN,
	    

	/**
	 * Standard Syndicated Secured Loan Credit Default Swap Broker Confirmation Type.
	 */
	STANDARD_LCDS,
	    

	/**
	 * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Bullet Transactions.
	 */
	STANDARD_LCDS_BULLET,
	    

	/**
	 * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Transactions.
	 */
	STANDARD_LCDX_BULLET,
	    

	/**
	 * Broker Confirmation Type for Standard Syndicated Secured Loan Credit Default Swap Index Bullet Tranche Transactions.
	 */
	STANDARD_LCDX_BULLET_TRANCHE,
	    

	/**
	 * Broker Confirmation Type of STANDARD LATIN AMERICA CORPORATE B.
	 */
	STANDARD_LATIN_AMERICA_CORPORATE_BOND,
	    

	/**
	 * Broker Confirmation Type of STANDARD LATIN AMERICA CORPORATE BL.
	 */
	STANDARD_LATIN_AMERICA_CORPORATE_BOND_OR_LOAN,
	    

	/**
	 * Broker Confirmation Type of STANDARD LATIN AMERICA SOVEREIGN.
	 */
	STANDARD_LATIN_AMERICA_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type of STANDARD NEW ZEALAND CORPORATE.
	 */
	STANDARD_NEW_ZEALAND_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD NEW ZEALAND SOVEREIGN.
	 */
	STANDARD_NEW_ZEALAND_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for STANDARD NORTH AMERICAN CORPORATE.
	 */
	STANDARD_NORTH_AMERICAN_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD SINGAPORE CORPORATE.
	 */
	STANDARD_SINGAPORE_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of STANDARD SINGAPORE SOVEREIGN.
	 */
	STANDARD_SINGAPORE_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for STANDARD SUBORDINATED EUROPEAN INSURANCE CORPORATE.
	 */
	STANDARD_SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE,
	    

	/**
	 * Broker Confirmation Type for STANDARD WESTERN EUROPEAN SOVEREIGN.
	 */
	STANDARD_WESTERN_EUROPEAN_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for Standard iTraxx Europe Tranched Transactions.
	 */
	STANDARDI_TRAXX_EUROPE_TRANCHE,
	    

	/**
	 * Broker Confirmation Type of Subordinated European Insurance Corporate.
	 */
	SUBORDINATED_EUROPEAN_INSURANCE_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of SUKUK CORPORATE.
	 */
	SUKUK_CORPORATE,
	    

	/**
	 * Broker Confirmation Type of SUKUK SOVEREIGN.
	 */
	SUKUK_SOVEREIGN,
	    

	/**
	 * Syndicated Secured Loan Credit Default Swap Broker Confirmation Type.
	 */
	SYNDICATED_SECURED_LOAN_CDS,
	    

	/**
	 * Broker Confirmation Type for TRX Transactions.
	 */
	TRX,
	    

	/**
	 * Broker Confirmation Type for TRX.II Transactions.
	 */
	TRX_II("TRX.II"),
	

	/**
	 * Broker Confirmation Type for U.S. MUNICIPAL FULL FAITH AND CREDIT.
	 */
	US_MUNICIPAL_FULL_FAITH_AND_CREDIT,
	    

	/**
	 * Broker Confirmation Type for U.S. MUNICIPAL GENERAL FUND.
	 */
	US_MUNICIPAL_GENERAL_FUND,
	    

	/**
	 * Broker Confirmation Type for U.S. MUNICIPAL REVENUE.
	 */
	US_MUNICIPAL_REVENUE,
	    

	/**
	 * Broker Confirmation Type of Western European Sovereign.
	 */
	WESTERN_EUROPEAN_SOVEREIGN,
	    

	/**
	 * Broker Confirmation Type for iTraxx Asia Excluding Japan.
	 */
	I_TRAXX_ASIA_EX_JAPAN,
	    

	/**
	 * Broker Confirmation Type for iTraxx Asia Ex-Japan Swaption Transactions.
	 */
	I_TRAXX_ASIA_EX_JAPAN_SWAPTION,
	    

	/**
	 * Broker Confirmation Type for iTraxx Asia Excluding Japan Tranched Transactions.
	 */
	I_TRAXX_ASIA_EX_JAPAN_TRANCHE,
	    

	/**
	 * Broker Confirmation Type for iTraxx Australia.
	 */
	I_TRAXX_AUSTRALIA,
	    

	/**
	 * Broker Confirmation Type for iTraxx Australia Swaption Transactions.
	 */
	I_TRAXX_AUSTRALIA_SWAPTION,
	    

	/**
	 * Broker Confirmation Type for iTraxx Australia Tranched Transactions.
	 */
	I_TRAXX_AUSTRALIA_TRANCHE,
	    

	/**
	 * Broker Confirmation Type for iTraxx CJ.
	 */
	I_TRAXX_CJ,
	    

	/**
	 * Broker Confirmation Type for iTraxx CJ Tranched Transactions.
	 */
	I_TRAXX_CJ_TRANCHE,
	    

	/**
	 * Broker Confirmation Type for iTraxx Europe Transactions
	 */
	I_TRAXX_EUROPE,
	    

	/**
	 * Broker Confirmation Type for iTraxx Europe Swaption Transactions.
	 */
	I_TRAXX_EUROPE_SWAPTION,
	    

	/**
	 * Broker Confirmation Type for iTraxx Europe Tranched Transactions.
	 */
	I_TRAXX_EUROPE_TRANCHE,
	    

	/**
	 * Broker Confirmation Type for iTraxx Japan.
	 */
	I_TRAXX_JAPAN,
	    

	/**
	 * Broker Confirmation Type for iTraxx Japan Swaption Transactions.
	 */
	I_TRAXX_JAPAN_SWAPTION,
	    

	/**
	 * Broker Confirmation Type for iTraxx Japan Tranched Transactions.
	 */
	I_TRAXX_JAPAN_TRANCHE,
	    

	/**
	 * Broker Confirmation Type for iTraxx LevX.
	 */
	I_TRAXX_LEV_X,
	    

	/**
	 * Broker Confirmation Type for iTraxx SDI 75 Transactions.
	 */
	I_TRAXX_SDI_75,
	    

	/**
	 * Broker Confirmation Type for iTraxx SovX.
	 */
	I_TRAXX_SOV_X    
	;

	private final String displayName;
	
	BrokerConfirmationTypeEnum() {
		this.displayName = null;
	}

	BrokerConfirmationTypeEnum(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
