package cdm.legalagreement.csa;

import com.rosetta.model.lib.annotations.RosettaSynonym;

/**
 * The enumerated values to specify the margin approach specific to Initial Margin agreements.
 * @version ${project.version}
 */
public enum MarginApproachEnum {
    

	/**
	 * (A) If the &#39;Distinct Margin Flow (IM) Approach&#39; is specified as applicable in Paragraph 13, the following provisions will apply: (1) &#39;Credit Support Amount (IM)&#39; means, with respect to a party as the Pledgor, for any Calculation Date (IM), (i) the Margin Amount (IM) applicable to the Pledgor, if any, minus (ii) the Pledgor’s Threshold (IM); provided, however, that the Credit Support Amount (IM) will be deemed to be zero whenever the calculation of the Credit Support Amount (IM) yields a number less than zero. (2) No Amendment to Obligations in respect of Margin Amount (IA). The posting obligation of a Pledgor in respect of any amount that constitutes a Margin Amount (IA) under any Other CSA shall not be affected or amended in any way by the provisions of this Annex.
	 */
	@RosettaSynonym(value = "distinct", source = "ISDA_Create_1_0")
	DISTINCT,
	    

	/**
	 * (B) If the &#39;Allocated Margin Flow (IM/IA) Approach&#39; is specified as applicable in Paragraph 13, the following provisions will apply: (1) &#39;Credit Support Amount (IM)&#39; means, with respect to a party as the Pledgor, for any Calculation Date (IM), (i) the Margin Amount (IM) applicable to the Pledgor, if any, minus (ii) the Pledgor’s Threshold (IM); provided, however, that the Credit Support Amount (IM) will be deemed to be zero whenever the calculation of the Credit Support Amount (IM) yields a number less than zero. (2) Amendment to Obligations in respect of Margin Amount (IA). The posting obligation of a Pledgor in respect of any amount that constitutes a Margin Amount (IA) under any Other CSA shall be reduced on an aggregate basis by the amount of the Pledgor’s Credit Support Amount (IM); provided, however, that if, after such reduction, any such Margin Amount (IA) would be a negative amount, such Margin Amount (IA) will be deemed to be zero.
	 */
	@RosettaSynonym(value = "allocated", source = "ISDA_Create_1_0")
	ALLOCATED,
	    

	/**
	 * (C) If the &#39;Greater of Margin Flow (IM/IA) Approach&#39; is specified as applicable in Paragraph 13, the following provisions will apply: (1) &#39;Credit Support Amount (IM)&#39; means, with respect to a party as the Pledgor, for any Calculation Date (IM), the greater of (i)(A) the Margin Amount (IM) applicable to the Pledgor, if any, minus (B) the Pledgor’s Threshold (IM) and (ii) the Margin Amount (IA); provided, however, that the Credit Support Amount (IM) will be deemed to be zero whenever the calculation of the Credit Support Amount (IM) yields a number less than zero. (2) Amendment to Obligations in respect of Margin Amount (IA).  The posting obligation of a Pledgor in respect of any amount that constitutes a Margin Amount (IA) under any Other CSA, other than such obligations of a Pledgor under this Annex, shall be reduced to zero.
	 */
	@RosettaSynonym(value = "greaterof", source = "ISDA_Create_1_0")
	@RosettaSynonym(value = "greater_of", source = "ISDA_Create_1_0")
	GREATER_OF    
	;

	private final String displayName;
	
	MarginApproachEnum() {
		this.displayName = null;
	}


	@Override
	public String toString() {
		return displayName != null ?  displayName : name();
	}
	
}
