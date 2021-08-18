package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SensitivityMethodologies;
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
@RosettaMeta(model=SensitivityMethodologies.class)
public class SensitivityMethodologiesMeta implements RosettaMetaData<SensitivityMethodologies> {

	@Override
	public List<Validator<? super SensitivityMethodologies>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SensitivityMethodologies>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SensitivityMethodologies, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivityMethodologies> validator() {
		return new cdm.legalagreement.csa.validation.SensitivityMethodologiesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityMethodologies, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SensitivityMethodologiesOnlyExistsValidator();
	}
}
