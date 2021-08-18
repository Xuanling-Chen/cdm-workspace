package cdm.legalagreement.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the legal agreement publisher.
 * @version ${project.version}
 */
public enum LegalAgreementPublisherEnum {
    

	/**
	 * Association Française des Banques.
	 */
	AFB,
	    

	/**
	 * BNY Mellon
	 */
	BNYM,
	    

	/**
	 * ISDA and Clearstream
	 */
	@RosettaSynonym(value = "ISDA/Clearstream", source = "ISDA_Create_1_0")
	ISDA_CLEARSTREAM,
	    

	/**
	 * ISDA and Euroclear
	 */
	@RosettaSynonym(value = "ISDA/Euroclear", source = "ISDA_Create_1_0")
	ISDA_EUROCLEAR,
	    

	/**
	 * International Swaps and Derivatives Association, Inc.
	 */
	@RosettaSynonym(value = "ISDA", source = "AcadiaSoft_AM_1_0")
	@RosettaSynonym(value = "ISDA", source = "ISDA_Create_1_0")
	ISDA,
	    

	/**
	 * International Securities Lending Association
	 */
	ISLA,
	    

	/**
	 * JP Morgan
	 */
	JP_MORGAN    
	;

	private final String displayName;
	
	LegalAgreementPublisherEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
