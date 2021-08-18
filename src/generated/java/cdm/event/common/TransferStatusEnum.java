package cdm.event.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumeration values to specify the transfer status.
 * @version ${project.version}
 */
public enum TransferStatusEnum {
    

	/**
	 * The transfer is disputed.
	 */
	@RosettaSynonym(value = "disputed", source = "Workflow_Event")
	DISPUTED,
	    

	/**
	 * The transfer has been instructed.
	 */
	@RosettaSynonym(value = "instructed", source = "Workflow_Event")
	INSTRUCTED,
	    

	/**
	 * The transfer is pending instruction.
	 */
	@RosettaSynonym(value = "pending", source = "Workflow_Event")
	PENDING,
	    

	/**
	 * The transfer has been settled.
	 */
	@RosettaSynonym(value = "settled", source = "Workflow_Event")
	SETTLED    
	;

	private final String displayName;
	
	TransferStatusEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
