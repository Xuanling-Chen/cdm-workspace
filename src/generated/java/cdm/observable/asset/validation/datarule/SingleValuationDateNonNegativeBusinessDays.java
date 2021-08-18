package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.SingleValuationDate;
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
@RosettaDataRule("SingleValuationDateNonNegativeBusinessDays")
public class SingleValuationDateNonNegativeBusinessDays implements Validator<SingleValuationDate> {
	
	private static final String NAME = "SingleValuationDateNonNegativeBusinessDays";
	private static final String DEFINITION = "if businessDays exists then businessDays >= 0";
	
	
	@Override
	public ValidationResult<SingleValuationDate> validate(RosettaPath path, SingleValuationDate singleValuationDate) {
		ComparisonResult result = executeDataRule(singleValuationDate);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SingleValuationDate", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SingleValuationDate", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SingleValuationDate singleValuationDate) {
		if (ruleIsApplicable(singleValuationDate).get()) {
			return evaluateThenExpression(singleValuationDate);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SingleValuationDate singleValuationDate) {
		try {
			return exists(MapperS.of(singleValuationDate).<Integer>map("getBusinessDays", _singleValuationDate -> _singleValuationDate.getBusinessDays()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SingleValuationDate singleValuationDate) {
		try {
			return greaterThanEquals(MapperS.of(singleValuationDate).<Integer>map("getBusinessDays", _singleValuationDate -> _singleValuationDate.getBusinessDays()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
