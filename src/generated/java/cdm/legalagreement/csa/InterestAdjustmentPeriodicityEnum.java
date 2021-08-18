package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the interest adjustment periodicity election through standard language. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii). 
 * @version ${project.version}
 */
public enum InterestAdjustmentPeriodicityEnum {
    

	/**
	 * The interest adjustment takes place on the last local business day of each calendar month
	 */
	@RosettaSynonym(value = "last_day", source = "ISDA_Create_1_0")
	LAST_LOCAL_BUSINESS_DAY_OF_MONTH,
	    

	/**
	 * The interest adjustment takes place each day.
	 */
	@RosettaSynonym(value = "each_day", source = "ISDA_Create_1_0")
	EACH_DAY    
	;

	private final String displayName;
	
	InterestAdjustmentPeriodicityEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
