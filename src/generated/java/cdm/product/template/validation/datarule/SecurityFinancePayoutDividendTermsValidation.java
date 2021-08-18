package cdm.product.template.validation.datarule;

import cdm.product.template.DividendTerms;
import cdm.product.template.Duration;
import cdm.product.template.DurationTypeEnum;
import cdm.product.template.SecurityFinancePayout;
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
@RosettaDataRule("SecurityFinancePayoutDividendTermsValidation")
public class SecurityFinancePayoutDividendTermsValidation implements Validator<SecurityFinancePayout> {
	
	private static final String NAME = "SecurityFinancePayoutDividendTermsValidation";
	private static final String DEFINITION = "if dividendTerms exists then durationType -> durationType = DurationTypeEnum -> Term";
	
	
	@Override
	public ValidationResult<SecurityFinancePayout> validate(RosettaPath path, SecurityFinancePayout securityFinancePayout) {
		ComparisonResult result = executeDataRule(securityFinancePayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SecurityFinancePayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityFinancePayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SecurityFinancePayout securityFinancePayout) {
		if (ruleIsApplicable(securityFinancePayout).get()) {
			return evaluateThenExpression(securityFinancePayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SecurityFinancePayout securityFinancePayout) {
		try {
			return exists(MapperS.of(securityFinancePayout).<DividendTerms>map("getDividendTerms", _securityFinancePayout -> _securityFinancePayout.getDividendTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SecurityFinancePayout securityFinancePayout) {
		try {
			return areEqual(MapperS.of(securityFinancePayout).<Duration>map("getDurationType", _securityFinancePayout -> _securityFinancePayout.getDurationType()).<DurationTypeEnum>map("getDurationType", _duration -> _duration.getDurationType()), MapperS.of(DurationTypeEnum.TERM), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
