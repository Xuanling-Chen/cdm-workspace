package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.Agreement;
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
@RosettaMeta(model=Agreement.class)
public class AgreementMeta implements RosettaMetaData<Agreement> {

	@Override
	public List<Validator<? super Agreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Agreement>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.common.validation.choicerule.AgreementOneOf0()
		);
	}
	
	@Override
	public List<Function<? super Agreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Agreement> validator() {
		return new cdm.legalagreement.common.validation.AgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Agreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.AgreementOnlyExistsValidator();
	}
}
