package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the procedure under which the market value of posted collateral will be recalculated.
 * @version ${project.version}
 */
public enum RecalculationOfValueElectionEnum {
    

	/**
	 * The parties agree to consult
	 */
	@RosettaSynonym(value = "consultation_procedure", source = "ISDA_Create_1_0")
	CONSULATION_PROCEDURE,
	    

	/**
	 * The procedures specified in an Other Regulatory CSA
	 */
	@RosettaSynonym(value = "other_regulatory_CSA_procedure", source = "ISDA_Create_1_0")
	OTHER_REGULATORY_CSA_PROCEDURE,
	    

	/**
	 * Description to be added
	 */
	@RosettaSynonym(value = "not_applicable", source = "ISDA_Create_1_0")
	NOT_APPLICABLE,
	    

	/**
	 * Bespoke Recalculation of value terms are specified in the agreement.
	 */
	@RosettaSynonym(value = "specified", source = "ISDA_Create_1_0")
	SPECIFIED    
	;

	private final String displayName;
	
	RecalculationOfValueElectionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
