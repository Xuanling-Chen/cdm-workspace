package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.DayTypeEnum;
import cdm.base.datetime.Offset;
import cdm.base.datetime.PeriodEnum;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
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
@RosettaDataRule("OffsetDayType")
public class OffsetDayType implements Validator<Offset> {
	
	private static final String NAME = "OffsetDayType";
	private static final String DEFINITION = "if period <> PeriodEnum -> D or periodMultiplier = 0 then dayType is absent";
	
	
	@Override
	public ValidationResult<Offset> validate(RosettaPath path, Offset offset) {
		ComparisonResult result = executeDataRule(offset);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Offset", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Offset", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Offset offset) {
		if (ruleIsApplicable(offset).get()) {
			return evaluateThenExpression(offset);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Offset offset) {
		try {
			return notEqual(MapperS.of(offset).<PeriodEnum>map("getPeriod", _period -> _period.getPeriod()), MapperS.of(PeriodEnum.D), CardinalityOperator.Any).or(areEqual(MapperS.of(offset).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Offset offset) {
		try {
			return notExists(MapperS.of(offset).<DayTypeEnum>map("getDayType", _offset -> _offset.getDayType()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
