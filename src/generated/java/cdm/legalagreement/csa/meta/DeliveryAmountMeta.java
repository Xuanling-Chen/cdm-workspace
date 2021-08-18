package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.DeliveryAmount;
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
@RosettaMeta(model=DeliveryAmount.class)
public class DeliveryAmountMeta implements RosettaMetaData<DeliveryAmount> {

	@Override
	public List<Validator<? super DeliveryAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DeliveryAmount>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.DeliveryAmountOneOf0()
		);
	}
	
	@Override
	public List<Function<? super DeliveryAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeliveryAmount> validator() {
		return new cdm.legalagreement.csa.validation.DeliveryAmountValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliveryAmount, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.DeliveryAmountOnlyExistsValidator();
	}
}
