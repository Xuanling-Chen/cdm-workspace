package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.DisputeResolution;
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
@RosettaMeta(model=DisputeResolution.class)
public class DisputeResolutionMeta implements RosettaMetaData<DisputeResolution> {

	@Override
	public List<Validator<? super DisputeResolution>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DisputeResolution>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DisputeResolution, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DisputeResolution> validator() {
		return new cdm.legalagreement.csa.validation.DisputeResolutionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DisputeResolution, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.DisputeResolutionOnlyExistsValidator();
	}
}
