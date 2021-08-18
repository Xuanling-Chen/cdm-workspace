package cdm.product.common.settlement;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The qualification of the type of cash flows associated with OTC derivatives contracts and their lifecycle events.
 * @version ${project.version}
 */
public enum CashflowTypeEnum {
    

	/**
	 * A cash flow associated with an amendment lifecycle event.
	 */
	AMENDMENT_FEE,
	    

	/**
	 * A cash flow resulting from the assignment of a contract to a new counterparty.
	 */
	ASSIGNMENT_FEE,
	    

	/**
	 * The brokerage commission.
	 */
	@RosettaSynonym(value = "brokerageCommission", source = "Workflow_Event")
	BROKERAGE_COMMISSION,
	    

	/**
	 * A cash flow corresponding to the periodic accrued interests.
	 */
	COUPON,
	    

	/**
	 * A cashflow resulting from a credit event.
	 */
	CREDIT_EVENT,
	    

	/**
	 * A cash flow corresponding to the synthetic dividend of an equity underlier asset traded through a derivative instrument.
	 */
	DIVIDEND_RETURN,
	    

	/**
	 * A cash flow associated with an exercise lifecycle event.
	 */
	EXERCISE_FEE,
	    

	/**
	 * A generic term for describing a non-scheduled cashflow that can be associated either with the initial contract, with some later corrections to it (e.g. a correction to the day count fraction that has a cashflow impact) or with some lifecycle events. Fees that are specifically associated with termination and partial termination, increase, amendment, and exercise events are qualified accordingly.
	 */
	@RosettaSynonym(value = "fee", source = "Workflow_Event")
	FEE,
	    

	/**
	 * A cash flow associated with an increase lifecycle event.
	 */
	INCREASE_FEE,
	    

	/**
	 * Interest, without qualification as to whether it a gross or net interest relates cashflow.
	 */
	@RosettaSynonym(value = "interest", source = "Workflow_Event")
	INTEREST,
	    

	/**
	 * A cash flow corresponding to the return of the interest rate portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
	 */
	INTEREST_RETURN,
	    

	/**
	 * Net interest across payout components. Applicable to products such as interest rate swaps.
	 */
	@RosettaSynonym(value = "netInterest", source = "Workflow_Event")
	NET_INTEREST,
	    

	/**
	 * The novation fee.
	 */
	@RosettaSynonym(value = "novationFee", source = "Workflow_Event")
	NOVATION_FEE,
	    

	/**
	 * A cash flow associated with a partial termination lifecycle event.
	 */
	PARTIAL_TERMINATION_FEE,
	    

	/**
	 * The premium associated with an OTC contract such as an option or a cap/floor.
	 */
	@RosettaSynonym(value = "premium", source = "Workflow_Event")
	PREMIUM,
	    

	/**
	 * A cash flow corresponding to the return of the price portion of a derivative instrument that has different types of underlying assets, such as a total return swap.
	 */
	PRICE_RETURN,
	    

	/**
	 * A cash flow which amount typically corresponds to the notional of the contract and that is exchanged between the parties on trade inception and reverted back when the contract is terminated.
	 */
	PRINCIPAL_EXCHANGE,
	    

	/**
	 * A cash flow associated with a termination lifecycle event.
	 */
	TERMINATION_FEE,
	    

	/**
	 * An upfront cashflow associated to the swap to adjust for a difference between the swap price and the current market price.
	 */
	UPFRONT_FEE    
	;

	private final String displayName;
	
	CashflowTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
