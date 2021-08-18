package cdm.base.staticdata.party.functions;

import cdm.base.staticdata.party.PartyRole;
import cdm.base.staticdata.party.PartyRole.PartyRoleBuilder;
import cdm.base.staticdata.party.PartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(FilterPartyRole.FilterPartyRoleDefault.class)
public abstract class FilterPartyRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param partyRoles 
	* @param partyRoleEnum 
	* @return partyRole 
	*/
	public List<? extends PartyRole> evaluate(List<? extends PartyRole> partyRoles, PartyRoleEnum partyRoleEnum) {
		
		List<PartyRole.PartyRoleBuilder> partyRoleHolder = doEvaluate(partyRoles, partyRoleEnum);
		List<PartyRole.PartyRoleBuilder> partyRole = assignOutput(partyRoleHolder, partyRoles, partyRoleEnum);
		
		if (partyRole!=null) objectValidator.validateAndFailOnErorr(PartyRole.class, partyRole);
		return partyRole;
	}
	
	private List<PartyRole.PartyRoleBuilder> assignOutput(List<PartyRole.PartyRoleBuilder> partyRole, List<? extends PartyRole> partyRoles, PartyRoleEnum partyRoleEnum) {
		return partyRole;
	}

	protected abstract List<PartyRole.PartyRoleBuilder> doEvaluate(List<? extends PartyRole> partyRoles, PartyRoleEnum partyRoleEnum);
	
	public static final class FilterPartyRoleDefault extends FilterPartyRole {
		@Override
		protected  List<PartyRole.PartyRoleBuilder> doEvaluate(List<? extends PartyRole> partyRoles, PartyRoleEnum partyRoleEnum) {
			return Arrays.asList();
		}
	}
}
