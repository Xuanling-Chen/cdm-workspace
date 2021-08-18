package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.IssuerTypeEnum;
import cdm.base.staticdata.asset.common.SupraNationalIssuerTypeEnum;
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
@RosettaDataRule("CollateralIssuerTypeSupraNationalSubType")
public class CollateralIssuerTypeSupraNationalSubType implements Validator<CollateralIssuerType> {
	
	private static final String NAME = "CollateralIssuerTypeSupraNationalSubType";
	private static final String DEFINITION = "if issuerType <> IssuerTypeEnum -> SupraNational then supraNationalType is absent";
	
	
	@Override
	public ValidationResult<CollateralIssuerType> validate(RosettaPath path, CollateralIssuerType collateralIssuerType) {
		ComparisonResult result = executeDataRule(collateralIssuerType);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CollateralIssuerType", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralIssuerType", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CollateralIssuerType collateralIssuerType) {
		if (ruleIsApplicable(collateralIssuerType).get()) {
			return evaluateThenExpression(collateralIssuerType);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CollateralIssuerType collateralIssuerType) {
		try {
			return notEqual(MapperS.of(collateralIssuerType).<IssuerTypeEnum>map("getIssuerType", _collateralIssuerType -> _collateralIssuerType.getIssuerType()), MapperS.of(IssuerTypeEnum.SUPRA_NATIONAL), CardinalityOperator.Any);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CollateralIssuerType collateralIssuerType) {
		try {
			return notExists(MapperS.of(collateralIssuerType).<SupraNationalIssuerTypeEnum>map("getSupraNationalType", _collateralIssuerType -> _collateralIssuerType.getSupraNationalType()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
