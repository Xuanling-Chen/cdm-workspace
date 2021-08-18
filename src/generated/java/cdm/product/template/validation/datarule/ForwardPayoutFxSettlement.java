package cdm.product.template.validation.datarule;

import cdm.product.asset.functions.ForwardFX;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.ForwardPayout;
import com.google.inject.Inject;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ForwardPayoutFxSettlement")
public class ForwardPayoutFxSettlement implements Validator<ForwardPayout> {
	
	private static final String NAME = "ForwardPayoutFxSettlement";
	private static final String DEFINITION = "if ForwardFX() exists then settlementTerms -> physicalSettlementTerms is absent";
	
	@Inject protected ForwardFX forwardFX;
	
	@Override
	public ValidationResult<ForwardPayout> validate(RosettaPath path, ForwardPayout forwardPayout) {
		ComparisonResult result = executeDataRule(forwardPayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ForwardPayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ForwardPayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ForwardPayout forwardPayout) {
		if (ruleIsApplicable(forwardPayout).get()) {
			return evaluateThenExpression(forwardPayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ForwardPayout forwardPayout) {
		try {
			return exists(MapperS.of(forwardFX.evaluate(forwardPayout)));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ForwardPayout forwardPayout) {
		try {
			return notExists(MapperS.of(forwardPayout).<SettlementTerms>map("getSettlementTerms", _forwardPayout -> _forwardPayout.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
