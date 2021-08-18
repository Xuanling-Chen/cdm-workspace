package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.CashSettlementTerms;
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
@RosettaDataRule("CashSettlementTermsRecoveryFactor")
public class CashSettlementTermsRecoveryFactor implements Validator<CashSettlementTerms> {
	
	private static final String NAME = "CashSettlementTermsRecoveryFactor";
	private static final String DEFINITION = "if recoveryFactor exists then recoveryFactor >= 0.0 and recoveryFactor <= 1.0";
	
	
	@Override
	public ValidationResult<CashSettlementTerms> validate(RosettaPath path, CashSettlementTerms cashSettlementTerms) {
		ComparisonResult result = executeDataRule(cashSettlementTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CashSettlementTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CashSettlementTerms cashSettlementTerms) {
		if (ruleIsApplicable(cashSettlementTerms).get()) {
			return evaluateThenExpression(cashSettlementTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CashSettlementTerms cashSettlementTerms) {
		try {
			return exists(MapperS.of(cashSettlementTerms).<BigDecimal>map("getRecoveryFactor", _cashSettlementTerms -> _cashSettlementTerms.getRecoveryFactor()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CashSettlementTerms cashSettlementTerms) {
		try {
			return greaterThanEquals(MapperS.of(cashSettlementTerms).<BigDecimal>map("getRecoveryFactor", _cashSettlementTerms -> _cashSettlementTerms.getRecoveryFactor()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All).and(lessThanEquals(MapperS.of(cashSettlementTerms).<BigDecimal>map("getRecoveryFactor", _cashSettlementTerms -> _cashSettlementTerms.getRecoveryFactor()), MapperS.of(BigDecimal.valueOf(1.0)), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
