package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.InterestAmount;
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
@RosettaMeta(model=InterestAmount.class)
public class InterestAmountMeta implements RosettaMetaData<InterestAmount> {

	@Override
	public List<Validator<? super InterestAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super InterestAmount>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAmount> validator() {
		return new cdm.legalagreement.csa.validation.InterestAmountValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAmount, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.InterestAmountOnlyExistsValidator();
	}
}
