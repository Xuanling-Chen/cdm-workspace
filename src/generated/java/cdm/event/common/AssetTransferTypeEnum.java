package cdm.event.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The qualification of the type of asset transfer.
 * @version ${project.version}
 */
public enum AssetTransferTypeEnum {
    

	/**
	 * The transfer of assets takes place without a corresponding exchange of payment.
	 */
	@RosettaSynonym(value = "FreeOfPayment", source = "Workflow_Event")
	FREE_OF_PAYMENT    
	;

	private final String displayName;
	
	AssetTransferTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
