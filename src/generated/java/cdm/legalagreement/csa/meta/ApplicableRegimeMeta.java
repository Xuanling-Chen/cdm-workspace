package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ApplicableRegime;
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
@RosettaMeta(model=ApplicableRegime.class)
public class ApplicableRegimeMeta implements RosettaMetaData<ApplicableRegime> {

	@Override
	public List<Validator<? super ApplicableRegime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ApplicableRegime>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.ApplicableRegimeApplicableRegimeChoice()
		);
	}
	
	@Override
	public List<Function<? super ApplicableRegime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ApplicableRegime> validator() {
		return new cdm.legalagreement.csa.validation.ApplicableRegimeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ApplicableRegime, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ApplicableRegimeOnlyExistsValidator();
	}
}
