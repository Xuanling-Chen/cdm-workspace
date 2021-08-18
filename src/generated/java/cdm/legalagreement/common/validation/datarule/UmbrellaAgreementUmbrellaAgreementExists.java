package cdm.legalagreement.common.validation.datarule;

import cdm.legalagreement.common.UmbrellaAgreement;
import cdm.legalagreement.common.UmbrellaAgreementEntity;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("UmbrellaAgreementUmbrellaAgreementExists")
public class UmbrellaAgreementUmbrellaAgreementExists implements Validator<UmbrellaAgreement> {
	
	private static final String NAME = "UmbrellaAgreementUmbrellaAgreementExists";
	private static final String DEFINITION = "if isApplicable = True then (language and parties) exists";
	
	
	@Override
	public ValidationResult<UmbrellaAgreement> validate(RosettaPath path, UmbrellaAgreement umbrellaAgreement) {
		ComparisonResult result = executeDataRule(umbrellaAgreement);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "UmbrellaAgreement", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "UmbrellaAgreement", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(UmbrellaAgreement umbrellaAgreement) {
		if (ruleIsApplicable(umbrellaAgreement).get()) {
			return evaluateThenExpression(umbrellaAgreement);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(UmbrellaAgreement umbrellaAgreement) {
		try {
			return areEqual(MapperS.of(umbrellaAgreement).<Boolean>map("getIsApplicable", _umbrellaAgreement -> _umbrellaAgreement.getIsApplicable()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(UmbrellaAgreement umbrellaAgreement) {
		try {
			return exists(MapperTree.andDifferent(MapperTree.of(MapperS.of(umbrellaAgreement).<String>map("getLanguage", _umbrellaAgreement -> _umbrellaAgreement.getLanguage())), MapperTree.of(MapperS.of(umbrellaAgreement).<UmbrellaAgreementEntity>mapC("getParties", _umbrellaAgreement -> _umbrellaAgreement.getParties()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
