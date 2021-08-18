package cdm.product.asset.validation.datarule;

import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.template.ConstituentWeight;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ReferencePoolFpML_cd_44_openUnits")
public class ReferencePoolFpMLCd44OpenUnits implements Validator<ReferencePool> {
	
	private static final String NAME = "ReferencePoolFpML_cd_44_openUnits";
	private static final String DEFINITION = "if referencePoolItem -> constituentWeight -> openUnits exists then referencePoolItem -> constituentWeight -> basketPercentage is absent";
	
	
	@Override
	public ValidationResult<ReferencePool> validate(RosettaPath path, ReferencePool referencePool) {
		ComparisonResult result = executeDataRule(referencePool);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ReferencePool", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePool", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ReferencePool referencePool) {
		if (ruleIsApplicable(referencePool).get()) {
			return evaluateThenExpression(referencePool);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ReferencePool referencePool) {
		try {
			return exists(MapperS.of(referencePool).<ReferencePoolItem>mapC("getReferencePoolItem", _referencePool -> _referencePool.getReferencePoolItem()).<ConstituentWeight>map("getConstituentWeight", _referencePoolItem -> _referencePoolItem.getConstituentWeight()).<BigDecimal>map("getOpenUnits", _constituentWeight -> _constituentWeight.getOpenUnits()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ReferencePool referencePool) {
		try {
			return notExists(MapperS.of(referencePool).<ReferencePoolItem>mapC("getReferencePoolItem", _referencePool -> _referencePool.getReferencePoolItem()).<ConstituentWeight>map("getConstituentWeight", _referencePoolItem -> _referencePoolItem.getConstituentWeight()).<BigDecimal>map("getBasketPercentage", _constituentWeight -> _constituentWeight.getBasketPercentage()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
