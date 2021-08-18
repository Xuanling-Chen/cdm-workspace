package cdm.regulation.meta;

import cdm.regulation.RefRate;
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
@RosettaMeta(model=RefRate.class)
public class RefRateMeta implements RosettaMetaData<RefRate> {

	@Override
	public List<Validator<? super RefRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RefRate>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RefRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RefRate> validator() {
		return new cdm.regulation.validation.RefRateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RefRate, Set<String>> onlyExistsValidator() {
		return new cdm.regulation.validation.exists.RefRateOnlyExistsValidator();
	}
}
