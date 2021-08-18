package cdm.event.common.validation;

import cdm.event.common.BusinessEvent;
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

public class BusinessEventValidator implements Validator<BusinessEvent> {

	@Override
	public ValidationResult<BusinessEvent> validate(RosettaPath path, BusinessEvent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("primitives", o.getPrimitives()==null?0:o.getPrimitives().size(), 1, 0),
				checkCardinality("intent", o.getIntent()!=null ? 1 : 0, 0, 1),
				checkCardinality("functionCall", o.getFunctionCall()!=null ? 1 : 0, 0, 1),
				checkCardinality("eventQualifier", o.getEventQualifier()!=null ? 1 : 0, 0, 1),
				checkCardinality("eventDate", o.getEventDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("eventEffect", o.getEventEffect()!=null ? 1 : 0, 0, 1),
				checkCardinality("workflowEventState", o.getWorkflowEventState()!=null ? 1 : 0, 0, 1),
				checkCardinality("tradeWarehouseWorkflow", o.getTradeWarehouseWorkflow()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BusinessEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BusinessEvent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
