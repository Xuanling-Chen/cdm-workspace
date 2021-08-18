package cdm.observable.asset;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * Provides enumerated values for types of prices in the Price data type in order to explain how to interpret the amount and use it in calculations.
 * @version ${project.version}
 */
public enum PriceTypeEnum {
    

	/**
	 * Denotes interest accrued between payments, represented as a decimal, for example the accrued interest associated with a bond trade.
	 */
	ACCRUED_INTEREST,
	    

	/**
	 * Denotes the maximum allowable level of a floating rate for the calculation period, which is used for a cap rate contractual product or in the context of a floating leg.  The CapRate is assumed to be exclusive of any spread, and is defined as a per annum rate expressed as a decimal, for example, the value of 0.05 is the equivalent of 5.0%.
	 */
	CAP_RATE,
	    

	/**
	 * Denotes a price expressed as a cash amount for an upfront fee or other purposes. For example, {amount, unitOfAmount, PerUnitOfAmount} = [12,500, USD, null] = USD 12,500.
	 */
	CASH_PRICE,
	    

	/**
	 * Denotes a bond price without accrued interest.
	 */
	CLEAN_PRICE,
	    

	/**
	 * Denotes the net price excluding accrued interest. The Dirty Price for bonds is put in the netPrice element, which includes accrued interest. Thus netPrice - cleanNetPrice = accruedInterest. The currency and price expression for this field are the same as those for the (dirty) netPrice.
	 */
	CLEAN_NET_PRICE,
	    

	/**
	 * Denotes the amount of commission on the trade.
	 */
	COMMISSION,
	    

	/**
	 * Denotes a bond price with accrued interest.
	 */
	DIRTY_PRICE,
	    

	/**
	 * Denotes a discount factor expressed as a decimal, e.g. 0.95.
	 */
	DISCOUNT,
	    

	/**
	 * Denotes an all-in-rate (Spot plus forward if applicable) to convert one currency or other measure of value to another.  Foreign Excahnge rates are represented in decimals, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [1.23, USD, GBP] = USD 1.23 for every 1 GBP.
	 */
	EXCHANGE_RATE,
	    

	/**
	 * Denotes the minimum allowable level of a floating rate for the calculation period. Can be used for a floor rate contractual product or in the context of a floating leg. The cap rate is assumed to be exclusive of any spread and is a per annum rate, expressed as a decimal.  For example, a floorRate value of 0.05 is the equivalent of 5.0%.
	 */
	FLOOR_RATE,
	    

	/**
	 * Denotes the points to be added to a spot price to represent a forward price, expressed as a decimal. For example for a foreign exchange forward trade.
	 */
	FORWARD_POINTS,
	    

	/**
	 * Denotes a negotiated price for a security or listed product, including as applicable any commissions, discounts, accrued interest, and rebates.
	 */
	GROSS_PRICE,
	    

	/**
	 * Denotes an interest rate to be applied to quantity of notional amount, interest rates are usually quoted as annualised rates and represented as decimal, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [0.015, USD, USD] = 1.5% of the USD notional quantity/amount (or 1.5 cents for every USD of notional amount).
	 */
	@RosettaSynonym(value = "InterestRate", source = "Workflow_Event")
	INTEREST_RATE,
	    

	/**
	 * Denotes a value to be multiplied by the observed index value to scale it before adding a spread.
	 */
	MULTIPLIER_OF_INDEX_VALUE,
	    

	/**
	 * Denotes a negotiated price for a security or listed product - excluding as applicable any commissions, discounts, accrued interest, and rebates.
	 */
	NET_PRICE,
	    

	/**
	 * Denotes a price expressed in percentage of face value with fractions which is used for quoting bonds, e.g. 101 3/8 indicates that the buyer will pay 101.375 of the face value.
	 */
	PAR_VALUE_FRACTION,
	    

	/**
	 * Denotes the amount payable by the buyer to the seller for an option.  The premium is paid on the specified premium payment date or on each premium payment date if specified.
	 */
	PREMIUM,
	    

	/**
	 * Denotes a price expressed as a rate to be applied to quantity/notional amount and represented as decimal, e.g. {amount, unitOfAmount, PerUnitOfAmount} = [0.08, EUR, EUR] = 8%  of the EUR notional quantity/amount or 8 cents for every EUR of notional amount.
	 */
	RATE_PRICE,
	    

	/**
	 * Denotes a price expressed as a decimal for the purposes of calculating the Physical Settlement Amount or Cash Settlement Amount on a Credit Derivative transaction.
	 */
	REFERENCE_PRICE,
	    

	/**
	 * Denotes price/rate for a near-immediate delivery according to the conventions of a market, for example, in the commodities market.
	 */
	SPOT,
	    

	/**
	 * Denotes a difference in interest rates or prices expressed as a decimal, for example, in the case of a spread between two interest rates, the value of 0.05 is the equivalent of 500 basis points or 5.0%.
	 */
	SPREAD    
	;

	private final String displayName;
	
	PriceTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
