package cdm.base.staticdata.party.meta;

import cdm.base.staticdata.party.PayerReceiver;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=PayerReceiver.class)
public class PayerReceiverMeta implements RosettaMetaData<PayerReceiver> {

	@Override
	public List<Validator<? super PayerReceiver>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.staticdata.party.validation.datarule.PayerReceiverCashflowPayerAncillaryRole.class),
			factory.create(cdm.base.staticdata.party.validation.datarule.PayerReceiverCashflowReceiverAncillaryRole.class)
		);
	}

	@Override
	public List<Validator<? super PayerReceiver>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.party.validation.choicerule.PayerReceiverPayerCounterpartyOrAncillaryRoleOrPartyReference(),
			new cdm.base.staticdata.party.validation.choicerule.PayerReceiverReceiverCounterpartyOrAncillaryRoleOrPartyReference()
		);
	}
	
	@Override
	public List<Function<? super PayerReceiver, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PayerReceiver> validator() {
		return new cdm.base.staticdata.party.validation.PayerReceiverValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PayerReceiver, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.party.validation.exists.PayerReceiverOnlyExistsValidator();
	}
}
