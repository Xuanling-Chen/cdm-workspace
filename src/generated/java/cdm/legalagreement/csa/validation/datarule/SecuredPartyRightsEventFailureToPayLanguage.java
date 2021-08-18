package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.SecuredPartyRightsEvent;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("SecuredPartyRightsEventFailureToPayLanguage")
public class SecuredPartyRightsEventFailureToPayLanguage implements Validator<SecuredPartyRightsEvent> {
	
	private static final String NAME = "SecuredPartyRightsEventFailureToPayLanguage";
	private static final String DEFINITION = "if earlyTerminationDateOptionalLanguage = False then failureToPayEarlyTermination is absent";
	
	
	@Override
	public ValidationResult<SecuredPartyRightsEvent> validate(RosettaPath path, SecuredPartyRightsEvent securedPartyRightsEvent) {
		ComparisonResult result = executeDataRule(securedPartyRightsEvent);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SecuredPartyRightsEvent", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecuredPartyRightsEvent", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SecuredPartyRightsEvent securedPartyRightsEvent) {
		if (ruleIsApplicable(securedPartyRightsEvent).get()) {
			return evaluateThenExpression(securedPartyRightsEvent);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SecuredPartyRightsEvent securedPartyRightsEvent) {
		try {
			return areEqual(MapperS.of(securedPartyRightsEvent).<Boolean>map("getEarlyTerminationDateOptionalLanguage", _securedPartyRightsEvent -> _securedPartyRightsEvent.getEarlyTerminationDateOptionalLanguage()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SecuredPartyRightsEvent securedPartyRightsEvent) {
		try {
			return notExists(MapperS.of(securedPartyRightsEvent).<Boolean>map("getFailureToPayEarlyTermination", _securedPartyRightsEvent -> _securedPartyRightsEvent.getFailureToPayEarlyTermination()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
