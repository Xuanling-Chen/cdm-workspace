package cdm.base.staticdata.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Counterparty.CounterpartyBuilder;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.Party;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_Counterparty.Create_CounterpartyDefault.class)
public abstract class Create_Counterparty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param party 
	* @param role 
	* @return counterparty 
	*/
	public Counterparty evaluate(Party party, CounterpartyRoleEnum role) {
		
		Counterparty.CounterpartyBuilder counterpartyHolder = doEvaluate(party, role);
		Counterparty.CounterpartyBuilder counterparty = assignOutput(counterpartyHolder, party, role);
		
		if (counterparty!=null) objectValidator.validateAndFailOnErorr(Counterparty.class, counterparty);
		return counterparty;
	}
	
	private Counterparty.CounterpartyBuilder assignOutput(Counterparty.CounterpartyBuilder counterparty, Party party, CounterpartyRoleEnum role) {
		counterparty
			.setPartyReferenceValue(MapperS.of(party).get())
		;
		counterparty
			.setRole(MapperS.of(role).get())
		;
		return counterparty;
	}

	protected abstract Counterparty.CounterpartyBuilder doEvaluate(Party party, CounterpartyRoleEnum role);
	
	public static final class Create_CounterpartyDefault extends Create_Counterparty {
		@Override
		protected  Counterparty.CounterpartyBuilder doEvaluate(Party party, CounterpartyRoleEnum role) {
			return Counterparty.builder();
		}
	}
}
