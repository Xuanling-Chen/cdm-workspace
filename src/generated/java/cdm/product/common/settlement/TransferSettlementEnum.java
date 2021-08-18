package cdm.product.common.settlement;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumeration values to specify how the transfer will settle, e.g. DvP.
 * @version ${project.version}
 */
public enum TransferSettlementEnum {
    

	/**
	 * Simultaneous transfer of two assets, typically securities, as a way to avoid settlement risk.
	 */
	@RosettaSynonym(value = "DeliveryVersusDelivery", source = "Workflow_Event")
	DELIVERY_VERSUS_DELIVERY,
	    

	/**
	 * Settlement in which the transfer of the asset and the cash settlement are simultaneous.
	 */
	@RosettaSynonym(value = "DeliveryVersusPayment", source = "Workflow_Event")
	DELIVERY_VERSUS_PAYMENT,
	    

	/**
	 * Simultaneous transfer of cashflows.
	 */
	@RosettaSynonym(value = "PaymentVersusPayment", source = "Workflow_Event")
	PAYMENT_VERSUS_PAYMENT,
	    

	/**
	 * No central settlement.
	 */
	NOT_CENTRAL_SETTLEMENT    
	;

	private final String displayName;
	
	TransferSettlementEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
