package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.UK_EMIR_EligibleCollateralEnum;
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
@RosettaDataRule("CollateralTaxonomyUkEligibleCollateralTaxonomy")
public class CollateralTaxonomyUkEligibleCollateralTaxonomy implements Validator<CollateralTaxonomy> {
	
	private static final String NAME = "CollateralTaxonomyUkEligibleCollateralTaxonomy";
	private static final String DEFINITION = "if taxonomySource = TaxonomySourceEnum-> UK_EMIR_EligibleCollateralAssetClass then taxonomyValue -> uk_EMIR_EligibleCollateral exists";
	
	
	@Override
	public ValidationResult<CollateralTaxonomy> validate(RosettaPath path, CollateralTaxonomy collateralTaxonomy) {
		ComparisonResult result = executeDataRule(collateralTaxonomy);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CollateralTaxonomy", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralTaxonomy", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CollateralTaxonomy collateralTaxonomy) {
		if (ruleIsApplicable(collateralTaxonomy).get()) {
			return evaluateThenExpression(collateralTaxonomy);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CollateralTaxonomy collateralTaxonomy) {
		try {
			return areEqual(MapperS.of(collateralTaxonomy).<TaxonomySourceEnum>map("getTaxonomySource", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomySource()), MapperS.of(TaxonomySourceEnum.UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CollateralTaxonomy collateralTaxonomy) {
		try {
			return exists(MapperS.of(collateralTaxonomy).<CollateralTaxonomyValue>map("getTaxonomyValue", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomyValue()).<UK_EMIR_EligibleCollateralEnum>mapC("getUk_EMIR_EligibleCollateral", _collateralTaxonomyValue -> _collateralTaxonomyValue.getUk_EMIR_EligibleCollateral()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
