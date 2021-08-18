package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.observable.asset.FallbackReferencePrice;
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
@RosettaDataRule("FallbackReferencePriceFallbackCalculationAgent")
public class FallbackReferencePriceFallbackCalculationAgent implements Validator<FallbackReferencePrice> {
	
	private static final String NAME = "FallbackReferencePriceFallbackCalculationAgent";
	private static final String DEFINITION = "if calculationAgentDetermination -> calculationAgentParty exists then calculationAgentDetermination -> calculationAgentParty = AncillaryRoleEnum -> CalculationAgentFallback";
	
	
	@Override
	public ValidationResult<FallbackReferencePrice> validate(RosettaPath path, FallbackReferencePrice fallbackReferencePrice) {
		ComparisonResult result = executeDataRule(fallbackReferencePrice);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "FallbackReferencePrice", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "FallbackReferencePrice", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(FallbackReferencePrice fallbackReferencePrice) {
		if (ruleIsApplicable(fallbackReferencePrice).get()) {
			return evaluateThenExpression(fallbackReferencePrice);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(FallbackReferencePrice fallbackReferencePrice) {
		try {
			return exists(MapperS.of(fallbackReferencePrice).<CalculationAgent>map("getCalculationAgentDetermination", _fallbackReferencePrice -> _fallbackReferencePrice.getCalculationAgentDetermination()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(FallbackReferencePrice fallbackReferencePrice) {
		try {
			return areEqual(MapperS.of(fallbackReferencePrice).<CalculationAgent>map("getCalculationAgentDetermination", _fallbackReferencePrice -> _fallbackReferencePrice.getCalculationAgentDetermination()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_FALLBACK), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
