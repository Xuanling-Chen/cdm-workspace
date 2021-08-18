package cdm.product.template.validation.datarule;

import cdm.product.template.ExtensionEvent;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ExtensionEventFpML_ird_42")
public class ExtensionEventFpMLIrd42 implements Validator<ExtensionEvent> {
	
	private static final String NAME = "ExtensionEventFpML_ird_42";
	private static final String DEFINITION = "if ExtensionEvent exists then adjustedExerciseDate < adjustedExtendedTerminationDate";
	
	
	@Override
	public ValidationResult<ExtensionEvent> validate(RosettaPath path, ExtensionEvent extensionEvent) {
		ComparisonResult result = executeDataRule(extensionEvent);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ExtensionEvent", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ExtensionEvent", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ExtensionEvent extensionEvent) {
		if (ruleIsApplicable(extensionEvent).get()) {
			return evaluateThenExpression(extensionEvent);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ExtensionEvent extensionEvent) {
		try {
			return exists(MapperS.of(extensionEvent));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ExtensionEvent extensionEvent) {
		try {
			return lessThan(MapperS.of(extensionEvent).<Date>map("getAdjustedExerciseDate", _extensionEvent -> _extensionEvent.getAdjustedExerciseDate()), MapperS.of(extensionEvent).<Date>map("getAdjustedExtendedTerminationDate", _extensionEvent -> _extensionEvent.getAdjustedExtendedTerminationDate()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
