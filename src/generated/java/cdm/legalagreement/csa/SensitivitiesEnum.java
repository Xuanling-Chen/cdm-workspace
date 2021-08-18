package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the methodology according to which sensitivities to (i) equity indices, funds and ETFs, and (ii) commodity indices are computed. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (gg)(2).
 * @version ${project.version}
 */
public enum SensitivitiesEnum {
    

	/**
	 * The parties agree that in respect of the relevant sensitivities, the delta is allocated back to individual constituents.
	 */
	@RosettaSynonym(value = "alternative", source = "ISDA_Create_1_0")
	ALTERNATIVE,
	    

	/**
	 * The relevant sensitivities are addressed by the standard preferred approach where the entire delta is put into the applicable asset class/category.
	 */
	@RosettaSynonym(value = "standard", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "not_specified", source = "ISDA_Create_1_0")
	STANDARD    
	;

	private final String displayName;
	
	SensitivitiesEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
