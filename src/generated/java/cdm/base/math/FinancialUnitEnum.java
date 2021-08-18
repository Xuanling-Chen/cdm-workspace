package cdm.base.math;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * Provides enumerated values for financial units, generally used in the context of defining quantities for securities.
 * @version ${project.version}
 */
public enum FinancialUnitEnum {
    

	/**
	 * Denotes financial contracts, such as listed futures and options.
	 */
	CONTRACT,
	    

	/**
	 * Denotes a Contractual Product as defined in the CDM.  This unit type would be used when the price applies to the whole product, for example, in the case of a premium expressed as a cash amount.
	 */
	CONTRACTUAL_PRODUCT,
	    

	/**
	 * Denotes a price expressed in index points, e.g. for a stock index.
	 */
	INDEX_UNIT,
	    

	/**
	 * Denotes a log normal volatility, expressed in %/month, where the percentage is represented as a decimal. For example, 0.15 means a log-normal volatility of 15% per month.
	 */
	LOG_NORMAL_VOLATILITY,
	    

	/**
	 * Denotes the number of units of financial stock shares.
	 */
	@RosettaSynonym(value = "Share", source = "Workflow_Event")
	SHARE,
	    

	/**
	 * Denotes a value (expressed in currency units) for a one day change in a valuation date, which is typically used for expressing sensitivity to the passage of time, also known as theta risk, or carry, or other names.
	 */
	VALUE_PER_DAY,
	    

	/**
	 * Denotes a value (expressed in currency units) per percent change in the underlying rate which is typically used for expressing sensitivity to volatility changes, also known as vega risk.
	 */
	VALUE_PER_PERCENT    
	;

	private final String displayName;
	
	FinancialUnitEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
