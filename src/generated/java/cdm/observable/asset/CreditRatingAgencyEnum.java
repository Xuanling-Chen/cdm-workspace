package cdm.observable.asset;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the rating agencies.
 * @version ${project.version}
 */
public enum CreditRatingAgencyEnum {
    

	/**
	 * A. M. Best
	 */
	AM_BEST,
	    

	/**
	 * Canadian Bond Rating Service
	 */
	CBRS,
	    

	/**
	 * A composite rating determined by the average risk profile of Agency ratings.
	 */
	COMPOSITE,
	    

	/**
	 * Dominion Bond Rating Service
	 */
	@RosettaSynonym(value = "DBRS", source = "AcadiaSoft_AM_1_0")
	DBRS,
	    

	/**
	 * Fitch
	 */
	@RosettaSynonym(value = "FITCH", source = "AcadiaSoft_AM_1_0")
	FITCH,
	    

	/**
	 * Japan Credit Rating Agency, Ltd.
	 */
	JAPAN_AGENCY,
	    

	/**
	 * Moody&#39;s
	 */
	@RosettaSynonym(value = "MOODYS", source = "AcadiaSoft_AM_1_0")
	MOODYS,
	    

	/**
	 * Rating And Investment Information, Inc.
	 */
	RATING_AND_INVESTMENT_INFORMATION,
	    

	/**
	 * Standard And Poor&#39;s
	 */
	@RosettaSynonym(value = "STANDARD_POORS", source = "AcadiaSoft_AM_1_0")
	STANDARD_AND_POORS    
	;

	private final String displayName;
	
	CreditRatingAgencyEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
