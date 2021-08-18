package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.AdditionalType;
import cdm.legalagreement.csa.AdditionalTypeEnum;
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
@RosettaDataRule("AdditionalTypeCustomValue")
public class AdditionalTypeCustomValue implements Validator<AdditionalType> {
	
	private static final String NAME = "AdditionalTypeCustomValue";
	private static final String DEFINITION = "if standardValue = AdditionalTypeEnum -> Other then customValue exists";
	
	
	@Override
	public ValidationResult<AdditionalType> validate(RosettaPath path, AdditionalType additionalType) {
		ComparisonResult result = executeDataRule(additionalType);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AdditionalType", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalType", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AdditionalType additionalType) {
		if (ruleIsApplicable(additionalType).get()) {
			return evaluateThenExpression(additionalType);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AdditionalType additionalType) {
		try {
			return areEqual(MapperS.of(additionalType).<AdditionalTypeEnum>map("getStandardValue", _additionalType -> _additionalType.getStandardValue()), MapperS.of(AdditionalTypeEnum.OTHER), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AdditionalType additionalType) {
		try {
			return exists(MapperS.of(additionalType).<String>map("getCustomValue", _additionalType -> _additionalType.getCustomValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
