package cdm.event.workflow.meta;

import cdm.event.workflow.TradeWarehouseWorkflow;
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
@RosettaMeta(model=TradeWarehouseWorkflow.class)
public class TradeWarehouseWorkflowMeta implements RosettaMetaData<TradeWarehouseWorkflow> {

	@Override
	public List<Validator<? super TradeWarehouseWorkflow>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super TradeWarehouseWorkflow>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeWarehouseWorkflow, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeWarehouseWorkflow> validator() {
		return new cdm.event.workflow.validation.TradeWarehouseWorkflowValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeWarehouseWorkflow, Set<String>> onlyExistsValidator() {
		return new cdm.event.workflow.validation.exists.TradeWarehouseWorkflowOnlyExistsValidator();
	}
}
