package cdm.product.common.settlement;


/**
 * Defines the different cash settlement methods for a product where cash settlement is applicable.
 * @version ${project.version}
 */
public enum CashSettlementMethodEnum {
    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (a).
	 */
	CASH_PRICE_METHOD,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (b).
	 */
	CASH_PRICE_ALTERNATE_METHOD,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (c).
	 */
	PAR_YIELD_CURVE_ADJUSTED_METHOD,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (d).
	 */
	ZERO_COUPON_YIELD_ADJUSTED_METHOD,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (e).
	 */
	PAR_YIELD_CURVE_UNADJUSTED_METHOD,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (f) (published in Supplement number 23).
	 */
	CROSS_CURRENCY_METHOD,
	    

	/**
	 * An ISDA defined cash settlement method (yield curve) used for the determination of the applicable cash settlement amount. The method is defined in the 2006 ISDA Definitions, Section 18.3. Cash Settlement Methods, paragraph (g) (published in Supplement number 28). The method is defined in the 2021 ISDA Definitions, section 18.2.6.
	 */
	COLLATERALIZED_CASH_PRICE_METHOD,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.1.
	 */
	MID_MARKET_INDICATIVE_QUOTATIONS,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.2.
	 */
	MID_MARKET_INDICATIVE_QUOTATIONS_ALTERNATE,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.3.
	 */
	MID_MARKET_CALCULATION_AGENT_DETERMINATION,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.4.
	 */
	REPLACEMENT_VALUE_FIRM_QUOTATIONS,
	    

	/**
	 * An ISDA defined cash settlement method used for the determination of the applicable cash settlement amount. The method is defined in the 2021 ISDA Definitions, Section 18.2.5
	 */
	REPLACEMENT_VALUE_CALCULATION_AGENT_DETERMINATION    
	;

	private final String displayName;
	
	CashSettlementMethodEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
