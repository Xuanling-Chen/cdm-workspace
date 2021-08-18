package cdm.product.asset.validation.datarule;

import cdm.product.asset.DividendPayout;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("DividendPayoutDividendPayoutRatioNonCash")
public class DividendPayoutDividendPayoutRatioNonCash implements Validator<DividendPayout> {
	
	private static final String NAME = "DividendPayoutDividendPayoutRatioNonCash";
	private static final String DEFINITION = "if dividendPayoutRatioNonCash exists then dividendPayoutRatioNonCash >= 0 and dividendPayoutRatio <= 1";
	
	
	@Override
	public ValidationResult<DividendPayout> validate(RosettaPath path, DividendPayout dividendPayout) {
		ComparisonResult result = executeDataRule(dividendPayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "DividendPayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(DividendPayout dividendPayout) {
		if (ruleIsApplicable(dividendPayout).get()) {
			return evaluateThenExpression(dividendPayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(DividendPayout dividendPayout) {
		try {
			return exists(MapperS.of(dividendPayout).<BigDecimal>map("getDividendPayoutRatioNonCash", _dividendPayout -> _dividendPayout.getDividendPayoutRatioNonCash()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(DividendPayout dividendPayout) {
		try {
			return greaterThanEquals(MapperS.of(dividendPayout).<BigDecimal>map("getDividendPayoutRatioNonCash", _dividendPayout -> _dividendPayout.getDividendPayoutRatioNonCash()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All).and(lessThanEquals(MapperS.of(dividendPayout).<BigDecimal>map("getDividendPayoutRatio", _dividendPayout -> _dividendPayout.getDividendPayoutRatio()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
