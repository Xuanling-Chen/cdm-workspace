package cdm.event.workflow.meta;

import cdm.event.workflow.CustomisedWorkflow;
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
@RosettaMeta(model=CustomisedWorkflow.class)
public class CustomisedWorkflowMeta implements RosettaMetaData<CustomisedWorkflow> {

	@Override
	public List<Validator<? super CustomisedWorkflow>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CustomisedWorkflow>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustomisedWorkflow, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustomisedWorkflow> validator() {
		return new cdm.event.workflow.validation.CustomisedWorkflowValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustomisedWorkflow, Set<String>> onlyExistsValidator() {
		return new cdm.event.workflow.validation.exists.CustomisedWorkflowOnlyExistsValidator();
	}
}
