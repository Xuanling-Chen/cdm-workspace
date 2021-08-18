package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.RecalculationOfValue;
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
@RosettaMeta(model=RecalculationOfValue.class)
public class RecalculationOfValueMeta implements RosettaMetaData<RecalculationOfValue> {

	@Override
	public List<Validator<? super RecalculationOfValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RecalculationOfValue>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RecalculationOfValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RecalculationOfValue> validator() {
		return new cdm.legalagreement.csa.validation.RecalculationOfValueValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RecalculationOfValue, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.RecalculationOfValueOnlyExistsValidator();
	}
}
