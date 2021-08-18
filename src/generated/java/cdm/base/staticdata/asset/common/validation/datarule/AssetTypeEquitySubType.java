package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.EquityTypeEnum;
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
@RosettaDataRule("AssetTypeEquitySubType")
public class AssetTypeEquitySubType implements Validator<AssetType> {
	
	private static final String NAME = "AssetTypeEquitySubType";
	private static final String DEFINITION = "if securityType <> SecurityTypeEnum -> Equity then equityType is absent";
	
	
	@Override
	public ValidationResult<AssetType> validate(RosettaPath path, AssetType assetType) {
		ComparisonResult result = executeDataRule(assetType);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AssetType", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetType", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AssetType assetType) {
		if (ruleIsApplicable(assetType).get()) {
			return evaluateThenExpression(assetType);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AssetType assetType) {
		try {
			return notEqual(MapperS.of(assetType).<SecurityTypeEnum>map("getSecurityType", _assetType -> _assetType.getSecurityType()), MapperS.of(SecurityTypeEnum.EQUITY), CardinalityOperator.Any);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AssetType assetType) {
		try {
			return notExists(MapperS.of(assetType).<EquityTypeEnum>map("getEquityType", _assetType -> _assetType.getEquityType()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
