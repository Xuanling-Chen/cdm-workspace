package cdm.product.common.schedule.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.product.common.schedule.CalculationPeriodDates;
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
@RosettaDataRule("CalculationPeriodDatesFpML_ird_22")
public class CalculationPeriodDatesFpMLIrd22 implements Validator<CalculationPeriodDates> {
	
	private static final String NAME = "CalculationPeriodDatesFpML_ird_22";
	private static final String DEFINITION = "if firstPeriodStartDate exists and firstRegularPeriodStartDate exists then firstPeriodStartDate -> adjustableDate -> unadjustedDate < firstRegularPeriodStartDate";
	
	
	@Override
	public ValidationResult<CalculationPeriodDates> validate(RosettaPath path, CalculationPeriodDates calculationPeriodDates) {
		ComparisonResult result = executeDataRule(calculationPeriodDates);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CalculationPeriodDates", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodDates", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CalculationPeriodDates calculationPeriodDates) {
		if (ruleIsApplicable(calculationPeriodDates).get()) {
			return evaluateThenExpression(calculationPeriodDates);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CalculationPeriodDates calculationPeriodDates) {
		try {
			return exists(MapperS.of(calculationPeriodDates).<AdjustableOrRelativeDate>map("getFirstPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstPeriodStartDate())).and(exists(MapperS.of(calculationPeriodDates).<Date>map("getFirstRegularPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstRegularPeriodStartDate())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CalculationPeriodDates calculationPeriodDates) {
		try {
			return lessThan(MapperS.of(calculationPeriodDates).<AdjustableOrRelativeDate>map("getFirstPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstPeriodStartDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), MapperS.of(calculationPeriodDates).<Date>map("getFirstRegularPeriodStartDate", _calculationPeriodDates -> _calculationPeriodDates.getFirstRegularPeriodStartDate()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
