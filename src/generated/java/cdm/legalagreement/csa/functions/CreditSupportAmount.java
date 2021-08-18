package cdm.legalagreement.csa.functions;

import cdm.base.math.UnitType;
import cdm.base.math.functions.Max;
import cdm.legalagreement.csa.MarginApproachEnum;
import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(CreditSupportAmount.CreditSupportAmountDefault.class)
public abstract class CreditSupportAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Max max;

	/**
	* @param marginAmount 2018 Credit Support Annex For Initial Margin, Paragraph 3 (c) (i) Margin Amount (IM) means, for any Calculation Date (IM) and a posting obligation of a Pledgor under a Regime, the Base Currency Equivalent of an amount equal to the sum of the initial margin amounts in respect of the Covered Transactions (IM) determined using the Method specified as applicable to such Regime in Paragraph 13.
	* @param threshold Threshold (IM) means, with respect to a party, the Base Currency Equivalent of the amount specified as such for that party in Paragraph 13 and, if no amount is specified, zero.
	* @param marginApproach Margin Approach has the meaning specified in Paragraph 3 (c) (iii).
	* @param marginAmountIA Paragraph 3 (c) (ii)  Margin Amount (IA) means, for any Calculation Date (IM) and a posting obligation of a Pledgor, the Base Currency Equivalent of an amount equal to the sum of the Independent Amounts (as defined in any Other CSA) applicable to the Pledgor and any other amounts applicable to the Pledgor (other than any amounts in respect of Margin Amount (IM) or Exposure), however described, intended by the parties to operate as an Independent Amount, if any, after taking into account any relevant Threshold applicable to the Pledgor and any other relevant amounts applicable to the Pledgor, however described, intended by the parties to operate as a Threshold but prior to giving effect to any other applicable deduction, discharge or netting of such amounts, under or in relation to this Agreement, as determined and reported by the party responsible for calculating such amounts.  For the avoidance of doubt, in order to determine the amounts &#39;applicable to the Pledgor&#39; for the purposes hereof, the parties will take into account the effect of any conditions precedent applicable to such amounts.
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
		// pre-conditions
		
			assert
				areEqual(MapperS.of(baseCurrency), MapperS.of(marginAmount).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All).and(areEqual(MapperS.of(baseCurrency), MapperS.of(threshold).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).and(com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (exists(MapperS.of(marginAmountIA)).get()) {
							return areEqual(MapperS.of(baseCurrency), MapperS.of(marginAmountIA).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All);
						}
				else {
							return MapperS.of(Boolean.valueOf(true));
						}
				}))).get()
				: "";
		
			assert
				com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
				if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.DISTINCT), CardinalityOperator.All).or(areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.ALLOCATED), CardinalityOperator.All)).get()) {
							return notExists(MapperS.of(marginAmountIA));
						}
						else if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.GREATER_OF), CardinalityOperator.All).get()) {
							return exists(MapperS.of(marginAmountIA));
						}
						else {
							return MapperS.ofNull();
						}
				})).get()
				: "";
		
		Money.MoneyBuilder resultHolder = doEvaluate(marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency);
		Money.MoneyBuilder result = assignOutput(resultHolder, marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Money.class, result);
		return result;
	}
	
	private Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
		result
			.setAmount(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.DISTINCT), CardinalityOperator.All).or(areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.ALLOCATED), CardinalityOperator.All)).get()) {
						return MapperS.of(creditSupportAmountCalc(marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency).get());
					}
					else if (areEqual(MapperS.of(marginApproach), MapperS.of(MarginApproachEnum.GREATER_OF), CardinalityOperator.All).get()) {
						return MapperS.of(max.evaluate(MapperS.of(creditSupportAmountCalc(marginAmount, threshold, marginApproach, marginAmountIA, baseCurrency).get()).get(), MapperS.of(marginAmountIA).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()).get()));
					}
					else {
						return MapperS.ofNull();
					}
			}).get())
		;
		result
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(baseCurrency).get())
		;
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency);
	
	
	protected Mapper<BigDecimal> creditSupportAmountCalc(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
		return MapperS.of(max.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(marginAmount).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(threshold).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())).get(), MapperS.of(BigDecimal.valueOf(0.0)).get()));
	}
	public static final class CreditSupportAmountDefault extends CreditSupportAmount {
		@Override
		protected  Money.MoneyBuilder doEvaluate(Money marginAmount, Money threshold, MarginApproachEnum marginApproach, Money marginAmountIA, String baseCurrency) {
			return Money.builder();
		}
	}
}
