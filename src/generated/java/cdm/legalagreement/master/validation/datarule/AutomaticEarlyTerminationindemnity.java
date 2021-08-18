package cdm.legalagreement.master.validation.datarule;

import cdm.legalagreement.master.AutomaticEarlyTermination;
import cdm.legalagreement.master.AutomaticEarlyTerminationElection;
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
@RosettaDataRule("AutomaticEarlyTerminationindemnity")
public class AutomaticEarlyTerminationindemnity implements Validator<AutomaticEarlyTermination> {
	
	private static final String NAME = "AutomaticEarlyTerminationindemnity";
	private static final String DEFINITION = "if fallbackAET = False and partyElection->isApplicable all = False then indemnity = False";
	
	
	@Override
	public ValidationResult<AutomaticEarlyTermination> validate(RosettaPath path, AutomaticEarlyTermination automaticEarlyTermination) {
		ComparisonResult result = executeDataRule(automaticEarlyTermination);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AutomaticEarlyTermination", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AutomaticEarlyTermination", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AutomaticEarlyTermination automaticEarlyTermination) {
		if (ruleIsApplicable(automaticEarlyTermination).get()) {
			return evaluateThenExpression(automaticEarlyTermination);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AutomaticEarlyTermination automaticEarlyTermination) {
		try {
			return areEqual(MapperS.of(automaticEarlyTermination).<Boolean>map("getFallbackAET", _automaticEarlyTermination -> _automaticEarlyTermination.getFallbackAET()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All).and(areEqual(MapperS.of(automaticEarlyTermination).<AutomaticEarlyTerminationElection>mapC("getPartyElection", _automaticEarlyTermination -> _automaticEarlyTermination.getPartyElection()).<Boolean>map("getIsApplicable", _automaticEarlyTerminationElection -> _automaticEarlyTerminationElection.getIsApplicable()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AutomaticEarlyTermination automaticEarlyTermination) {
		try {
			return areEqual(MapperS.of(automaticEarlyTermination).<Boolean>map("getIndemnity", _automaticEarlyTermination -> _automaticEarlyTermination.getIndemnity()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
