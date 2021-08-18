package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum SupraNationalIssuerTypeEnum {
    

	/**
	 * International Financial Institution
	 */
	INTERNATIONAL_ORGANISATION,
	    

	/**
	 * Multilateral Bank or Multilateral Development Bank.
	 */
	MULTILATERAL_BANK    
	;

	private final String displayName;
	
	SupraNationalIssuerTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
