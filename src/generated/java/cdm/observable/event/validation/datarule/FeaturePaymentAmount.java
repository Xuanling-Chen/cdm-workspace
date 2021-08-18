package cdm.observable.event.validation.datarule;

import cdm.observable.event.FeaturePayment;
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
@RosettaDataRule("FeaturePaymentAmount")
public class FeaturePaymentAmount implements Validator<FeaturePayment> {
	
	private static final String NAME = "FeaturePaymentAmount";
	private static final String DEFINITION = "if amount exists then amount >= 0.0";
	
	
	@Override
	public ValidationResult<FeaturePayment> validate(RosettaPath path, FeaturePayment featurePayment) {
		ComparisonResult result = executeDataRule(featurePayment);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FeaturePayment", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FeaturePayment", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FeaturePayment featurePayment) {
		if (ruleIsApplicable(featurePayment).get()) {
			return evaluateThenExpression(featurePayment);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FeaturePayment featurePayment) {
		try {
			return exists(MapperS.of(featurePayment).<BigDecimal>map("getAmount", _featurePayment -> _featurePayment.getAmount()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FeaturePayment featurePayment) {
		try {
			return greaterThanEquals(MapperS.of(featurePayment).<BigDecimal>map("getAmount", _featurePayment -> _featurePayment.getAmount()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
