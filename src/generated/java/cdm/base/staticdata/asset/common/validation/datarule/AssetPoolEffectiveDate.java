package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.AssetPool;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AssetPoolEffectiveDate")
public class AssetPoolEffectiveDate implements Validator<AssetPool> {
	
	private static final String NAME = "AssetPoolEffectiveDate";
	private static final String DEFINITION = "if version is absent then effectiveDate is absent";
	
	
	@Override
	public ValidationResult<AssetPool> validate(RosettaPath path, AssetPool assetPool) {
		ComparisonResult result = executeDataRule(assetPool);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AssetPool", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetPool", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AssetPool assetPool) {
		if (ruleIsApplicable(assetPool).get()) {
			return evaluateThenExpression(assetPool);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AssetPool assetPool) {
		try {
			return notExists(MapperS.of(assetPool).<String>map("getVersion", _assetPool -> _assetPool.getVersion()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AssetPool assetPool) {
		try {
			return notExists(MapperS.of(assetPool).<Date>map("getEffectiveDate", _assetPool -> _assetPool.getEffectiveDate()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
