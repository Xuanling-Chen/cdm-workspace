package cdm.product.template.validation.datarule;

import cdm.observable.asset.Money;
import cdm.product.template.InitialMargin;
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
@RosettaDataRule("InitialMarginMinimumTransferAmount")
public class InitialMarginMinimumTransferAmount implements Validator<InitialMargin> {
	
	private static final String NAME = "InitialMarginMinimumTransferAmount";
	private static final String DEFINITION = "if minimumTransferAmount exists then minimumTransferAmount -> amount > 0";
	
	
	@Override
	public ValidationResult<InitialMargin> validate(RosettaPath path, InitialMargin initialMargin) {
		ComparisonResult result = executeDataRule(initialMargin);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "InitialMargin", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InitialMargin", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(InitialMargin initialMargin) {
		if (ruleIsApplicable(initialMargin).get()) {
			return evaluateThenExpression(initialMargin);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(InitialMargin initialMargin) {
		try {
			return exists(MapperS.of(initialMargin).<Money>map("getMinimumTransferAmount", _initialMargin -> _initialMargin.getMinimumTransferAmount()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(InitialMargin initialMargin) {
		try {
			return greaterThan(MapperS.of(initialMargin).<Money>map("getMinimumTransferAmount", _initialMargin -> _initialMargin.getMinimumTransferAmount()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
