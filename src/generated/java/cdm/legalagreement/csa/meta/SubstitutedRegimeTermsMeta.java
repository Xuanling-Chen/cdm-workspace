package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.SubstitutedRegimeTerms;
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
@RosettaMeta(model=SubstitutedRegimeTerms.class)
public class SubstitutedRegimeTermsMeta implements RosettaMetaData<SubstitutedRegimeTerms> {

	@Override
	public List<Validator<? super SubstitutedRegimeTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SubstitutedRegimeTerms>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SubstitutedRegimeTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SubstitutedRegimeTerms> validator() {
		return new cdm.legalagreement.csa.validation.SubstitutedRegimeTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SubstitutedRegimeTerms, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SubstitutedRegimeTermsOnlyExistsValidator();
	}
}
