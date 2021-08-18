package cdm.base.datetime;


/**
 * The enumeration values to specify a time period containing additional values such as Term.
 * @version ${project.version}
 */
public enum PeriodTimeEnum {
    

	/**
	 * Period measured in hours.
	 */
	HOUR,
	    

	/**
	 * Period measured in minutes.
	 */
	MINUTE,
	    

	/**
	 * Period measured in seconds.
	 */
	SECOND    
	;

	private final String displayName;
	
	PeriodTimeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
