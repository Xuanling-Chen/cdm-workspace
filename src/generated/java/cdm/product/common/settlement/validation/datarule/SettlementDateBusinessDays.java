package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.SettlementDate;
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
@RosettaDataRule("SettlementDateBusinessDays")
public class SettlementDateBusinessDays implements Validator<SettlementDate> {
	
	private static final String NAME = "SettlementDateBusinessDays";
	private static final String DEFINITION = "if cashSettlementBusinessDays exists then cashSettlementBusinessDays >= 0 else settlementDate exists or valueDate exists or adjustableDates exists or businessDateRange exists";
	
	
	@Override
	public ValidationResult<SettlementDate> validate(RosettaPath path, SettlementDate settlementDate) {
		ComparisonResult result = executeDataRule(settlementDate);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SettlementDate", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementDate", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SettlementDate settlementDate) {
		if (ruleIsApplicable(settlementDate).get()) {
			return evaluateThenExpression(settlementDate);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SettlementDate settlementDate) {
		try {
			return exists(MapperS.of(settlementDate).<Integer>map("getCashSettlementBusinessDays", _settlementDate -> _settlementDate.getCashSettlementBusinessDays()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SettlementDate settlementDate) {
		try {
			return greaterThanEquals(MapperS.of(settlementDate).<Integer>map("getCashSettlementBusinessDays", _settlementDate -> _settlementDate.getCashSettlementBusinessDays()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
