package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.product.template.MandatoryEarlyTermination;
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
@RosettaDataRule("MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent")
public class MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent implements Validator<MandatoryEarlyTermination> {
	
	private static final String NAME = "MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent";
	private static final String DEFINITION = "if calculationAgent -> calculationAgentParty exists then calculationAgent -> calculationAgentParty = AncillaryRoleEnum -> CalculationAgentMandatoryEarlyTermination";
	
	
	@Override
	public ValidationResult<MandatoryEarlyTermination> validate(RosettaPath path, MandatoryEarlyTermination mandatoryEarlyTermination) {
		ComparisonResult result = executeDataRule(mandatoryEarlyTermination);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "MandatoryEarlyTermination", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTermination", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(MandatoryEarlyTermination mandatoryEarlyTermination) {
		if (ruleIsApplicable(mandatoryEarlyTermination).get()) {
			return evaluateThenExpression(mandatoryEarlyTermination);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(MandatoryEarlyTermination mandatoryEarlyTermination) {
		try {
			return exists(MapperS.of(mandatoryEarlyTermination).<CalculationAgent>map("getCalculationAgent", _mandatoryEarlyTermination -> _mandatoryEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(MandatoryEarlyTermination mandatoryEarlyTermination) {
		try {
			return areEqual(MapperS.of(mandatoryEarlyTermination).<CalculationAgent>map("getCalculationAgent", _mandatoryEarlyTermination -> _mandatoryEarlyTermination.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_MANDATORY_EARLY_TERMINATION), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
