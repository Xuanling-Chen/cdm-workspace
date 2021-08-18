package cdm.product.asset.validation.datarule;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import cdm.observable.asset.FxSpotRateSource;
import cdm.observable.asset.ValuationMethod;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.schedule.FxLinkedNotionalSchedule;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.QuantityMultiplier;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.ValuationDate;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InterestRatePayoutCashSettlementTerms")
public class InterestRatePayoutCashSettlementTerms implements Validator<InterestRatePayout> {
	
	private static final String NAME = "InterestRatePayoutCashSettlementTerms";
	private static final String DEFINITION = "if settlementTerms -> settlementCurrency exists and (settlementTerms -> settlementCurrency <> payoutQuantity -> quantitySchedule -> initialQuantity -> unitOfAmount -> currency or settlementTerms -> settlementCurrency <> payoutQuantity -> quantityMultiplier -> fxLinkedNotionalSchedule -> varyingNotionalCurrency) then (settlementTerms -> cashSettlementTerms -> valuationMethod and settlementTerms -> cashSettlementTerms -> valuationDate) exists or payoutQuantity -> quantityMultiplier -> fxLinkedNotionalSchedule -> fxSpotRateSource exists";
	
	
	@Override
	public ValidationResult<InterestRatePayout> validate(RosettaPath path, InterestRatePayout interestRatePayout) {
		ComparisonResult result = executeDataRule(interestRatePayout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "InterestRatePayout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestRatePayout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(InterestRatePayout interestRatePayout) {
		if (ruleIsApplicable(interestRatePayout).get()) {
			return evaluateThenExpression(interestRatePayout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(InterestRatePayout interestRatePayout) {
		try {
			return exists(MapperS.of(interestRatePayout).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<FieldWithMetaString>map("getSettlementCurrency", _settlementBase -> _settlementBase.getSettlementCurrency()).<String>map("getValue", _f->_f.getValue())).and(notEqual(MapperS.of(interestRatePayout).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<FieldWithMetaString>map("getSettlementCurrency", _settlementBase -> _settlementBase.getSettlementCurrency()).<String>map("getValue", _f->_f.getValue()), MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<NonNegativeQuantitySchedule>map("getQuantitySchedule", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantitySchedule()).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.Any).or(notEqual(MapperS.of(interestRatePayout).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<FieldWithMetaString>map("getSettlementCurrency", _settlementBase -> _settlementBase.getSettlementCurrency()).<String>map("getValue", _f->_f.getValue()), MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<QuantityMultiplier>map("getQuantityMultiplier", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantityMultiplier()).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", _quantityMultiplier -> _quantityMultiplier.getFxLinkedNotionalSchedule()).<FieldWithMetaString>map("getVaryingNotionalCurrency", _fxLinkedNotionalSchedule -> _fxLinkedNotionalSchedule.getVaryingNotionalCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.Any)));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(InterestRatePayout interestRatePayout) {
		try {
			return exists(MapperTree.andDifferent(MapperTree.of(MapperS.of(interestRatePayout).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()).<ValuationMethod>map("getValuationMethod", _cashSettlementTerms -> _cashSettlementTerms.getValuationMethod())), MapperTree.of(MapperS.of(interestRatePayout).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()).<ValuationDate>map("getValuationDate", _cashSettlementTerms -> _cashSettlementTerms.getValuationDate())))).or(exists(MapperS.of(interestRatePayout).<ResolvablePayoutQuantity>map("getPayoutQuantity", _payoutBase -> _payoutBase.getPayoutQuantity()).<QuantityMultiplier>map("getQuantityMultiplier", _resolvablePayoutQuantity -> _resolvablePayoutQuantity.getQuantityMultiplier()).<FxLinkedNotionalSchedule>map("getFxLinkedNotionalSchedule", _quantityMultiplier -> _quantityMultiplier.getFxLinkedNotionalSchedule()).<FxSpotRateSource>map("getFxSpotRateSource", _fxLinkedNotionalSchedule -> _fxLinkedNotionalSchedule.getFxSpotRateSource())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
