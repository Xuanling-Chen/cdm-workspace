package cdm.product.template.validation.datarule;

import cdm.base.staticdata.asset.common.Security;
import cdm.product.template.Product;
import cdm.product.template.SecurityFinancePayout;
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
@RosettaDataRule("SecurityFinancePayoutProductMustBeSecurity")
public class SecurityFinancePayoutProductMustBeSecurity implements Validator<SecurityFinancePayout> {
	
	private static final String NAME = "SecurityFinancePayoutProductMustBeSecurity";
	private static final String DEFINITION = "securityInformation -> security exists";
	
	
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
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SecurityFinancePayout securityFinancePayout) {
		try {
			return exists(MapperS.of(securityFinancePayout).<Product>map("getSecurityInformation", _securityFinancePayout -> _securityFinancePayout.getSecurityInformation()).<Security>map("getSecurity", _product -> _product.getSecurity()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
