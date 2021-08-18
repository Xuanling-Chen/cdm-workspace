package cdm.legalagreement.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify what led to the contract or execution closure.
 * @version ${project.version}
 */
public enum ClosedStateEnum {
    

	/**
	 * The execution or contract has been allocated.
	 */
	@RosettaSynonym(value = "allocated", source = "Workflow_Event")
	ALLOCATED,
	    

	/**
	 * The execution or contract has been cancelled.
	 */
	@RosettaSynonym(value = "cancelled", source = "Workflow_Event")
	CANCELLED,
	    

	/**
	 * The (option) contract has been exercised.
	 */
	@RosettaSynonym(value = "exercised", source = "Workflow_Event")
	EXERCISED,
	    

	/**
	 * The (option) contract has expired without being exercised.
	 */
	EXPIRED,
	    

	/**
	 * The contract has reached its contractual termination date.
	 */
	MATURED,
	    

	/**
	 * The contract has been novated. This state applies to the stepped-out contract component of the novation event.
	 */
	@RosettaSynonym(value = "novated", source = "Workflow_Event")
	NOVATED,
	    

	/**
	 * The contract has been subject of an early termination event.
	 */
	@RosettaSynonym(value = "terminated", source = "Workflow_Event")
	TERMINATED    
	;

	private final String displayName;
	
	ClosedStateEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
