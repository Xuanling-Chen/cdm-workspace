package cdm.event.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify how a contract has been executed, e.g. electronically, verbally, ...
 * @version ${project.version}
 */
public enum ExecutionTypeEnum {
    

	/**
	 * Execution via electronic execution facility, derivatives contract market, or other electronic message such as an instant message.
	 */
	@RosettaSynonym(value = "Electronic", source = "Workflow_Event")
	ELECTRONIC,
	    

	/**
	 * Bilateral execution between counterparties not pursuant to the rules of a SEF or DCM.
	 */
	@RosettaSynonym(value = "OffFacility", source = "Workflow_Event")
	OFF_FACILITY    
	;

	private final String displayName;
	
	ExecutionTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
