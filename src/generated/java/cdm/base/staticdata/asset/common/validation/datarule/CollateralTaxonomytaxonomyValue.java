package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.CollateralTaxonomy;
import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CollateralTaxonomytaxonomyValue")
public class CollateralTaxonomytaxonomyValue implements Validator<CollateralTaxonomy> {
	
	private static final String NAME = "CollateralTaxonomytaxonomyValue";
	private static final String DEFINITION = "if taxonomyValue -> nonEnumeratedTaxonomyValue exists then taxonomySource <> TaxonomySourceEnum -> EU_EMIR_EligibleCollateralAssetClass and taxonomySource <> TaxonomySourceEnum -> UK_EMIR_EligibleCollateralAssetClass and taxonomySource <> TaxonomySourceEnum -> US_CFTC_PR_EligibleCollateralAssetClass";
	
	
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
			return exists(MapperS.of(collateralTaxonomy).<CollateralTaxonomyValue>map("getTaxonomyValue", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomyValue()).<FieldWithMetaString>mapC("getNonEnumeratedTaxonomyValue", _collateralTaxonomyValue -> _collateralTaxonomyValue.getNonEnumeratedTaxonomyValue()).<String>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CollateralTaxonomy collateralTaxonomy) {
		try {
			return notEqual(MapperS.of(collateralTaxonomy).<TaxonomySourceEnum>map("getTaxonomySource", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomySource()), MapperS.of(TaxonomySourceEnum.EU_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS), CardinalityOperator.Any).and(notEqual(MapperS.of(collateralTaxonomy).<TaxonomySourceEnum>map("getTaxonomySource", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomySource()), MapperS.of(TaxonomySourceEnum.UK_EMIR_ELIGIBLE_COLLATERAL_ASSET_CLASS), CardinalityOperator.Any)).and(notEqual(MapperS.of(collateralTaxonomy).<TaxonomySourceEnum>map("getTaxonomySource", _collateralTaxonomy -> _collateralTaxonomy.getTaxonomySource()), MapperS.of(TaxonomySourceEnum.US_CFTC_PR_ELIGIBLE_COLLATERAL_ASSET_CLASS), CardinalityOperator.Any));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
