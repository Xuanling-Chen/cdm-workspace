package cdm.legalagreement.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the Execution Location of a Security Agreement
 * @version ${project.version}
 */
public enum ExecutionLocationEnum {
    

	/**
	 * The Agreement was executed outside of Belgium
	 */
	@RosettaSynonym(value = "executed_outside_of_belgium", source = "ISDA_Create_1_0")
	EXECUTED_OUTSIDE_BELGIUM,
	    

	/**
	 * The Agreement was executed outside of Belgium
	 */
	@RosettaSynonym(value = "executed_in_belgium", source = "ISDA_Create_1_0")
	EXECUTED_IN_BELGIUM,
	    

	/**
	 * An alternative approach is described in the document as follows.
	 */
	@RosettaSynonym(value = "other", source = "ISDA_Create_1_0")
	OTHER_LOCATION    
	;

	private final String displayName;
	
	ExecutionLocationEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
