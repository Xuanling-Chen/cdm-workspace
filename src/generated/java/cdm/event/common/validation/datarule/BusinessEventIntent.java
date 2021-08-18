package cdm.event.common.validation.datarule;

import cdm.event.common.BusinessEvent;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.ExecutionPrimitive;
import cdm.event.common.IntentEnum;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.ResetPrimitive;
import cdm.event.common.SplitPrimitive;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("BusinessEventIntent")
public class BusinessEventIntent implements Validator<BusinessEvent> {
	
	private static final String NAME = "BusinessEventIntent";
	private static final String DEFINITION = "if (primitives -> split exists or primitives -> execution exists or primitives -> contractFormation exists or primitives -> reset exists) then intent is absent";
	
	
	@Override
	public ValidationResult<BusinessEvent> validate(RosettaPath path, BusinessEvent businessEvent) {
		ComparisonResult result = executeDataRule(businessEvent);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "BusinessEvent", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessEvent", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(BusinessEvent businessEvent) {
		if (ruleIsApplicable(businessEvent).get()) {
			return evaluateThenExpression(businessEvent);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(BusinessEvent businessEvent) {
		try {
			return exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<SplitPrimitive>map("getSplit", _primitiveEvent -> _primitiveEvent.getSplit())).or(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ExecutionPrimitive>map("getExecution", _primitiveEvent -> _primitiveEvent.getExecution()))).or(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation()))).or(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ResetPrimitive>map("getReset", _primitiveEvent -> _primitiveEvent.getReset())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(BusinessEvent businessEvent) {
		try {
			return notExists(MapperS.of(businessEvent).<IntentEnum>map("getIntent", _businessEvent -> _businessEvent.getIntent()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
