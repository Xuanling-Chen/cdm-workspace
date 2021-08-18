package cdm.event.workflow.meta;

import cdm.event.workflow.LimitApplicable;
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
@RosettaMeta(model=LimitApplicable.class)
public class LimitApplicableMeta implements RosettaMetaData<LimitApplicable> {

	@Override
	public List<Validator<? super LimitApplicable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super LimitApplicable>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.event.workflow.validation.choicerule.LimitApplicableLimitApplicableChoice()
		);
	}
	
	@Override
	public List<Function<? super LimitApplicable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LimitApplicable> validator() {
		return new cdm.event.workflow.validation.LimitApplicableValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LimitApplicable, Set<String>> onlyExistsValidator() {
		return new cdm.event.workflow.validation.exists.LimitApplicableOnlyExistsValidator();
	}
}
