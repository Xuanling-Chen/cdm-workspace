package cdm.observable.event.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.event.AdditionalDisruptionEvents;
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
@RosettaDataRule("AdditionalDisruptionEventsDisruptionEventsDeterminingParty")
public class AdditionalDisruptionEventsDisruptionEventsDeterminingParty implements Validator<AdditionalDisruptionEvents> {
	
	private static final String NAME = "AdditionalDisruptionEventsDisruptionEventsDeterminingParty";
	private static final String DEFINITION = "if determiningParty exists then determiningParty = AncillaryRoleEnum -> DisruptionEventsDeterminingParty";
	
	
	@Override
	public ValidationResult<AdditionalDisruptionEvents> validate(RosettaPath path, AdditionalDisruptionEvents additionalDisruptionEvents) {
		ComparisonResult result = executeDataRule(additionalDisruptionEvents);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AdditionalDisruptionEvents", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalDisruptionEvents", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AdditionalDisruptionEvents additionalDisruptionEvents) {
		if (ruleIsApplicable(additionalDisruptionEvents).get()) {
			return evaluateThenExpression(additionalDisruptionEvents);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AdditionalDisruptionEvents additionalDisruptionEvents) {
		try {
			return exists(MapperS.of(additionalDisruptionEvents).<AncillaryRoleEnum>map("getDeterminingParty", _additionalDisruptionEvents -> _additionalDisruptionEvents.getDeterminingParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AdditionalDisruptionEvents additionalDisruptionEvents) {
		try {
			return areEqual(MapperS.of(additionalDisruptionEvents).<AncillaryRoleEnum>map("getDeterminingParty", _additionalDisruptionEvents -> _additionalDisruptionEvents.getDeterminingParty()), MapperS.of(AncillaryRoleEnum.DISRUPTION_EVENTS_DETERMINING_PARTY), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
