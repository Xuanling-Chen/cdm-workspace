package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the normalized exceptions applicable to an Initial Margin CSA.
 * @version ${project.version}
 */
public enum ExceptionEnum {
    

	/**
	 * The election is applicable.
	 */
	@RosettaSynonym(value = "applicable", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "not_specified", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "false", source = "ISDA_Create_1_0")
	APPLICABLE,
	    

	/**
	 * The exception is not applicable. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles. | ISDA 2018 Credit Support Annex for Initial Margin, paragraph 13, General Principles.
	 */
	@RosettaSynonym(value = "not_applicable", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "paragraph_3_1_will_not_apply", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "paragraph_4a_will_not_apply", source = "ISDA_Create_1_0")
	NOT_APPLICABLE,
	    

	/**
	 * An alternative approach is described in the document as follows.
	 */
	@RosettaSynonym(value = "other", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "true", source = "ISDA_Create_1_0")
	OTHER    
	;

	private final String displayName;
	
	ExceptionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
