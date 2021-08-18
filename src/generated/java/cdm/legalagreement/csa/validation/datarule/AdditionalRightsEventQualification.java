package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.AdditionalRightsEvent;
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
@RosettaDataRule("AdditionalRightsEventQualification")
public class AdditionalRightsEventQualification implements Validator<AdditionalRightsEvent> {
	
	private static final String NAME = "AdditionalRightsEventQualification";
	private static final String DEFINITION = "if qualification exists then isApplicable = True";
	
	
	@Override
	public ValidationResult<AdditionalRightsEvent> validate(RosettaPath path, AdditionalRightsEvent additionalRightsEvent) {
		ComparisonResult result = executeDataRule(additionalRightsEvent);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AdditionalRightsEvent", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalRightsEvent", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AdditionalRightsEvent additionalRightsEvent) {
		if (ruleIsApplicable(additionalRightsEvent).get()) {
			return evaluateThenExpression(additionalRightsEvent);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AdditionalRightsEvent additionalRightsEvent) {
		try {
			return exists(MapperS.of(additionalRightsEvent).<String>map("getQualification", _additionalRightsEvent -> _additionalRightsEvent.getQualification()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AdditionalRightsEvent additionalRightsEvent) {
		try {
			return areEqual(MapperS.of(additionalRightsEvent).<Boolean>map("getIsApplicable", _additionalRightsEvent -> _additionalRightsEvent.getIsApplicable()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
