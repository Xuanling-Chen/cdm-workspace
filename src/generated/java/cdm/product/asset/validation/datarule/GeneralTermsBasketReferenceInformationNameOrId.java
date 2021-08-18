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
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("GeneralTermsBasketReferenceInformationNameOrId")
public class GeneralTermsBasketReferenceInformationNameOrId implements Validator<GeneralTerms> {
	
	private static final String NAME = "GeneralTermsBasketReferenceInformationNameOrId";
	private static final String DEFINITION = "if basketReferenceInformation exists then basketReferenceInformation -> basketName exists or basketReferenceInformation -> basketId exists";
	
	
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
			return exists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(GeneralTerms generalTerms) {
		try {
			return exists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>map("getBasketName", _basketReferenceInformation -> _basketReferenceInformation.getBasketName()).<String>map("getValue", _f->_f.getValue())).or(exists(MapperS.of(generalTerms).<BasketReferenceInformation>map("getBasketReferenceInformation", _generalTerms -> _generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>mapC("getBasketId", _basketReferenceInformation -> _basketReferenceInformation.getBasketId()).<String>map("getValue", _f->_f.getValue())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
