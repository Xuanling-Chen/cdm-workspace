package cdm.event.common.functions;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.TimeZone;
import cdm.base.datetime.TimeZone.TimeZoneBuilder;
import cdm.base.datetime.functions.TimeZoneFromBusinessCenterTime;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.observable.asset.EquityValuation;
import cdm.observable.common.DeterminationMethodEnum;
import cdm.observable.common.TimeTypeEnum;
import cdm.observable.common.functions.ResolveTimeZoneFromTimeType;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ResolveEquityValuationTime.ResolveEquityValuationTimeDefault.class)
public abstract class ResolveEquityValuationTime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ResolveTimeZoneFromTimeType resolveTimeZoneFromTimeType;
	@Inject protected TimeZoneFromBusinessCenterTime timeZoneFromBusinessCenterTime;

	/**
	* @param equityValuation Represents the Equity Valuation terms from the Equity product definition.
	* @param productIdentifier Specifies the product identifier, along with the source, which should be used to determine the correct valuation time i.e. close times are different across exchanges.
	* @return time 
	*/
	public TimeZone evaluate(EquityValuation equityValuation, ProductIdentifier productIdentifier) {
		
		TimeZone.TimeZoneBuilder timeHolder = doEvaluate(equityValuation, productIdentifier);
		TimeZone.TimeZoneBuilder time = assignOutput(timeHolder, equityValuation, productIdentifier);
		
		if (time!=null) objectValidator.validateAndFailOnErorr(TimeZone.class, time);
		return time;
	}
	
	private TimeZone.TimeZoneBuilder assignOutput(TimeZone.TimeZoneBuilder time, EquityValuation equityValuation, ProductIdentifier productIdentifier) {
		time = toBuilder(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(valuationTime(equityValuation, productIdentifier).get())).get()) {
					return MapperS.of(timeZoneFromBusinessCenterTime.evaluate(MapperS.of(valuationTime(equityValuation, productIdentifier).get()).get()));
				}
		else {
					return MapperS.ofNull();
				}
		}).get())
		;
		time = toBuilder(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperS.of(timeType(equityValuation, productIdentifier).get())).get()) {
					return MapperS.of(resolveTimeZoneFromTimeType.evaluate(MapperS.of(productIdentifier).get(), MapperS.of(timeType(equityValuation, productIdentifier).get()).get(), MapperS.of(equityValuation).<DeterminationMethodEnum>map("getDeterminationMethod", _equityValuation -> _equityValuation.getDeterminationMethod()).get()));
				}
		else {
					return MapperS.ofNull();
				}
		}).get())
		;
		return time;
	}

	protected abstract TimeZone.TimeZoneBuilder doEvaluate(EquityValuation equityValuation, ProductIdentifier productIdentifier);
	
	
	protected Mapper<? extends BusinessCenterTime> valuationTime(EquityValuation equityValuation, ProductIdentifier productIdentifier) {
		return MapperS.of(equityValuation).<BusinessCenterTime>map("getValuationTime", _equityValuation -> _equityValuation.getValuationTime());
	}
	
	protected Mapper<TimeTypeEnum> timeType(EquityValuation equityValuation, ProductIdentifier productIdentifier) {
		return MapperS.of(equityValuation).<TimeTypeEnum>map("getValuationTimeType", _equityValuation -> _equityValuation.getValuationTimeType());
	}
	public static final class ResolveEquityValuationTimeDefault extends ResolveEquityValuationTime {
		@Override
		protected  TimeZone.TimeZoneBuilder doEvaluate(EquityValuation equityValuation, ProductIdentifier productIdentifier) {
			return TimeZone.builder();
		}
	}
}
