package cdm.product.asset.validation.datarule;

import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.GeneralTerms;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("GeneralTermsFpML_cd_42")
public class GeneralTermsFpMLCd42 implements Validator<GeneralTerms> {
	
	private static final String NAME = "GeneralTermsFpML_cd_42";
	private static final String DEFINITION = "if basketReferenceInformation is absent then substitution is absent";
	
	
	@Override
	public ValidationResult<GeneralTerms> validate(RosettaPath path, GeneralTerms generalTerms) {
		ComparisonResult result = executeDataRule(generalTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "GeneralTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "GeneralTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(GeneralTerms generalTerms) {
		if (ruleIsApplicable(generalTerms).get()) {
			return evaluateThenExpression(generalTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(GeneralTerms generalTerms) {
		try {
			return notExists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(GeneralTerms generalTerms) {
		try {
			return notExists(MapperS.of(generalTerms).<Boolean>map("getSubstitution", _generalTerms -> _generalTerms.getSubstitution()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
