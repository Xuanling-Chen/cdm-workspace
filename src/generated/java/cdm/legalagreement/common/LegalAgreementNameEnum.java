package cdm.legalagreement.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the legal agreement name.
 * @version ${project.version}
 */
public enum LegalAgreementNameEnum {
    

	/**
	 * A Credit Support Deed legal agreement.
	 */
	@RosettaSynonym(value = "Credit Support Deed", source = "ISDA_Create_1_0")
	CREDIT_SUPPORT_DEED,
	    

	/**
	 * A Credit Support Annex legal agreement.
	 */
	@RosettaSynonym(value = "CSA", source = "AcadiaSoft_AM_1_0")
	@RosettaSynonym(value = "Credit Support Annex", source = "ISDA_Create_1_0")
	CREDIT_SUPPORT_ANNEX,
	    

	/**
	 * A Collateral Transfer Agreement
	 */
	@RosettaSynonym(value = "Collateral Transfer Agreement", source = "ISDA_Create_1_0")
	COLLATERAL_TRANSFER_AGREEMENT,
	    

	/**
	 * Global Master Securities Lending Agreement
	 */
	GMSLA,
	    

	/**
	 * A Master Agreement.
	 */
	MASTER_AGREEMENT,
	    

	/**
	 * A Security Agreement.
	 */
	@RosettaSynonym(value = "Security Agreement", source = "ISDA_Create_1_0")
	SECURITY_AGREEMENT    
	;

	private final String displayName;
	
	LegalAgreementNameEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
