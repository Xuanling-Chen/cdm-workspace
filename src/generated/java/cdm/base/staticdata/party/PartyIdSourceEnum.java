package cdm.base.staticdata.party;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumeration values associated with party identifier sources.
 * @version ${project.version}
 */
public enum PartyIdSourceEnum {
    

	/**
	 * The Bank Identifier Code.
	 */
	BIC,
	    

	/**
	 * The ISO 17442:2012 Legal Entity Identifier.
	 */
	@RosettaSynonym(value = "LEI", source = "Workflow_Event")
	LEI,
	    

	/**
	 * Alien Registration Number, number assigned by a social security agency to identify a non-resident person.
	 */
	@RosettaSynonym(value = "ARNU", source = "ISO20022")
	ARNU,
	    

	/**
	 * Passport Number, number assigned by an authority to identify the passport number of a person.
	 */
	@RosettaSynonym(value = "CCPT", source = "ISO20022")
	CCPT,
	    

	/**
	 * Customer Identification Number, number assigned by an issuer to identify a customer.
	 */
	@RosettaSynonym(value = "CUST", source = "ISO20022")
	CUST,
	    

	/**
	 * Drivers License Number, number assigned by an authority to identify a driver&#39;s license.
	 */
	@RosettaSynonym(value = "DRLC", source = "ISO20022")
	DRLC,
	    

	/**
	 * Employee Identification Number, number assigned by a registration authority to an employee.
	 */
	@RosettaSynonym(value = "EMPL", source = "ISO20022")
	EMPL,
	    

	/**
	 * National Identity Number, number assigned by an authority to identify the national identity number of a person..
	 */
	@RosettaSynonym(value = "NIDN", source = "ISO20022")
	NIDN,
	    

	/**
	 * Social Security Number, number assigned by an authority to identify the social security number of a person.
	 */
	@RosettaSynonym(value = "SOSE", source = "ISO20022")
	SOSE,
	    

	/**
	 * Tax Identification Number, number assigned by a tax authority to identify a person.
	 */
	@RosettaSynonym(value = "TXID", source = "ISO20022")
	TXID    
	;

	private final String displayName;
	
	PartyIdSourceEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
