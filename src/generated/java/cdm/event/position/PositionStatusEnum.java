package cdm.event.position;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * Enumeration to describe the different (risk) states of a Position, whether executed, settled, matured...etc
 * @version ${project.version}
 */
public enum PositionStatusEnum {
    

	/**
	 * The position has been executed, which is the point at which risk has been transferred.
	 */
	@RosettaSynonym(value = "executed", source = "Workflow_Event")
	EXECUTED,
	    

	/**
	 * Contract has been formed, in case position is on a contractual product.
	 */
	@RosettaSynonym(value = "form", source = "Workflow_Event")
	FORMED,
	    

	/**
	 * The position has settled, in case product is subject to settlement after execution, such as securities.
	 */
	@RosettaSynonym(value = "settled", source = "Workflow_Event")
	SETTLED,
	    

	/**
	 * The position has been cancelled, in case of a cancellation event following an execution.
	 */
	@RosettaSynonym(value = "cancelled", source = "Workflow_Event")
	CANCELLED,
	    

	/**
	 * The position has been closed, in case of a termination event.
	 */
	@RosettaSynonym(value = "closed", source = "Workflow_Event")
	CLOSED    
	;

	private final String displayName;
	
	PositionStatusEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
