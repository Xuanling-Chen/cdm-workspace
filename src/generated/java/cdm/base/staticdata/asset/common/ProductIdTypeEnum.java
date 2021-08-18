package cdm.base.staticdata.asset.common;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * Provides the enumerated values to specify the product identifier source.
 * @version ${project.version}
 */
public enum ProductIdTypeEnum {
    

	/**
	 * Published by Bloomberg, the BBGID is a 12-digit alphanumeric randomly generated ID covering active and non-active securities.
	 */
	@RosettaSynonym(value = "BBGID", source = "Workflow_Event")
	BBGID,
	    

	/**
	 * Published by Bloomberg as a short code to identify publicly trades shares of a particular stock on a specific exchange.
	 */
	@RosettaSynonym(value = "BBGTICKER", source = "Workflow_Event")
	BBGTICKER,
	    

	/**
	 * Derived from the Committee on Uniform Security Identification Procedures, CUSIPs are 9-character identifiers that capture an issue’s important differentiating characteristics for issuers and their financial instruments in the U.S. and Canada.
	 */
	@RosettaSynonym(value = "CUSIP", source = "Workflow_Event")
	CUSIP,
	    

	/**
	 * Issued under the guidelines of the Object Management Group, the Financial Instrument Global Identifier (FIGI) is a 12 character, alphanumeric, randomly generated ID covering hundreds of millions of active and inactive instruments. The identifier acts as a Uniform Resource Identifier (URI) to link to a set of metadata that uniquely and clearly describes the instrument.
	 */
	@RosettaSynonym(value = "FIGI", source = "Workflow_Event")
	FIGI,
	    

	/**
	 * Issued by the International Swaps Dealers Association as a string representing a Commodity Reference Price used for purposes of determining a relevant price for an underlying commodity in an OTC derivatives contract.
	 */
	ISDACRP,
	    

	/**
	 * Issued by The International Securities Identification Number (ISIN) Organization, the ISIN is a 12-character alpha-numerical code used to uniformly identify a security for trading and settlement purposes. Securities with which ISINs can be used include debt securities, such as notes or bonds as well shares, such as common stock or shares of a fund, options, derivatives, and futures. The ISIN structure is defined in ISO 6166.
	 */
	@RosettaSynonym(value = "ISIN", source = "Workflow_Event")
	ISIN,
	    

	/**
	 * Issued by Refinitiv (formerly Reuters), the Reuters Instrument Codes(RIC) uniquely identifies financial instruments, including where they are traded.
	 */
	@RosettaSynonym(value = "RIC", source = "Workflow_Event")
	RIC,
	    

	/**
	 * Used when the source is not otherwise in this enumerated list because it is internal or other reasons.  The source can be identified in the scheme which is part of the identifier attribute.
	 */
	@RosettaSynonym(value = "Other", source = "Workflow_Event")
	OTHER,
	    

	/**
	 * Issued by the French Société Interprofessionnelle pour la Compensation des Valeurs Mobilières (SICOVAM) to identify French securities listed on French stock exchanges.
	 */
	@RosettaSynonym(value = "Sicovam", source = "Workflow_Event")
	SICOVAM,
	    

	/**
	 * Assigned by the London Stock Exchange, the Stock Exchange Daily Official List (SEDOL) is a list of security identifiers used in the United Kingdom and Ireland for clearing purposes.  SEDOLs serve as the National Securities Identifying Number for all securities issued in the United Kingdom and are therefore part of the security&#39;s ISIN as well.
	 */
	@RosettaSynonym(value = "SEDOL", source = "Workflow_Event")
	SEDOL,
	    

	/**
	 * Assigned by the Derivatives Service Bureau Ltd (DSB), the Unique Product Identifier (UPI) is a unique code to describe an over-the-counter (OTC) derivatives product.  The UPI is used for identifying the product in transaction reporting data.
	 */
	@RosettaSynonym(value = "UPI", source = "Workflow_Event")
	UPI,
	    

	/**
	 * Issued by the Institute for the Issuance and Administration of Securities in Germany (Securities Information), the Wertpapierkennnummer (WKN, WPKN, WPK or simply Wert) consists of six digits or capital letters (excluding I and O), and no check digit. It is used to identify German securities.
	 */
	@RosettaSynonym(value = "Wertpapier", source = "Workflow_Event")
	WERTPAPIER    
	;

	private final String displayName;
	
	ProductIdTypeEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
