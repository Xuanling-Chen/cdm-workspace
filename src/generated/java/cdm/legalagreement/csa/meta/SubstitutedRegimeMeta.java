package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SubstitutedRegime;
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
@RosettaMeta(model=SubstitutedRegime.class)
public class SubstitutedRegimeMeta implements RosettaMetaData<SubstitutedRegime> {

	@Override
	public List<Validator<? super SubstitutedRegime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SubstitutedRegime>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.SubstitutedRegimeSubstitutedRegimeChoice()
		);
	}
	
	@Override
	public List<Function<? super SubstitutedRegime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SubstitutedRegime> validator() {
		return new cdm.legalagreement.csa.validation.SubstitutedRegimeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SubstitutedRegime, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SubstitutedRegimeOnlyExistsValidator();
	}
}
