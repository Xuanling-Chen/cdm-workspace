package cdm.product.asset.validation.datarule;

import cdm.product.asset.GeneralTerms;
import cdm.product.asset.IndexReferenceInformation;
import cdm.product.asset.Tranche;
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
@RosettaDataRule("GeneralTermsFpML_cd_41")
public class GeneralTermsFpMLCd41 implements Validator<GeneralTerms> {
	
	private static final String NAME = "GeneralTermsFpML_cd_41";
	private static final String DEFINITION = "if indexReferenceInformation -> tranche is absent then modifiedEquityDelivery is absent";
	
	
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
			return notExists(MapperS.of(generalTerms).<IndexReferenceInformation>map("getIndexReferenceInformation", _generalTerms -> _generalTerms.getIndexReferenceInformation()).<Tranche>map("getTranche", _indexReferenceInformation -> _indexReferenceInformation.getTranche()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(GeneralTerms generalTerms) {
		try {
			return notExists(MapperS.of(generalTerms).<Boolean>map("getModifiedEquityDelivery", _generalTerms -> _generalTerms.getModifiedEquityDelivery()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
