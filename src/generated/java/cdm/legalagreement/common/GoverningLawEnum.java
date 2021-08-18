package cdm.legalagreement.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the law governing the contract or legal document.
 * @version ${project.version}
 */
public enum GoverningLawEnum {
    

	/**
	 * The Governing Law is determined by reference to the relevant master agreement.
	 */
	AS_SPECIFIED_IN_MASTER_AGREEMENT,
	    

	/**
	 * Belgian law
	 */
	@RosettaSynonym(value = "Belgian", source = "ISDA_Create_1_0")
	BE,
	    

	/**
	 * Alberta law
	 */
	CAAB,
	    

	/**
	 * British Columbia Law
	 */
	CABC,
	    

	/**
	 * Manitoba law
	 */
	CAMN,
	    

	/**
	 * Ontario law
	 */
	CAON,
	    

	/**
	 * Quebec law
	 */
	CAQC,
	    

	/**
	 * German law
	 */
	DE,
	    

	/**
	 * French law
	 */
	FR,
	    

	/**
	 * English law
	 */
	@RosettaSynonym(value = "ENGLISH", source = "AcadiaSoft_AM_1_0")
	@RosettaSynonym(value = "English", source = "ISDA_Create_1_0")
	GBEN,
	    

	/**
	 * The law of the island of Guernsey
	 */
	GBGY,
	    

	/**
	 * The law of the Isle of Man
	 */
	GBIM,
	    

	/**
	 * The law of the island of Jersey
	 */
	GBJY,
	    

	/**
	 * Scottish law
	 */
	GBSC,
	    

	/**
	 * Irish law
	 */
	IE,
	    

	/**
	 * Japanese law
	 */
	@RosettaSynonym(value = "JAPAN", source = "AcadiaSoft_AM_1_0")
	@RosettaSynonym(value = "Japanese", source = "ISDA_Create_1_0")
	JP,
	    

	/**
	 * Luxembourg law
	 */
	@RosettaSynonym(value = "Luxembourg", source = "ISDA_Create_1_0")
	LU,
	    

	/**
	 * As agreed in the ISDA Master Agreement
	 */
	@RosettaSynonym(value = "As agreed in the ISDA Master Agreement", source = "ISDA_Create_1_0")
	RELATED_MASTER_AGREEMENT,
	    

	/**
	 * Californian law
	 */
	USCA,
	    

	/**
	 * Delaware law
	 */
	USDE,
	    

	/**
	 * Illinois law
	 */
	USIL,
	    

	/**
	 * New York law
	 */
	@RosettaSynonym(value = "NY", source = "AcadiaSoft_AM_1_0")
	@RosettaSynonym(value = "New York", source = "ISDA_Create_1_0")
	USNY    
	;

	private final String displayName;
	
	GoverningLawEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
