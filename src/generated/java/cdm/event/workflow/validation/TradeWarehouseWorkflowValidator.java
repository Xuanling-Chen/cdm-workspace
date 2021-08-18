package cdm.event.workflow.validation;

import cdm.event.workflow.TradeWarehouseWorkflow;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class TradeWarehouseWorkflowValidator implements Validator<TradeWarehouseWorkflow> {

	@Override
	public ValidationResult<TradeWarehouseWorkflow> validate(RosettaPath path, TradeWarehouseWorkflow o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("warehouseIdentity", o.getWarehouseIdentity()!=null ? 1 : 0, 1, 1),
				checkCardinality("warehouseStatus", o.getWarehouseStatus()!=null ? 1 : 0, 1, 1),
				checkCardinality("partyCustomisedWorkflow", o.getPartyCustomisedWorkflow()==null?0:o.getPartyCustomisedWorkflow().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TradeWarehouseWorkflow", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TradeWarehouseWorkflow", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
