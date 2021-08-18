package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum IndexTypeEnum {
    

	/**
	 */
	DEBT,
	    

	/**
	 */
	EQUITY,
	    

	/**
	 */
	COMMODITY    
	;

	private final String displayName;
	
	IndexTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
