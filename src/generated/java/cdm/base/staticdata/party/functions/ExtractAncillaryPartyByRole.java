package cdm.base.staticdata.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.AncillaryParty.AncillaryPartyBuilder;
import cdm.base.staticdata.party.AncillaryRoleEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ExtractAncillaryPartyByRole.ExtractAncillaryPartyByRoleDefault.class)
public abstract class ExtractAncillaryPartyByRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param ancillaryParties The list of ancillary parties to filter.
	* @param roleEnumToExtract The ancillary role enum to filter by.
	* @return ancillaryParty The ancillary party with specified ancillary role.
	*/
	public AncillaryParty evaluate(List<? extends AncillaryParty> ancillaryParties, AncillaryRoleEnum roleEnumToExtract) {
		
		AncillaryParty.AncillaryPartyBuilder ancillaryPartyHolder = doEvaluate(ancillaryParties, roleEnumToExtract);
		AncillaryParty.AncillaryPartyBuilder ancillaryParty = assignOutput(ancillaryPartyHolder, ancillaryParties, roleEnumToExtract);
		
		if (ancillaryParty!=null) objectValidator.validateAndFailOnErorr(AncillaryParty.class, ancillaryParty);
		return ancillaryParty;
	}
	
	private AncillaryParty.AncillaryPartyBuilder assignOutput(AncillaryParty.AncillaryPartyBuilder ancillaryParty, List<? extends AncillaryParty> ancillaryParties, AncillaryRoleEnum roleEnumToExtract) {
		return ancillaryParty;
	}

	protected abstract AncillaryParty.AncillaryPartyBuilder doEvaluate(List<? extends AncillaryParty> ancillaryParties, AncillaryRoleEnum roleEnumToExtract);
	
	public static final class ExtractAncillaryPartyByRoleDefault extends ExtractAncillaryPartyByRole {
		@Override
		protected  AncillaryParty.AncillaryPartyBuilder doEvaluate(List<? extends AncillaryParty> ancillaryParties, AncillaryRoleEnum roleEnumToExtract) {
			return AncillaryParty.builder();
		}
	}
}
