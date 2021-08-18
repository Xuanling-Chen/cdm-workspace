package cdm.event.workflow.meta;

import cdm.event.workflow.WorkflowStep;
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
@RosettaMeta(model=WorkflowStep.class)
public class WorkflowStepMeta implements RosettaMetaData<WorkflowStep> {

	@Override
	public List<Validator<? super WorkflowStep>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.event.workflow.validation.datarule.WorkflowStepWorkflowStepStatus.class)
		);
	}

	@Override
	public List<Validator<? super WorkflowStep>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WorkflowStep, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WorkflowStep> validator() {
		return new cdm.event.workflow.validation.WorkflowStepValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WorkflowStep, Set<String>> onlyExistsValidator() {
		return new cdm.event.workflow.validation.exists.WorkflowStepOnlyExistsValidator();
	}
}
