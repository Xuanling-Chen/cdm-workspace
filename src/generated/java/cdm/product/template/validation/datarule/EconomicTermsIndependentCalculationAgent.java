package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.observable.asset.CalculationAgent;
import cdm.product.template.EconomicTerms;
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
@RosettaDataRule("EconomicTermsIndependentCalculationAgent")
public class EconomicTermsIndependentCalculationAgent implements Validator<EconomicTerms> {
	
	private static final String NAME = "EconomicTermsIndependentCalculationAgent";
	private static final String DEFINITION = "if calculationAgent -> calculationAgentParty exists then calculationAgent -> calculationAgentParty = AncillaryRoleEnum -> CalculationAgentIndependent";
	
	
	@Override
	public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
		ComparisonResult result = executeDataRule(economicTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EconomicTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
		if (ruleIsApplicable(economicTerms).get()) {
			return evaluateThenExpression(economicTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EconomicTerms economicTerms) {
		try {
			return exists(MapperS.of(economicTerms).<CalculationAgent>map("getCalculationAgent", _economicTerms -> _economicTerms.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EconomicTerms economicTerms) {
		try {
			return areEqual(MapperS.of(economicTerms).<CalculationAgent>map("getCalculationAgent", _economicTerms -> _economicTerms.getCalculationAgent()).<AncillaryRoleEnum>map("getCalculationAgentParty", _calculationAgent -> _calculationAgent.getCalculationAgentParty()), MapperS.of(AncillaryRoleEnum.CALCULATION_AGENT_INDEPENDENT), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
