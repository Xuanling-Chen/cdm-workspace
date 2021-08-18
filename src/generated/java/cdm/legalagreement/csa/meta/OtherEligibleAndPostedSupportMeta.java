package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.OtherEligibleAndPostedSupport;
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
@RosettaMeta(model=OtherEligibleAndPostedSupport.class)
public class OtherEligibleAndPostedSupportMeta implements RosettaMetaData<OtherEligibleAndPostedSupport> {

	@Override
	public List<Validator<? super OtherEligibleAndPostedSupport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super OtherEligibleAndPostedSupport>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherEligibleAndPostedSupport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherEligibleAndPostedSupport> validator() {
		return new cdm.legalagreement.csa.validation.OtherEligibleAndPostedSupportValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherEligibleAndPostedSupport, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.OtherEligibleAndPostedSupportOnlyExistsValidator();
	}
}
