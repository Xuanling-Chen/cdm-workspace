package cdm.event.workflow;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumeration values to specify the level at which the limit is set: customer business, proprietary business or account level. This is part of the CME specification for clearing credit limits, although not specified as a set of enumerated values as part of the clearing confirmation specification.
 * @version ${project.version}
 */
public enum LimitLevelEnum {
    

	/**
	 * The limit is set in relation to the proprietary business undertaken by the clearing counterparty.
	 */
	@RosettaSynonym(value = "ACCT", source = "Workflow_Event")
	ACCOUNT,
	    

	/**
	 * The limit is set in relation to the customer business undertaken by the clearing counterparty.
	 */
	@RosettaSynonym(value = "CUST", source = "Workflow_Event")
	CUSTOMER,
	    

	/**
	 * The limit is set at the account level in relation to the clearing counterparty.
	 */
	@RosettaSynonym(value = "HOUS", source = "Workflow_Event")
	HOUSE    
	;

	private final String displayName;
	
	LimitLevelEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
