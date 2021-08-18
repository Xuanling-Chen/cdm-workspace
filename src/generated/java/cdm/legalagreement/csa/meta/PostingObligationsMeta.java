package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.PostingObligations;
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
@RosettaMeta(model=PostingObligations.class)
public class PostingObligationsMeta implements RosettaMetaData<PostingObligations> {

	@Override
	public List<Validator<? super PostingObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PostingObligations>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostingObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostingObligations> validator() {
		return new cdm.legalagreement.csa.validation.PostingObligationsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostingObligations, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.PostingObligationsOnlyExistsValidator();
	}
}
