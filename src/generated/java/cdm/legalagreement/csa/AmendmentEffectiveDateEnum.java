package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the effective date of the Amendment to Termination Currency when specified as a specific date (e.g. the annex date). ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (t).
 * @version ${project.version}
 */
public enum AmendmentEffectiveDateEnum {
    

	/**
	 * The effective date corresponds to the Annex date.
	 */
	@RosettaSynonym(value = "annex", source = "ISDA_Create_1_0")
	ANNEX_DATE,
	    

	/**
	 * The effective date corresponds to the Deed date.
	 */
	@RosettaSynonym(value = "deed", source = "ISDA_Create_1_0")
	DEED_DATE,
	    

	/**
	 * The effective date corresponds to the Agreement date.
	 */
	@RosettaSynonym(value = "agreement", source = "ISDA_Create_1_0")
	AGREEMENT_DATE,
	    

	/**
	 * The effective date corresponds to the Amendment Effective Date (IM)
	 */
	@RosettaSynonym(value = "amendment_effective_date", source = "ISDA_Create_1_0")
	AMENDMENT_EFFECTIVE_DATE    
	;

	private final String displayName;
	
	AmendmentEffectiveDateEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
