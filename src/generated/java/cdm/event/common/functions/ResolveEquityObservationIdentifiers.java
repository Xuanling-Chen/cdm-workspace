package cdm.event.common.functions;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import cdm.event.common.functions.ResolveEquityValuationDate;
import cdm.event.common.functions.ResolveEquityValuationTime;
import cdm.observable.asset.EquityValuation;
import cdm.observable.asset.Observable;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.observable.event.ObservationIdentifier;
import cdm.observable.event.ObservationIdentifier.ObservationIdentifierBuilder;
import cdm.product.asset.PriceReturnTerms;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.functions.CalculationPeriod;
import cdm.product.template.EquityPayout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(ResolveEquityObservationIdentifiers.ResolveEquityObservationIdentifiersDefault.class)
public abstract class ResolveEquityObservationIdentifiers implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CalculationPeriod calculationPeriod;
	@Inject protected ResolveEquityValuationDate resolveEquityValuationDate;
	@Inject protected ResolveEquityValuationTime resolveEquityValuationTime;

	/**
	* @param payout 
	* @param date 
	* @return identifiers 
	*/
	public ObservationIdentifier evaluate(EquityPayout payout, Date date) {
		
		ObservationIdentifier.ObservationIdentifierBuilder identifiersHolder = doEvaluate(payout, date);
		ObservationIdentifier.ObservationIdentifierBuilder identifiers = assignOutput(identifiersHolder, payout, date);
		
		if (identifiers!=null) objectValidator.validateAndFailOnErorr(ObservationIdentifier.class, identifiers);
		return identifiers;
	}
	
	private ObservationIdentifier.ObservationIdentifierBuilder assignOutput(ObservationIdentifier.ObservationIdentifierBuilder identifiers, EquityPayout payout, Date date) {
		identifiers
			.getOrCreateObservable()
			.addProductIdentifierValue(MapperS.of(MapperS.of(payout).<Product>map("getUnderlier", _equityPayout -> _equityPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<ReferenceWithMetaProductIdentifier>mapC("getProductIdentifier", _productBase -> _productBase.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue()).get()).get())
		;
		identifiers
			.setObservationDate(MapperS.of(resolveEquityValuationDate.evaluate(MapperS.of(equityValuation(payout, date).get()).get(), MapperS.of(date).get())).get())
		;
		identifiers
			.setObservationTime(MapperS.of(resolveEquityValuationTime.evaluate(MapperS.of(equityValuation(payout, date).get()).get(), MapperS.of(MapperS.of(identifiers).<Observable>map("getObservable", _observationIdentifier -> _observationIdentifier.getObservable()).<FieldWithMetaProductIdentifier>mapC("getProductIdentifier", _observable -> _observable.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue()).get()).get())).get())
		;
		identifiers
			.getOrCreateDeterminationMethodology()
			.setDeterminationMethod(MapperS.of(equityValuation(payout, date).get()).<DeterminationMethodEnum>map("getDeterminationMethod", _equityValuation -> _equityValuation.getDeterminationMethod()).get())
		;
		return identifiers;
	}

	protected abstract ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(EquityPayout payout, Date date);
	
	
	protected Mapper<Date> periodEndDate(EquityPayout payout, Date date) {
		return MapperS.of(calculationPeriod.evaluate(MapperS.of(payout).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).get(), MapperS.of(date).get())).<Date>map("getEndDate", _calculationPeriodData -> _calculationPeriodData.getEndDate());
	}
	
	protected Mapper<? extends EquityValuation> equityValuation(EquityPayout payout, Date date) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (MapperS.of(calculationPeriod.evaluate(MapperS.of(payout).<CalculationPeriodDates>map("getCalculationPeriodDates", _equityPayout -> _equityPayout.getCalculationPeriodDates()).get(), MapperS.of(periodEndDate(payout, date).get()).get())).<Boolean>map("getIsLastPeriod", _calculationPeriodData -> _calculationPeriodData.getIsLastPeriod()).get()) {
					return MapperS.of(payout).<PriceReturnTerms>map("getPriceReturnTerms", _equityPayout -> _equityPayout.getPriceReturnTerms()).<EquityValuation>map("getValuationPriceFinal", _priceReturnTerms -> _priceReturnTerms.getValuationPriceFinal());
				}
		else {
					return MapperS.of(payout).<PriceReturnTerms>map("getPriceReturnTerms", _equityPayout -> _equityPayout.getPriceReturnTerms()).<EquityValuation>map("getValuationPriceInterim", _priceReturnTerms -> _priceReturnTerms.getValuationPriceInterim());
				}
		});
	}
	public static final class ResolveEquityObservationIdentifiersDefault extends ResolveEquityObservationIdentifiers {
		@Override
		protected  ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(EquityPayout payout, Date date) {
			return ObservationIdentifier.builder();
		}
	}
}
