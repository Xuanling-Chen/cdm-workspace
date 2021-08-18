package cdm.base.staticdata.party.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.base.staticdata.party.Counterparty.CounterpartyBuilder;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(ExtractCounterpartyByRole.ExtractCounterpartyByRoleDefault.class)
public abstract class ExtractCounterpartyByRole implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param counterparties The list of counterparties to filter.
	* @param roleEnumToExtract The counterparty role enum to filter by.
	* @return counterparty The counterparty with specified counterparty role.
	*/
	public Counterparty evaluate(List<? extends Counterparty> counterparties, CounterpartyRoleEnum roleEnumToExtract) {
		
		Counterparty.CounterpartyBuilder counterpartyHolder = doEvaluate(counterparties, roleEnumToExtract);
		Counterparty.CounterpartyBuilder counterparty = assignOutput(counterpartyHolder, counterparties, roleEnumToExtract);
		
		if (counterparty!=null) objectValidator.validateAndFailOnErorr(Counterparty.class, counterparty);
		return counterparty;
	}
	
	private Counterparty.CounterpartyBuilder assignOutput(Counterparty.CounterpartyBuilder counterparty, List<? extends Counterparty> counterparties, CounterpartyRoleEnum roleEnumToExtract) {
		return counterparty;
	}

	protected abstract Counterparty.CounterpartyBuilder doEvaluate(List<? extends Counterparty> counterparties, CounterpartyRoleEnum roleEnumToExtract);
	
	public static final class ExtractCounterpartyByRoleDefault extends ExtractCounterpartyByRole {
		@Override
		protected  Counterparty.CounterpartyBuilder doEvaluate(List<? extends Counterparty> counterparties, CounterpartyRoleEnum roleEnumToExtract) {
			return Counterparty.builder();
		}
	}
}
