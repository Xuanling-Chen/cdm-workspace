package cdm.base.staticdata.party;


/**
 * The enumerated values to specify the type of telephone number, e.g. work vs. mobile.
 * @version ${project.version}
 */
public enum TelephoneTypeEnum {
    

	/**
	 * A number used primarily for work-related calls. Includes home office numbers used primarily for work purposes.
	 */
	WORK,
	    

	/**
	 * A number on a mobile telephone that is often or usually used for work-related calls. This type of number can be used for urgent work related business when a work number is not sufficient to contact the person or firm.
	 */
	MOBILE,
	    

	/**
	 * A number used primarily for work-related facsimile transmissions.
	 */
	FAX,
	    

	/**
	 * A number used primarily for non work-related calls. (Normally this type of number would be used only as an emergency backup number, not as a regular course of business).
	 */
	PERSONAL    
	;

	private final String displayName;
	
	TelephoneTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
