package cdm.product.template;


/**
 * The enumerated values to specify the type of the option. In FpML, OptionTypeEnum is a union with PutCallEnum, which specifies whether the option is a put or a call.
 * @version ${project.version}
 */
public enum OptionTypeEnum {
    

	/**
	 * A put option gives the holder the right to sell the underlying asset by a certain date for a certain price.
	 */
	PUT,
	    

	/**
	 * A call option gives the holder the right to buy the underlying asset by a certain date for a certain price.
	 */
	CALL,
	    

	/**
	 * A &#39;payer&#39; option: If you buy a &#39;payer&#39; option you have the right but not the obligation to enter into the underlying swap transaction as the &#39;fixed&#39; rate/price payer and receive float.
	 */
	PAYER,
	    

	/**
	 * A &#39;receiver&#39; option: If you buy a &#39;receiver&#39; option you have the right but not the obligation to enter into the underlying swap transaction as the &#39;fixed&#39; rate/price receiver and pay float.
	 */
	RECEIVER,
	    

	/**
	 * A straddle strategy, which involves the simultaneous buying of a put and a call of the same underlier, at the same strike and same expiration date
	 */
	STRADDLE    
	;

	private final String displayName;
	
	OptionTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
