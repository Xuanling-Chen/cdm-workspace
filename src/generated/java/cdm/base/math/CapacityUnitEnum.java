package cdm.base.math;


/**
 * Provides enumerated values for capacity units, generally used in the context of defining quantities for commodities.
 * @version ${project.version}
 */
public enum CapacityUnitEnum {
    

	/**
	 * Denotes a Barrel as a standard unit.
	 */
	BBL,
	    

	/**
	 * Denotes a Bushel as a standard unit of weight (48 lb or 21.7725 kg).
	 */
	BSH,
	    

	/**
	 * Denotes British Thermal Units as a standard unit.
	 */
	BTU,
	    

	/**
	 * Denotes Short hundredweight (100 lb) as a standard unit.
	 */
	CWT,
	    

	/**
	 * Denotes 10 grams as a standard unit used in precious metals contracts (e.g MCX).
	 */
	DAG,
	    

	/**
	 * Denotes a single day as a standard unit used in time charter trades.
	 */
	DAY,
	    

	/**
	 * Denotes Dry Metric Ton (Tonne) Units - Consists of a metric ton of mass excluding moisture.
	 */
	DMTU,
	    

	/**
	 * Denotes a Dekatherm as a standard unit.
	 */
	DTH,
	    

	/**
	 * Denotes a 40 ft. Equivalent Unit container as a standard unit.
	 */
	FEU,
	    

	/**
	 * Denotes a Gallon unit as a standard unit.
	 */
	GAL,
	    

	/**
	 * Denotes a Gigajoule as a standard unit.
	 */
	GJ,
	    

	/**
	 * Denotes a Gigawatt as a standard unit.
	 */
	GW,
	    

	/**
	 * Denotes a Gigawatt-hour as a standard unit.
	 */
	GWH,
	    

	/**
	 * Denotes a Hectolitre as a standard unit.
	 */
	HL,
	    

	/**
	 * Denotes an Ingot as a standard unit.
	 */
	INGOT,
	    

	/**
	 * Denotes a Kilogram as a standard unit.
	 */
	KG,
	    

	/**
	 * Denotes a Kilolitre as a standard unit.
	 */
	KL,
	    

	/**
	 * Denotes a Kilowatt as a standard unit.
	 */
	KW,
	    

	/**
	 * Denotes a Kilowatt-hour as a standard unit.
	 */
	KWH,
	    

	/**
	 * Denotes a Litre as a standard unit.
	 */
	L,
	    

	/**
	 * Denotes a Pound as a standard unit.
	 */
	LB,
	    

	/**
	 * Denotes a Thousand Barrels as a standard unit.
	 */
	MB,
	    

	/**
	 * Denotes a Thousand board feet, which are used in contracts on forestry underlyers as a standard unit.
	 */
	MBF,
	    

	/**
	 * Denotes a Megajoule as a standard unit.
	 */
	MJ,
	    

	/**
	 * Denotes a Million board feet, which are used in contracts on forestry underlyers as a standard unit.
	 */
	MMBF,
	    

	/**
	 * Denotes a Million British Thermal Units as a standard unit.
	 */
	MMBTU,
	    

	/**
	 * Denotes a Thousand square feet as a standard unit.
	 */
	MSF,
	    

	/**
	 * Denotes a Metric Ton as a standard unit.
	 */
	MT,
	    

	/**
	 * Denotes a Megawatt as a standard unit.
	 */
	MW,
	    

	/**
	 * Denotes a Megawatt-hour as a standard unit.
	 */
	MWH,
	    

	/**
	 * Denotes a Troy Ounce as a standard unit.
	 */
	OZT,
	    

	/**
	 * Denotes a Short Ton as a standard unit.
	 */
	ST,
	    

	/**
	 * Denotes a Long Ton as a standard unit.
	 */
	T,
	    

	/**
	 * Denotes a 20 ft. Equivalent Unit container as a standard unit.
	 */
	TEU,
	    

	/**
	 * Denotes a Thermal Unit as a standard unit.
	 */
	THERM    
	;

	private final String displayName;
	
	CapacityUnitEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
