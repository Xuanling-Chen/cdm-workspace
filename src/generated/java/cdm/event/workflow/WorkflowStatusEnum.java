package cdm.event.workflow;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * @version ${project.version}
 */
public enum WorkflowStatusEnum {
    

	/**
	 */
	@RosettaSynonym(value = "Accepted", source = "Workflow_Event")
	ACCEPTED,
	    

	/**
	 */
	ALLEGED,
	    

	/**
	 */
	@RosettaSynonym(value = "Amended", source = "Workflow_Event")
	AMENDED,
	    

	/**
	 */
	CANCELLED,
	    

	/**
	 */
	CERTAIN,
	    

	/**
	 */
	@RosettaSynonym(value = "Cleared", source = "Workflow_Event")
	CLEARED,
	    

	/**
	 */
	PENDING,
	    

	/**
	 */
	@RosettaSynonym(value = "Rejected", source = "Workflow_Event")
	REJECTED,
	    

	/**
	 */
	@RosettaSynonym(value = "Submitted", source = "Workflow_Event")
	SUBMITTED,
	    

	/**
	 */
	@RosettaSynonym(value = "Terminated", source = "Workflow_Event")
	TERMINATED,
	    

	/**
	 */
	UNCERTAIN,
	    

	/**
	 */
	UNCONFIRMED,
	    

	/**
	 */
	@RosettaSynonym(value = "Affirmed", source = "Workflow_Event")
	AFFIRMED,
	    

	/**
	 */
	@RosettaSynonym(value = "Confirmed", source = "Workflow_Event")
	CONFIRMED    
	;

	private final String displayName;
	
	WorkflowStatusEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
