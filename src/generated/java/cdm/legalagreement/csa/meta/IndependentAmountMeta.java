package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.IndependentAmount;
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
@RosettaMeta(model=IndependentAmount.class)
public class IndependentAmountMeta implements RosettaMetaData<IndependentAmount> {

	@Override
	public List<Validator<? super IndependentAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super IndependentAmount>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndependentAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndependentAmount> validator() {
		return new cdm.legalagreement.csa.validation.IndependentAmountValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndependentAmount, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.IndependentAmountOnlyExistsValidator();
	}
}
