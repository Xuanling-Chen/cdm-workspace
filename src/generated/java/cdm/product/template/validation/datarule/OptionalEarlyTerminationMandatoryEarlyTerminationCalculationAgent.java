package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.product.template.OptionalEarlyTermination;
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
@RosettaDataRule("OptionalEarlyTerminationMandatoryEarlyTerminationCalculationAgent")
public class OptionalEarlyTerminationMandatoryEarlyTerminationCalculationAgent implements Validator<OptionalEarlyTermination> {
	
	private static final String NAME = "OptionalEarlyTerminationMandatoryEarlyTerminationCalculationAgent";
	private static final String DEFINITION = "if calculationAgent -> calculationAgentParty exists then calculationAgent -> calculationAgentParty = AncillaryRoleEnum -> CalculationAgentOptionalEarlyTermination";
	
	
	@Override
	public ValidationResult<OptionalEarlyTermination> validate(RosettaPath path, OptionalEarlyTermination optionalEarlyTermination) {
		ComparisonResult result = executeDataRule(optionalEarlyTermination);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "OptionalEarlyTermination", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionalEarlyTermination", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(OptionalEarlyTermination optionalEarlyTermination) {
		if (ruleIsApplicable(optionalEarlyTermination).get()) {
			return evaluateThenExpression(optionalEarlyTermination);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(OptionalEarlyTermination optionalEarlyTermination) {
		try {
			return exists(MapperS.of(optionalEarlyTermination).<CalculationAgent>map("getCalculationAgent", _optionalEarlyTermination -> _optionalEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(OptionalEarlyTermination optionalEarlyTermination) {
		try {
			return areEqual(MapperS.of(optionalEarlyTermination).<CalculationAgent>map("getCalculationAgent", _optionalEarlyTermination -> _optionalEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_OPTIONAL_EARLY_TERMINATION), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
