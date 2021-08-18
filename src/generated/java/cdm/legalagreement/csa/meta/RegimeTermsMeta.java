package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.RegimeTerms;
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
@RosettaMeta(model=RegimeTerms.class)
public class RegimeTermsMeta implements RosettaMetaData<RegimeTerms> {

	@Override
	public List<Validator<? super RegimeTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RegimeTerms>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegimeTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegimeTerms> validator() {
		return new cdm.legalagreement.csa.validation.RegimeTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegimeTerms, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.RegimeTermsOnlyExistsValidator();
	}
}
