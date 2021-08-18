package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AccessConditions;
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
@RosettaMeta(model=AccessConditions.class)
public class AccessConditionsMeta implements RosettaMetaData<AccessConditions> {

	@Override
	public List<Validator<? super AccessConditions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AccessConditions>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccessConditions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccessConditions> validator() {
		return new cdm.legalagreement.csa.validation.AccessConditionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccessConditions, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AccessConditionsOnlyExistsValidator();
	}
}
