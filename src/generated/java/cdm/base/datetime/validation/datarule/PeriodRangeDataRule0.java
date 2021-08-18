package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.PeriodBound;
import cdm.base.datetime.PeriodRange;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("PeriodRangeDataRule0")
public class PeriodRangeDataRule0 implements Validator<PeriodRange> {
	
	private static final String NAME = "PeriodRangeDataRule0";
	private static final String DEFINITION = "lowerBound exists or upperBound exists";
	
	
	@Override
	public ValidationResult<PeriodRange> validate(RosettaPath path, PeriodRange periodRange) {
		ComparisonResult result = executeDataRule(periodRange);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PeriodRange", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PeriodRange", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PeriodRange periodRange) {
		if (ruleIsApplicable(periodRange).get()) {
			return evaluateThenExpression(periodRange);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PeriodRange periodRange) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PeriodRange periodRange) {
		try {
			return exists(MapperS.of(periodRange).<PeriodBound>map("getLowerBound", _periodRange -> _periodRange.getLowerBound())).or(exists(MapperS.of(periodRange).<PeriodBound>map("getUpperBound", _periodRange -> _periodRange.getUpperBound())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
