package cdm.observable.asset;


/**
 * How is the Creadit Support Annex defined for this transaction as defined in the 2021 ISDA Definitions, section 18.2.1 
 * @version ${project.version}
 */
public enum CsaTypeEnum {
    

	/**
	 * There is no CSA applicable
	 */
	NO_CSA("NoCSA"),
	

	/**
	 * Thre is an existing Credit Support Annex
	 */
	EXISTING_CSA("ExistingCSA"),
	

	/**
	 * There is a bilateral Credit Support Annex specific to the transaction
	 */
	REFERENCE_VMCSA("ReferenceVMCSA")
	;

	private final String displayName;
	
	CsaTypeEnum() {
		this.displayName = null;
	}

	CsaTypeEnum(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
