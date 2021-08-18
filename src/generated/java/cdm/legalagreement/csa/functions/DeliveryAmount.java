package cdm.legalagreement.csa.functions;

import cdm.base.math.RoundingModeEnum;
import cdm.base.math.UnitType;
import cdm.base.math.functions.Max;
import cdm.base.math.functions.RoundToNearest;
import cdm.legalagreement.csa.CollateralRounding;
import cdm.legalagreement.csa.MarginApproachEnum;
import cdm.legalagreement.csa.PostedCreditSupportItem;
import cdm.legalagreement.csa.functions.CreditSupportAmount;
import cdm.legalagreement.csa.functions.UndisputedAdjustedPostedCreditSupportAmount;
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

@ImplementedBy(DeliveryAmount.DeliveryAmountDefault.class)
public abstract class DeliveryAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreditSupportAmount creditSupportAmount;
	@Inject protected Max max;
	@Inject protected RoundToNearest roundToNearest;
	@Inject protected UndisputedAdjustedPostedCreditSupportAmount undisputedAdjustedPostedCreditSupportAmount;

	/**
	* @param postedCreditSupportItems 
	* @param priorDeliveryAmountAdjustment The adjustment value to include any prior Delivery Amount (IM), the transfer of which has not yet been completed and for which the relevant Regular Settlement Day falls on or prior to such Calculation Date (IM)).  See Paragraph 3 (a) (ii).
	* @param priorReturnAmountAdjustment The adjustment value to exclude any prior Return Amount (IM), the transfer of which has not yet been completed and for which the relevant Regular Settlement Day falls on or prior to such Calculation Date (IM)).  See Paragraph 3 (a) (ii).
	* @param disputedTransferredPostedCreditSupportAmount Paragraph 5. If a party (a &#39;Disputing Party&#39;) disputes the Value of any Transfer of Eligible Credit Support.
	* @param marginAmount Paragraph 3 (c) (i) Margin Amount (IM) means, for any Calculation Date (IM) and a posting obligation of a Pledgor under a Regime, the Base Currency Equivalent of an amount equal to the sum of the initial margin amounts in respect of the Covered Transactions (IM) determined using the Method specified as applicable to such Regime in Paragraph 13.
	* @param threshold Threshold (IM) means, with respect to a party, the Base Currency Equivalent of the amount specified as such for that party in Paragraph 13 and, if no amount is specified, zero.
	* @param marginApproach Margin Approach has the meaning specified in Paragraph 3 (c) (iii).
	* @param marginAmountIA Paragraph 3 (c) (ii) Margin Amount (IA) means, for any Calculation Date (IM) and a posting obligation of a Pledgor, the Base Currency Equivalent of an amount equal to the sum of the Independent Amounts (as defined in any Other CSA) applicable to the Pledgor and any other amounts applicable to the Pledgor (other than any amounts in respect of Margin Amount (IM) or Exposure), however described, intended by the parties to operate as an Independent Amount, if any, after taking into account any relevant Threshold applicable to the Pledgor and any other relevant amounts applicable to the Pledgor, however described, intended by the parties to operate as a Threshold but prior to giving effect to any other applicable deduction, discharge or netting of such amounts, under or in relation to this Agreement, as determined and reported by the party responsible for calculating such amounts.  For the avoidance of doubt, in order to determine the amounts &#39;applicable to the Pledgor&#39; for the purposes hereof, the parties will take into account the effect of any conditions precedent applicable to such amounts.
	* @param minimumTransferAmount Minimum Transfer Amount (IM) means, with respect to a party, the Base Currency Equivalent of the amount specified as such for that party in Paragraph 13 and, if no amount is specified, zero.
	* @param rounding Rounding methodology applicable to the Delivery Amount and the Return Amount in terms of nearest integral multiple of Base Currency units. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(vi)(C): Rounding. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (c)(vi)(C): Rounding.
	* @param disputedDeliveryAmount Paragraph 5. If a party (a &#39;Disputing Party&#39;) disputes the the Calculation Agent (IM)’s calculation of a Delivery Amount (IM).
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
		// pre-conditions
		
			assert
				areEqual(MapperS.of(baseCurrency), MapperS.of(minimumTransferAmount).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All).and(areEqual(MapperS.of(baseCurrency), MapperS.of(disputedDeliveryAmount).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).get()
				: "";
		
		Money.MoneyBuilder resultHolder = doEvaluate(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency);
		Money.MoneyBuilder result = assignOutput(resultHolder, postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Money.class, result);
		return result;
	}
	
	private Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
		result
			.setAmount(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (greaterThanEquals(MapperS.of(undisputedDeliveryAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).get()), MapperS.of(minimumTransferAmount).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), CardinalityOperator.All).get()) {
						return MapperS.of(roundToNearest.evaluate(MapperS.of(undisputedDeliveryAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).get()).get(), MapperS.of(rounding).<BigDecimal>map("getDeliveryAmount", _collateralRounding -> _collateralRounding.getDeliveryAmount()).get(), MapperS.of(RoundingModeEnum.UP).get()));
					}
			else {
						return MapperS.of(BigDecimal.valueOf(0.0));
					}
			}).get())
		;
		result
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(baseCurrency).get())
		;
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency);
	
	
	protected Mapper<? extends Money> undisputedAdjustedPostedCreditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
		return MapperS.of(undisputedAdjustedPostedCreditSupportAmount.evaluate(MapperC.of(postedCreditSupportItems).getMulti(), MapperS.of(priorDeliveryAmountAdjustment).get(), MapperS.of(priorReturnAmountAdjustment).get(), MapperS.of(disputedTransferredPostedCreditSupportAmount).get(), MapperS.of(baseCurrency).get()));
	}
	
	protected Mapper<? extends Money> creditSupportAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
		return MapperS.of(creditSupportAmount.evaluate(MapperS.of(marginAmount).get(), MapperS.of(threshold).get(), MapperS.of(marginApproach).get(), MapperS.of(marginAmountIA).get(), MapperS.of(baseCurrency).get()));
	}
	
	protected Mapper<BigDecimal> deliveryAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
		return MapperS.of(max.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(creditSupportAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(undisputedAdjustedPostedCreditSupportAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).get()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())).get(), MapperS.of(BigDecimal.valueOf(0.0)).get()));
	}
	
	protected Mapper<BigDecimal> undisputedDeliveryAmount(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
		return MapperS.of(max.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(deliveryAmount(postedCreditSupportItems, priorDeliveryAmountAdjustment, priorReturnAmountAdjustment, disputedTransferredPostedCreditSupportAmount, marginAmount, threshold, marginApproach, marginAmountIA, minimumTransferAmount, rounding, disputedDeliveryAmount, baseCurrency).get()), MapperS.of(disputedDeliveryAmount).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())).get(), MapperS.of(BigDecimal.valueOf(0.0)).get()));
	}
	public static final class DeliveryAmountDefault extends DeliveryAmount {
		@Override
		protected  Money.MoneyBuilder doEvaluate(List<? extends PostedCreditSupportItem> postedCreditSupportItems, Money priorDeliveryAmountAdjustment, Money priorReturnAmountAdjustment, Money disputedTransferredPostedCreditSupportAmount, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, Money minimumTransferAmount, CollateralRounding rounding, Money disputedDeliveryAmount, String baseCurrency) {
			return Money.builder();
		}
	}
}
