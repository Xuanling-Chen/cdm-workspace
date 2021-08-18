package cdm.legalagreement.master;


/**
 * The enumerated values to specify the type of the master agreement governing the transaction.
 * @version ${project.version}
 */
public enum MasterAgreementTypeEnum {
    

	/**
	 * AFB Master Agreement for Foreign Exchange and Derivatives Transactions
	 */
	AFB,
	    

	/**
	 * A Bespoke (custom) Master Agreement, including one-off agreements for transactions
	 */
	BESPOKE,
	    

	/**
	 * Clearing Master Agreement
	 */
	CMA,
	    

	/**
	 * Contrato Marco de Operaciones Financieras
	 */
	CMOF,
	    

	/**
	 * EEI Master Power Purchase and Sale Agreement
	 */
	EEI_POWER,
	    

	/**
	 * EFET General Agreement Concerning the Delivery and Acceptance of Electricity
	 */
	EFET_ELECTRICITY,
	    

	/**
	 * EFET General Agreement Concerning The Delivery And Acceptance of Natural Gas
	 */
	EFET_GAS,
	    

	/**
	 * European Master Agreement and the Derivatives Annex (Banking Federation of the European Union)
	 */
	EMA,
	    

	/**
	 * Master Agreement Relating to transactions on Forward Financial Instruments (Federation Bancaire Francaise)
	 */
	FBF,
	    

	/**
	 * ICMA Global Master Agreement for REPO Trades
	 */
	GMRA,
	    

	/**
	 * ISLA Global Master Agreement for Securities Lending
	 */
	GMSLA,
	    

	/**
	 * FOA Grid Trade Master Agreement
	 */
	GTMA,
	    

	/**
	 * GasEDI Base Contract for Short-term Sale and Purchase of Natural Gas
	 */
	GAS_EDI,
	    

	/**
	 * German Master Agreement for Financial derivatives and Addendum for Options on Stock Exchange Indices or Securities
	 */
	GERMAN,
	    

	/**
	 * International Currency Options Market Master Agreement
	 */
	ICOM,
	    

	/**
	 * International Emissions Trading Association Emissions Reduction Purchase Agreement
	 */
	IETA_ERPA("IETA-ERPA"),
	

	/**
	 * International Emissions Trading Association Emissions Trading Master Agreement
	 */
	IETA_ETMA("IETA-ETMA"),
	

	/**
	 * International Emissions Trading Association International Emissions Trading Master Agreement
	 */
	IETA_IETMA("IETA-IETMA"),
	

	/**
	 * International Foreign Exchange Master Agreement
	 */
	IFEMA,
	    

	/**
	 * International Foreign Exchange and Options Master Agreement
	 */
	IFEOMA,
	    

	/**
	 * ISDA Master Agreement
	 */
	ISDA,
	    

	/**
	 * ISDA-FIA Cleared Derivatives Execution Agreement
	 */
	ISDAFIA_CDEA("ISDAFIA-CDEA"),
	

	/**
	 * Master agreement of Japan Securities Clearing Corporation
	 */
	JSCC,
	    

	/**
	 * International Bullion Master Agreement Terms published by the London Bullion Market Association
	 */
	LBMA,
	    

	/**
	 * Leadership in Energy Automated Processing
	 */
	LEAP,
	    

	/**
	 * CTA Master Coal Purchase and Sales Agreement
	 */
	MCPSA,
	    

	/**
	 * NAESB Base Contract for Sale and Purchase of Natural Gas
	 */
	NAESB_GAS,
	    

	/**
	 * Short Term Flat NBP Trading Terms and Conditions
	 */
	NBP,
	    

	/**
	 * Standard Documentation for Derivative Transactions on the Russian Financial Markets
	 */
	RUSSIAN_DERIVATIVES,
	    

	/**
	 * Master Agreement and Contractual Terms for Repurchase Agreements on the Russian Financial Market
	 */
	RUSSIAN_REPO,
	    

	/**
	 * globalCOAL Standard Coal Trading Agreement
	 */
	S_CO_TA,
	    

	/**
	 * Swiss Master Agreement for OTC Derivatives Instruments
	 */
	SWISS,
	    

	/**
	 * TTF Hub Natural Gas Trading Terms and Conditions
	 */
	TTF,
	    

	/**
	 * Zeebrugge Hub Natural Gas Trading Terms and Conditions
	 */
	ZBT    
	;

	private final String displayName;
	
	MasterAgreementTypeEnum() {
		this.displayName = null;
	}

	MasterAgreementTypeEnum(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
