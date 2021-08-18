package cdm.base.staticdata.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.Party.PartyBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ReplaceParty.ReplacePartyDefault.class)
public abstract class ReplaceParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param parties Specifies the list of parties to update.
	* @param oldParty Specifies the party to be removed.
	* @param newParty Specifies the party to be added.
	* @return updatedParties The updated list of parties.
	*/
	public List<? extends Party> evaluate(List<? extends Party> parties, Party oldParty, Party newParty) {
		
		List<Party.PartyBuilder> updatedPartiesHolder = doEvaluate(parties, oldParty, newParty);
		List<Party.PartyBuilder> updatedParties = assignOutput(updatedPartiesHolder, parties, oldParty, newParty);
		
		if (updatedParties!=null) objectValidator.validateAndFailOnErorr(Party.class, updatedParties);
		return updatedParties;
	}
	
	private List<Party.PartyBuilder> assignOutput(List<Party.PartyBuilder> updatedParties, List<? extends Party> parties, Party oldParty, Party newParty) {
		return updatedParties;
	}

	protected abstract List<Party.PartyBuilder> doEvaluate(List<? extends Party> parties, Party oldParty, Party newParty);
	
	public static final class ReplacePartyDefault extends ReplaceParty {
		@Override
		protected  List<Party.PartyBuilder> doEvaluate(List<? extends Party> parties, Party oldParty, Party newParty) {
			return Arrays.asList();
		}
	}
}
