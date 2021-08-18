package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.MultipleValuationDates;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("MultipleValuationDatesNumberValuationDates")
public class MultipleValuationDatesNumberValuationDates implements Validator<MultipleValuationDates> {
	
	private static final String NAME = "MultipleValuationDatesNumberValuationDates";
	private static final String DEFINITION = "if numberValuationDates exists then numberValuationDates >= 0";
	
	
	@Override
	public ValidationResult<MultipleValuationDates> validate(RosettaPath path, MultipleValuationDates multipleValuationDates) {
		ComparisonResult result = executeDataRule(multipleValuationDates);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "MultipleValuationDates", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleValuationDates", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(MultipleValuationDates multipleValuationDates) {
		if (ruleIsApplicable(multipleValuationDates).get()) {
			return evaluateThenExpression(multipleValuationDates);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(MultipleValuationDates multipleValuationDates) {
		try {
			return exists(MapperS.of(multipleValuationDates).<Integer>map("getNumberValuationDates", _multipleValuationDates -> _multipleValuationDates.getNumberValuationDates()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(MultipleValuationDates multipleValuationDates) {
		try {
			return greaterThanEquals(MapperS.of(multipleValuationDates).<Integer>map("getNumberValuationDates", _multipleValuationDates -> _multipleValuationDates.getNumberValuationDates()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
