package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.FundProductTypeEnum;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
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
@RosettaDataRule("SecurityFundSubType")
public class SecurityFundSubType implements Validator<Security> {
	
	private static final String NAME = "SecurityFundSubType";
	private static final String DEFINITION = "if securityType <> SecurityTypeEnum -> Fund then fundType is absent";
	
	
	@Override
	public ValidationResult<Security> validate(RosettaPath path, Security security) {
		ComparisonResult result = executeDataRule(security);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Security", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Security", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Security security) {
		if (ruleIsApplicable(security).get()) {
			return evaluateThenExpression(security);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Security security) {
		try {
			return notEqual(MapperS.of(security).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.FUND), CardinalityOperator.Any);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Security security) {
		try {
			return notExists(MapperS.of(security).<FundProductTypeEnum>map("getFundType", _security -> _security.getFundType()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
