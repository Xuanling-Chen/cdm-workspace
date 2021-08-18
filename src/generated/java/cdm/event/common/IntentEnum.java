package cdm.event.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumeration values to qualify the intent associated with a transaction event.
 * @version ${project.version}
 */
public enum IntentEnum {
    

	/**
	 * The intent is to correct the event or associated execution/contract.
	 */
	@RosettaSynonym(value = "correction", source = "Workflow_Event")
	CORRECTION,
	    

	/**
	 * The intent is to increase the notional or quantity associated with the contract or execution.
	 */
	@RosettaSynonym(value = "increase", source = "Workflow_Event")
	INCREASE,
	    

	/**
	 * The intent is to replace an interest rate index by another one during the life of a trade and add a transition spread on top of this index (and on top of the spreads already defined in the trade, if any). 
	 */
	@RosettaSynonym(value = "indexTransition", source = "Workflow_Event")
	INDEX_TRANSITION,
	    

	/**
	 * The intent is to reduce the notional or quantity associated with the contract (a.k.a. partially terminate it).
	 */
	@RosettaSynonym(value = "partialTermination", source = "Workflow_Event")
	PARTIAL_TERMINATION,
	    

	/**
	 * The intent is to reallocate one or more trades as part of an allocated block trade.
	 */
	REALLOCATION,
	    

	/**
	 * The intent is to re-negotiate some of the terms of the contract.
	 */
	@RosettaSynonym(value = "renegotiation", source = "Workflow_Event")
	RENEGOTIATION,
	    

	/**
	 * The intent is to terminate the contract.
	 */
	@RosettaSynonym(value = "termination", source = "Workflow_Event")
	TERMINATION    
	;

	private final String displayName;
	
	IntentEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
