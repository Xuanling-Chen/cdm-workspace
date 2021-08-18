package cdm.legalagreement.csa.functions;

import cdm.base.math.UnitType;
import cdm.legalagreement.csa.PostedCreditSupportItem;
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

@ImplementedBy(PostedCreditSupportItemAmount.PostedCreditSupportItemAmountDefault.class)
public abstract class PostedCreditSupportItemAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param item 
	* @param baseCurrency Base Currency means the currency specified as such in Paragraph 13.
	* @return result 
	*/
	public Money evaluate(PostedCreditSupportItem item, String baseCurrency) {
		// pre-conditions
		
			assert
				areEqual(MapperS.of(baseCurrency), MapperS.of(item).<Money>map("getCashOrSecurityValue", _postedCreditSupportItem -> _postedCreditSupportItem.getCashOrSecurityValue()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All).and(areEqual(MapperS.of(baseCurrency), MapperS.of(item).<Money>map("getDisputedCashOrSecurityValue", _postedCreditSupportItem -> _postedCreditSupportItem.getDisputedCashOrSecurityValue()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).get()
				: "";
		
		Money.MoneyBuilder resultHolder = doEvaluate(item, baseCurrency);
		Money.MoneyBuilder result = assignOutput(resultHolder, item, baseCurrency);
		
		if (result!=null) objectValidator.validateAndFailOnErorr(Money.class, result);
		return result;
	}
	
	private Money.MoneyBuilder assignOutput(Money.MoneyBuilder result, PostedCreditSupportItem item, String baseCurrency) {
		result
			.setAmount(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(postedCreditSupportAmount(item, baseCurrency).get()), MapperS.of(item).<Money>map("getDisputedCashOrSecurityValue", _postedCreditSupportItem -> _postedCreditSupportItem.getDisputedCashOrSecurityValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())).get())
		;
		result
			.getOrCreateUnitOfAmount()
			.setCurrencyValue(MapperS.of(baseCurrency).get())
		;
		return result;
	}

	protected abstract Money.MoneyBuilder doEvaluate(PostedCreditSupportItem item, String baseCurrency);
	
	
	protected Mapper<BigDecimal> cashOrSecurityValue(PostedCreditSupportItem item, String baseCurrency) {
		return MapperS.of(item).<Money>map("getCashOrSecurityValue", _postedCreditSupportItem -> _postedCreditSupportItem.getCashOrSecurityValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> haircutPercentage(PostedCreditSupportItem item, String baseCurrency) {
		return MapperS.of(item).<BigDecimal>map("getHaircutPercentage", _postedCreditSupportItem -> _postedCreditSupportItem.getHaircutPercentage());
	}
	
	protected Mapper<BigDecimal> fxHaircutPercentage(PostedCreditSupportItem item, String baseCurrency) {
		return MapperS.of(item).<BigDecimal>map("getFxHaircutPercentage", _postedCreditSupportItem -> _postedCreditSupportItem.getFxHaircutPercentage());
	}
	
	protected Mapper<BigDecimal> additionalHaircutPercentage(PostedCreditSupportItem item, String baseCurrency) {
		return MapperS.of(item).<BigDecimal>map("getFxHaircutPercentage", _postedCreditSupportItem -> _postedCreditSupportItem.getFxHaircutPercentage());
	}
	
	protected Mapper<BigDecimal> postedCreditSupportAmount(PostedCreditSupportItem item, String baseCurrency) {
		return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(cashOrSecurityValue(item, baseCurrency).get()), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>subtract(MapperS.of(BigDecimal.valueOf(1.00)), MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>add(MapperS.of(haircutPercentage(item, baseCurrency).get()), MapperS.of(fxHaircutPercentage(item, baseCurrency).get())), MapperS.of(additionalHaircutPercentage(item, baseCurrency).get()))));
	}
	public static final class PostedCreditSupportItemAmountDefault extends PostedCreditSupportItemAmount {
		@Override
		protected  Money.MoneyBuilder doEvaluate(PostedCreditSupportItem item, String baseCurrency) {
			return Money.builder();
		}
	}
}
