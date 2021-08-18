package cdm.event.workflow;


/**
 * @version ${project.version}
 */
public enum WarehouseIdentityEnum {
    

	/**
	 * The DTCC Trade Information Warehouse Gold service
	 */
	DTCC_TIW_GOLD    
	;

	private final String displayName;
	
	WarehouseIdentityEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
