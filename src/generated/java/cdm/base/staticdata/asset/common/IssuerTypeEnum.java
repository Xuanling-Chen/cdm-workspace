package cdm.base.staticdata.asset.common;


/**
 * @version ${project.version}
 */
public enum IssuerTypeEnum {
    

	/**
	 * Debt issued by international organisations and multilateral banks, entities constituted by treaties or with multiple sovereign members includes Multilateral development Banks
	 */
	SUPRA_NATIONAL,
	    

	/**
	 * Sovereign, Government Debt Securities including Central Banks
	 */
	SOVEREIGN_CENTRAL_BANK,
	    

	/**
	 * Debt issues by institutions or bodies, typically constituted by statute, with a function mandated by the government and subject to government supervision inclusive of profit- and non-profit making bodies. Includes the US Agencies and GSEs and the EU concept of public sector entities. Excluding any entities which are also Regional Government.
	 */
	QUASI_GOVERNMENT,
	    

	/**
	 * Regional Government Issued Debt including states within countries, local authorities and municipalities.
	 */
	REGIONAL_GOVERNMENT,
	    

	/**
	 * Debt issued Securities by corporate bodies including Banks
	 */
	CORPORATE,
	    

	/**
	 * A vehicle (with or without separate legal personality) designed for the purposes of collective investment towards a defined investment goal.
	 */
	FUND,
	    

	/**
	 * A vehicle setup for the purpose of acquisition and financing of specific assets on a limited recourse basis. E.g. asset backed securities, including securitisations
	 */
	SPECIAL_PURPOSE_VEHICLE    
	;

	private final String displayName;
	
	IssuerTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
