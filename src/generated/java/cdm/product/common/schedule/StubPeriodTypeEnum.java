package cdm.product.common.schedule;


/**
 * The enumerated values to specify how to deal with a non standard calculation period within a swap stream.
 * @version ${project.version}
 */
public enum StubPeriodTypeEnum {
    

	/**
	 * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the start of the stream.
	 */
	SHORT_INITIAL,
	    

	/**
	 * If there is a non regular period remaining it is left shorter than the streams calculation period frequency and placed at the end of the stream.
	 */
	SHORT_FINAL,
	    

	/**
	 * If there is a non regular period remaining it is placed at the start of the stream and combined with the adjacent calculation period to give a long first calculation period.
	 */
	LONG_INITIAL,
	    

	/**
	 * If there is a non regular period remaining it is placed at the end of the stream and combined with the adjacent calculation period to give a long last calculation period.
	 */
	LONG_FINAL    
	;

	private final String displayName;
	
	StubPeriodTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
