package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SensitivityMethodology;
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
@RosettaMeta(model=SensitivityMethodology.class)
public class SensitivityMethodologyMeta implements RosettaMetaData<SensitivityMethodology> {

	@Override
	public List<Validator<? super SensitivityMethodology>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SensitivityMethodology>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.SensitivityMethodologyOneOf0()
		);
	}
	
	@Override
	public List<Function<? super SensitivityMethodology, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SensitivityMethodology> validator() {
		return new cdm.legalagreement.csa.validation.SensitivityMethodologyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SensitivityMethodology, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SensitivityMethodologyOnlyExistsValidator();
	}
}
