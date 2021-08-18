package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the Additional Type of transaction that can require the collection or delivery of initial margin under a given regulatory regime for the purposes of Covered Transactions, as specified in ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (b)(B).
 * @version ${project.version}
 */
public enum AdditionalTypeEnum {
    

	/**
	 * No Additional Type of transaction is applicable to the regulatory regulatory regime.
	 */
	@RosettaSynonym(value = "not_applicable", source = "ISDA_Create_1_0")
	NOT_APPLICABLE,
	    

	/**
	 * Single stock equity option or index option transaction as referred to in the transitional provisions (if any) of the EMIR RTS.
	 */
	EQUITY_OPTION_OR_INDEX_OPTION,
	    

	/**
	 */
	@RosettaSynonym(value = "other", source = "ISDA_Create_1_0")
	OTHER    
	;

	private final String displayName;
	
	AdditionalTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
