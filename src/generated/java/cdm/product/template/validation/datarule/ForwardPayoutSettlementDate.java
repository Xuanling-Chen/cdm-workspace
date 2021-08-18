package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.product.asset.functions.ForwardFX;
import cdm.product.common.settlement.Cashflow;
import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.ForwardPayout;
import com.google.inject.Inject;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ForwardPayoutSettlementDate")
public class ForwardPayoutSettlementDate implements Validator<ForwardPayout> {
	
	private static final String NAME = "ForwardPayoutSettlementDate";
	private static final String DEFINITION = "if ForwardFX() exists then (settlementTerms -> settlementDate -> valueDate exists and ForwardFX() -> exchangedCurrency1 -> cashflowDate is absent and ForwardFX() -> exchangedCurrency2 -> cashflowDate is absent) or (settlementTerms -> settlementDate -> valueDate is absent and ForwardFX() -> exchangedCurrency1 -> cashflowDate exists and ForwardFX() -> exchangedCurrency2 -> cashflowDate exists and ForwardFX() -> exchangedCurrency1 -> cashflowDate = ForwardFX() -> exchangedCurrency2 -> cashflowDate)";
	
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
			return exists(MapperS.of(forwardPayout).<SettlementTerms>map("getSettlementTerms", _forwardPayout -> _forwardPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", _settlementBase -> _settlementBase.getSettlementDate()).<Date>map("getValueDate", _settlementDate -> _settlementDate.getValueDate())).and(notExists(MapperS.of(forwardFX.evaluate(forwardPayout)).<Cashflow>map("getExchangedCurrency1", _foreignExchange -> _foreignExchange.getExchangedCurrency1()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()))).and(notExists(MapperS.of(forwardFX.evaluate(forwardPayout)).<Cashflow>map("getExchangedCurrency2", _foreignExchange -> _foreignExchange.getExchangedCurrency2()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()))).or(notExists(MapperS.of(forwardPayout).<SettlementTerms>map("getSettlementTerms", _forwardPayout -> _forwardPayout.getSettlementTerms()).<SettlementDate>map("getSettlementDate", _settlementBase -> _settlementBase.getSettlementDate()).<Date>map("getValueDate", _settlementDate -> _settlementDate.getValueDate())).and(exists(MapperS.of(forwardFX.evaluate(forwardPayout)).<Cashflow>map("getExchangedCurrency1", _foreignExchange -> _foreignExchange.getExchangedCurrency1()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()))).and(exists(MapperS.of(forwardFX.evaluate(forwardPayout)).<Cashflow>map("getExchangedCurrency2", _foreignExchange -> _foreignExchange.getExchangedCurrency2()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()))).and(areEqual(MapperS.of(forwardFX.evaluate(forwardPayout)).<Cashflow>map("getExchangedCurrency1", _foreignExchange -> _foreignExchange.getExchangedCurrency1()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()), MapperS.of(forwardFX.evaluate(forwardPayout)).<Cashflow>map("getExchangedCurrency2", _foreignExchange -> _foreignExchange.getExchangedCurrency2()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()), CardinalityOperator.All)));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
