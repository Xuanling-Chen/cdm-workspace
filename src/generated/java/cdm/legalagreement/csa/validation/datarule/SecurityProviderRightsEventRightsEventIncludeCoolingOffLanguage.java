package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.SecurityProviderRightsEvent;
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
@RosettaDataRule("SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage")
public class SecurityProviderRightsEventRightsEventIncludeCoolingOffLanguage implements Validator<SecurityProviderRightsEvent> {
	
	private static final String NAME = "SecurityProviderRightsEventRightsEvent_includeCoolingOffLanguage";
	private static final String DEFINITION = "if includeCoolingOffLanguage = True then customElection is absent";
	
	
	@Override
	public ValidationResult<SecurityProviderRightsEvent> validate(RosettaPath path, SecurityProviderRightsEvent securityProviderRightsEvent) {
		ComparisonResult result = executeDataRule(securityProviderRightsEvent);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SecurityProviderRightsEvent", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SecurityProviderRightsEvent", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SecurityProviderRightsEvent securityProviderRightsEvent) {
		if (ruleIsApplicable(securityProviderRightsEvent).get()) {
			return evaluateThenExpression(securityProviderRightsEvent);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SecurityProviderRightsEvent securityProviderRightsEvent) {
		try {
			return areEqual(MapperS.of(securityProviderRightsEvent).<Boolean>map("getIncludeCoolingOffLanguage", _securityProviderRightsEvent -> _securityProviderRightsEvent.getIncludeCoolingOffLanguage()), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SecurityProviderRightsEvent securityProviderRightsEvent) {
		try {
			return notExists(MapperS.of(securityProviderRightsEvent).<String>map("getCustomElection", _securityProviderRightsEvent -> _securityProviderRightsEvent.getCustomElection()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
