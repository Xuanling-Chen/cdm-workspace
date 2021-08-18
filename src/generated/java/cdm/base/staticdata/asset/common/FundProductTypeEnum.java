package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum FundProductTypeEnum {
    

	/**
	 * Denotes a fund that invests only in highly liquid near-term instruments such as cash, cash equivalent securities, and high credit rating debt instruments with a short-term maturity.
	 */
	MONEY_MARKET_FUND,
	    

	/**
	 * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is passively managed and traded on a stock exchange.
	 */
	EXCHANGE_TRADED_FUND,
	    

	/**
	 * Denotes an investment fund consisting of stocks, bonds, and/or other assets that is actively managed and can only be purchased or sold through the investment manager.
	 */
	MUTUAL_FUND,
	    

	/**
	 * Denotes a fund that is not an Exchange Traded Fund or a Money Market Fund.
	 */
	OTHER_FUND    
	;

	private final String displayName;
	
	FundProductTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
