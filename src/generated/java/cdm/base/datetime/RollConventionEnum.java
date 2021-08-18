package cdm.base.datetime;


/**
 * The enumerated values to specify the period term as part of a periodic schedule, i.e. the calculation period end date within the regular part of the calculation period. The value could be a rule, e.g. IMM Settlement Dates, which is the 3rd Wednesday of the month, or it could be a specific day of the month, such as the first day of the applicable month.
 * @version ${project.version}
 */
public enum RollConventionEnum {
    

	/**
	 * Rolls on month end dates irrespective of the length of the month and the previous roll day.
	 */
	EOM,
	    

	/**
	 * Roll days are determined according to the FRN Convention or Euro-dollar Convention as described in ISDA 2000 definitions.
	 */
	FRN,
	    

	/**
	 * IMM Settlement Dates. The third Wednesday of the (delivery) month.
	 */
	IMM,
	    

	/**
	 * The last trading day/expiration day of the Canadian Derivatives Exchange (Bourse de Montreal Inc) Three-month Canadian Bankers&#39; Acceptance Futures (Ticker Symbol BAX). The second London banking day prior to the third Wednesday of the contract month. If the determined day is a Bourse or bank holiday in Montreal or Toronto, the last trading day shall be the previous bank business day. Per Canadian Derivatives Exchange BAX contract specification.
	 */
	IMMCAD,
	    

	/**
	 * The last trading day of the Sydney Futures Exchange 90 Day Bank Accepted Bills Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). One Sydney business day preceding the second Friday of the relevant settlement.
	 */
	IMMAUD,
	    

	/**
	 * The last trading day of the Sydney Futures Exchange NZ 90 Day Bank Bill Futures contract (see http://www.sfe.com.au/content/sfe/trading/con_specs.pdf). The first Wednesday after the ninth day of the relevant settlement month.
	 */
	IMMNZD,
	    

	/**
	 * Sydney Futures Exchange 90-Day Bank Accepted Bill Futures Settlement Dates. The second Friday of the (delivery) month
	 */
	SFE,
	    

	/**
	 * The roll convention is not required. For example, in the case of a daily calculation frequency.
	 */
	NONE,
	    

	/**
	 * 13-week and 26-week U.S. Treasury Bill Auction Dates. Each Monday except for U.S. (New York) holidays when it will occur on a Tuesday.
	 */
	TBILL,
	    

	/**
	 * Rolls on the 1st day of the month.
	 */
	_1("1"),
	

	/**
	 * Rolls on the 2nd day of the month.
	 */
	_2("2"),
	

	/**
	 * Rolls on the 3rd day of the month.
	 */
	_3("3"),
	

	/**
	 * Rolls on the 4th day of the month.
	 */
	_4("4"),
	

	/**
	 * Rolls on the 5th day of the month.
	 */
	_5("5"),
	

	/**
	 * Rolls on the 6th day of the month.
	 */
	_6("6"),
	

	/**
	 * Rolls on the 7th day of the month.
	 */
	_7("7"),
	

	/**
	 * Rolls on the 8th day of the month.
	 */
	_8("8"),
	

	/**
	 * Rolls on the 9th day of the month.
	 */
	_9("9"),
	

	/**
	 * Rolls on the 10th day of the month.
	 */
	_10("10"),
	

	/**
	 * Rolls on the 11th day of the month.
	 */
	_11("11"),
	

	/**
	 * Rolls on the 12th day of the month.
	 */
	_12("12"),
	

	/**
	 * Rolls on the 13th day of the month.
	 */
	_13("13"),
	

	/**
	 * Rolls on the 14th day of the month.
	 */
	_14("14"),
	

	/**
	 * Rolls on the 15th day of the month.
	 */
	_15("15"),
	

	/**
	 * Rolls on the 16th day of the month.
	 */
	_16("16"),
	

	/**
	 * Rolls on the 17th day of the month.
	 */
	_17("17"),
	

	/**
	 * Rolls on the 18th day of the month.
	 */
	_18("18"),
	

	/**
	 * Rolls on the 19th day of the month.
	 */
	_19("19"),
	

	/**
	 * Rolls on the 20th day of the month.
	 */
	_20("20"),
	

	/**
	 * Rolls on the 21st day of the month.
	 */
	_21("21"),
	

	/**
	 * Rolls on the 22nd day of the month.
	 */
	_22("22"),
	

	/**
	 * Rolls on the 23rd day of the month.
	 */
	_23("23"),
	

	/**
	 * Rolls on the 24th day of the month.
	 */
	_24("24"),
	

	/**
	 * Rolls on the 25th day of the month.
	 */
	_25("25"),
	

	/**
	 * Rolls on the 26th day of the month.
	 */
	_26("26"),
	

	/**
	 * Rolls on the 27th day of the month.
	 */
	_27("27"),
	

	/**
	 * Rolls on the 28th day of the month.
	 */
	_28("28"),
	

	/**
	 * Rolls on the 29th day of the month.
	 */
	_29("29"),
	

	/**
	 * Rolls on the 30th day of the month.
	 */
	_30("30"),
	

	/**
	 * Rolling weekly on a Monday.
	 */
	MON,
	    

	/**
	 * Rolling weekly on a Tuesday
	 */
	TUE,
	    

	/**
	 * Rolling weekly on a Wednesday
	 */
	WED,
	    

	/**
	 * Rolling weekly on a Thursday
	 */
	THU,
	    

	/**
	 * Rolling weekly on a Friday
	 */
	FRI,
	    

	/**
	 * Rolling weekly on a Saturday
	 */
	SAT,
	    

	/**
	 * Rolling weekly on a Sunday
	 */
	SUN    
	;

	private final String displayName;
	
	RollConventionEnum() {
		this.displayName = null;
	}

	RollConventionEnum(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
