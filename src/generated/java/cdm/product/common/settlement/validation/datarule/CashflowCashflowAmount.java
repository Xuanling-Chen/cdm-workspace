package cdm.product.common.settlement.validation.datarule;

import cdm.observable.asset.Money;
import cdm.product.common.settlement.Cashflow;
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
@RosettaDataRule("CashflowCashflowAmount")
public class CashflowCashflowAmount implements Validator<Cashflow> {
	
	private static final String NAME = "CashflowCashflowAmount";
	private static final String DEFINITION = "if cashflowAmount exists then cashflowAmount -> amount >= 0.0";
	
	
	@Override
	public ValidationResult<Cashflow> validate(RosettaPath path, Cashflow cashflow) {
		ComparisonResult result = executeDataRule(cashflow);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Cashflow", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Cashflow", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Cashflow cashflow) {
		if (ruleIsApplicable(cashflow).get()) {
			return evaluateThenExpression(cashflow);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Cashflow cashflow) {
		try {
			return exists(MapperS.of(cashflow).<Money>map("getCashflowAmount", _cashflow -> _cashflow.getCashflowAmount()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Cashflow cashflow) {
		try {
			return greaterThanEquals(MapperS.of(cashflow).<Money>map("getCashflowAmount", _cashflow -> _cashflow.getCashflowAmount()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
