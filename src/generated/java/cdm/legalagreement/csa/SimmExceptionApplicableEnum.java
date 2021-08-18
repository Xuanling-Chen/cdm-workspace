package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to the specify the SIMM normalized exception approaches applicable to the ISDA 2018 Standard CSA. ISDA 2018 Credit Support Annex for Initial Margin, paragraph 13, General Principles.
 * @version ${project.version}
 */
public enum SimmExceptionApplicableEnum {
    

	/**
	 * The ISDA Standard Initial Margin Model exception is applicable as a Fallback to Mandatory Method. ISDA 2018 Credit Support Annex for Initial Margin, paragraph 13, General Principles.
	 */
	@RosettaSynonym(value = "fallback", source = "ISDA_Create_1_0")
	FALL_BACK_TO_MANDATORY_METHOD,
	    

	/**
	 * The ISDA Standard Initial Margin Model exception is applicable as a Mandatory Method. This means that the method applicable is to determine the Margin Amount (IM) by reference to the methodology prescribed pursuant to the applicable regulatory regime which uses a standardized initial margin schedule (such that prescribed percentages are applied to notional amounts before being adjusted, including by a net-to-gross ratio (NGR)). ISDA 2018 Credit Support Annex for Initial Margin, paragraph 13, General Principles.
	 */
	@RosettaSynonym(value = "mandatory", source = "ISDA_Create_1_0")
	MANDATORY_METHOD,
	    

	/**
	 * An alternative approach is described in the document as follows.
	 */
	@RosettaSynonym(value = "other", source = "ISDA_Create_1_0")
	OTHER_METHOD    
	;

	private final String displayName;
	
	SimmExceptionApplicableEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
