package cdm.legalagreement.csa.functions;

import cdm.base.math.UnitType;
import cdm.legalagreement.csa.PostedCreditSupportItem;
import cdm.legalagreement.csa.functions.SumPostedCreditSupportItemAmounts;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(UndisputedAdjustedPostedCreditSupportAmount.UndisputedAdjustedPostedCreditSupportAmountDefault.class)
public abstract class UndisputedAdjustedPostedCreditSupportAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected SumPostedCreditSupportItemAmounts sumPostedCreditSupportItemAmounts;

	/**
	* @param postedCreditSupportItems 
	* @param priorDeliveryAmountAdjustment The adjustment value to include any prior Delivery Amount (IM), the transfer of which has not yet been completed and for which the relevant Regular Settlement Day falls on or prior to such Calculation Date (IM)).  See Paragraph 3 (a) (ii).
	* @param priorReturnAmountAdjustment The adjustment value to exclude any prior Return Amount (IM), the transfer of which has not yet been completed and for which the relevant Regular Settlement Day falls on or prior to such Calculation Date (IM)).  See Paragraph 3 (a) (ii).
	* @param disputedTransferredPostedCreditSupportAmount Paragraph 5. If a party (a &#39;Disputing Party&#39;) disputes the Value of any Transfer of Eligible Credit Support.
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
		// pre-conditions
		
			assert
				areEqual(MapperS.of(baseCurrency), MapperS.of(priorDeliveryAmountAdjustment).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All).and(areEqual(MapperS.of(baseCurrency), MapperS.of(priorReturnAmountAdjustment).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).and(areEqual(MapperS.of(baseCurrency), MapperS.of(disputedTransferredPostedCreditSupportAmount).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).get()
				: "";
		
		Money.MoneyBuilder resultHolder = doEvaluate(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency);
		Money.MoneyBuilder result = assignOutput(resultHolder, postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Money.class, result);
		return result;
	}
	
	private Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
		result
			.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(adjustedPostedCreditSupportAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency).get()), MapperS.of(disputedTransferredPostedCreditSupportAmount).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())).get())
		;
		result
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(baseCurrency).get())
		;
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency);
	
	
	protected Mapper<? extends Money> totalPostedCreditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
		return MapperS.of(sumPostedCreditSupportItemAmounts.evaluate(MapperC.of(postedCreditSupportItems).getMulti(), MapperS.of(baseCurrency).get()));
	}
	
	protected Mapper<BigDecimal> adjustedPostedCreditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
		return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperS.of(totalPostedCreditSupportAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, baseCurrency).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(priorDeliveryAmountAdjustment).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())), MapperS.of(priorReturnAmountAdjustment).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()));
	}
	public static final class UndisputedAdjustedPostedCreditSupportAmountDefault extends UndisputedAdjustedPostedCreditSupportAmount {
		@Override
		protected  Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, String baseCurrency) {
			return Money.builder();
		}
	}
}
