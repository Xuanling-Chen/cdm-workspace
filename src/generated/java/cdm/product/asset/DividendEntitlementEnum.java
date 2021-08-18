package cdm.product.asset;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the date on which the receiver of the equity payout is entitled to the dividend.
 * @version ${project.version}
 */
public enum DividendEntitlementEnum {
    

	/**
	 * Dividend entitlement is on the dividend ex-date.
	 */
	EX_DATE,
	    

	/**
	 * Dividend entitlement is on the dividend record date.
	 */
	@RosettaSynonym(value = "RecordDate", source = "FIX_5_0_SP2")
	RECORD_DATE    
	;

	private final String displayName;
	
	DividendEntitlementEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
