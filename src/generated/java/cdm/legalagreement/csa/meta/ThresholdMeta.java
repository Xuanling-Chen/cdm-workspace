package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.Threshold;
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
@RosettaMeta(model=Threshold.class)
public class ThresholdMeta implements RosettaMetaData<Threshold> {

	@Override
	public List<Validator<? super Threshold>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Threshold>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Threshold, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Threshold> validator() {
		return new cdm.legalagreement.csa.validation.ThresholdValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Threshold, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ThresholdOnlyExistsValidator();
	}
}
