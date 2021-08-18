package cdm.base.staticdata.party.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.base.staticdata.party.PartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_PartyRole.Create_PartyRoleDefault.class)
public abstract class Create_PartyRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param party 
	* @param role 
	* @return partyRole 
	*/
	public PartyRole evaluate(Party party, PartyRoleEnum role) {
		
		PartyRole.PartyRoleBuilder partyRoleHolder = doEvaluate(party, role);
		PartyRole.PartyRoleBuilder partyRole = assignOutput(partyRoleHolder, party, role);
		
		if (partyRole!=null) objectValidator.validateAndFailOnErorr(PartyRole.class, partyRole);
		return partyRole;
	}
	
	private PartyRole.PartyRoleBuilder assignOutput(PartyRole.PartyRoleBuilder partyRole, Party party, PartyRoleEnum role) {
		partyRole
			.setPartyReferenceValue(MapperS.of(party).get())
		;
		partyRole
			.setRole(MapperS.of(role).get())
		;
		return partyRole;
	}

	protected abstract PartyRole.PartyRoleBuilder doEvaluate(Party party, PartyRoleEnum role);
	
	public static final class Create_PartyRoleDefault extends Create_PartyRole {
		@Override
		protected  PartyRole.PartyRoleBuilder doEvaluate(Party party, PartyRoleEnum role) {
			return PartyRole.builder();
		}
	}
}
