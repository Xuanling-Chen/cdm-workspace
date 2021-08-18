package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the application of Interest Amount with respect to the Delivery Amount through standard language. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
 * @version ${project.version}
 */
public enum DeliveryAmountElectionEnum {
    

	/**
	 * The delivery only includes `Transfer on last Local Business Day`. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
	 */
	@RosettaSynonym(value = "include_one", source = "ISDA_Create_1_0")
	LAST_LOCAL_BUSINESS_DAY,
	    

	/**
	 * The delivery includes both `Transfer on last Local Business Day` and `Transfer a Delivery Amount (IM) consisting of cash on any Local Business Day.`
	 */
	@RosettaSynonym(value = "include_both", source = "ISDA_Create_1_0")
	LAST_AND_ANY_LOCAL_BUSINESS_DAY    
	;

	private final String displayName;
	
	DeliveryAmountElectionEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
