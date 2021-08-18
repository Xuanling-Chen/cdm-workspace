package cdm.base.staticdata.asset.common;


/**
 * The enumerated values to specify taxonomy sources.
 * @version ${project.version}
 */
public enum TaxonomySourceEnum {
    

	/**
	 * The ISO 10962 Classification of Financial Instruments code
	 */
	CFI,
	    

	/**
	 * The ISDA product taxonomy
	 */
	ISDA,
	    

	/**
	 * ISDA Collateral Asset Definition Idenifier code.
	 */
	ICAD,
	    

	/**
	 * Identifies European Union Eligible Collateral Assets classification categories based on EMIR Uncleared Margin Rules.
	 */
	EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS,
	    

	/**
	 * Identifies United Kingdom Eligible Collateral Assets classification categories based on UK Onshored EMIR Uncleared Margin Rules Eligible Collateral asset classes for both initial margin (IM) and variation margin (VM) posted and collected between specified entities.Please note: UK EMIR regulation will detail which eligible collateral assets classes apply to each type of entity pairing (counterparty) and which apply to posting of IM and VM.
	 */
	UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS,
	    

	/**
	 * Identifies US Eligible Collateral Assets classification categories based on Uncleared Margin Rules published by the CFTC and the US Prudential Regulator. Note: While the same basic categories exist in the CFTC and US Prudential Regulators margin rules, the precise definitions or application of those rules could differ between the two rules.
	 */
	US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS    
	;

	private final String displayName;
	
	TaxonomySourceEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
