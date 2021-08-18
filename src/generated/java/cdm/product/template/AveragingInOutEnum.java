package cdm.product.template;


/**
 * The enumerated values to specify the type of averaging used in an Asian option.
 * @version ${project.version}
 */
public enum AveragingInOutEnum {
    

	/**
	 * The average price is used to derive the strike price. Also known as &#39;Asian strike&#39; style option.
	 */
	IN,
	    

	/**
	 * The average price is used to derive the expiration price. Also known as &#39;Asian price&#39; style option.
	 */
	OUT,
	    

	/**
	 * The average price is used to derive both the strike and the expiration price.
	 */
	BOTH    
	;

	private final String displayName;
	
	AveragingInOutEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
