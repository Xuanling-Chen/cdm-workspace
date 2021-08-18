package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.PriceSource;
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
@RosettaDataRule("PriceSourcePriceSourceHeading")
public class PriceSourcePriceSourceHeading implements Validator<PriceSource> {
	
	private static final String NAME = "PriceSourcePriceSourceHeading";
	private static final String DEFINITION = "if priceSourceHeading exists then priceSourceLocation exists";
	
	
	@Override
	public ValidationResult<PriceSource> validate(RosettaPath path, PriceSource priceSource) {
		ComparisonResult result = executeDataRule(priceSource);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PriceSource", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PriceSource", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PriceSource priceSource) {
		if (ruleIsApplicable(priceSource).get()) {
			return evaluateThenExpression(priceSource);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PriceSource priceSource) {
		try {
			return exists(MapperS.of(priceSource).<String>map("getPriceSourceHeading", _priceSource -> _priceSource.getPriceSourceHeading()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PriceSource priceSource) {
		try {
			return exists(MapperS.of(priceSource).<String>map("getPriceSourceLocation", _priceSource -> _priceSource.getPriceSourceLocation()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
