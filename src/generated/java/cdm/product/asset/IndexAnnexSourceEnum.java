package cdm.product.asset;


/**
 * The enumerated values to specify the CDX index annex source.
 * @version ${project.version}
 */
public enum IndexAnnexSourceEnum {
    

	/**
	 * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
	 */
	MASTER_CONFIRMATION,
	    

	/**
	 * As defined in the relevant form of Master Confirmation applicable to the confirmation of Dow Jones CDX indices.
	 */
	PUBLISHER    
	;

	private final String displayName;
	
	IndexAnnexSourceEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
