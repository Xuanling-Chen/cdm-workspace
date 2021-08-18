package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.MarginApproach;
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
@RosettaMeta(model=MarginApproach.class)
public class MarginApproachMeta implements RosettaMetaData<MarginApproach> {

	@Override
	public List<Validator<? super MarginApproach>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super MarginApproach>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarginApproach, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarginApproach> validator() {
		return new cdm.legalagreement.csa.validation.MarginApproachValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarginApproach, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.MarginApproachOnlyExistsValidator();
	}
}
