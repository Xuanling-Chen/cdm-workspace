package cdm.event.common.functions;

import cdm.observable.asset.FloatingRateOption;
import cdm.observable.asset.metafields.ReferenceWithMetaFloatingRateOption;
import cdm.observable.event.ObservationIdentifier;
import cdm.observable.event.ObservationIdentifier.ObservationIdentifierBuilder;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(ResolveInterestRateObservationIdentifiers.ResolveInterestRateObservationIdentifiersDefault.class)
public abstract class ResolveInterestRateObservationIdentifiers implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param payout 
	* @param date 
	* @return identifiers 
	*/
	public ObservationIdentifier evaluate(InterestRatePayout payout, Date date) {
		
		ObservationIdentifier.ObservationIdentifierBuilder identifiersHolder = doEvaluate(payout, date);
		ObservationIdentifier.ObservationIdentifierBuilder identifiers = assignOutput(identifiersHolder, payout, date);
		
		if (identifiers!=null) objectValidator.validateAndFailOnErorr(ObservationIdentifier.class, identifiers);
		return identifiers;
	}
	
	private ObservationIdentifier.ObservationIdentifierBuilder assignOutput(ObservationIdentifier.ObservationIdentifierBuilder identifiers, InterestRatePayout payout, Date date) {
		identifiers
			.getOrCreateObservable()
			.setRateOptionValue(MapperS.of(payout).<RateSpecification>map("getRateSpecification", _interestRatePayout -> _interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRate", _rateSpecification -> _rateSpecification.getFloatingRate()).<ReferenceWithMetaFloatingRateOption>map("getRateOption", _floatingRate -> _floatingRate.getRateOption()).<FloatingRateOption>map("getValue", _f->_f.getValue()).get())
		;
		identifiers
			.setObservationDate(MapperS.of(date).get())
		;
		return identifiers;
	}

	protected abstract ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(InterestRatePayout payout, Date date);
	
	public static final class ResolveInterestRateObservationIdentifiersDefault extends ResolveInterestRateObservationIdentifiers {
		@Override
		protected  ObservationIdentifier.ObservationIdentifierBuilder doEvaluate(InterestRatePayout payout, Date date) {
			return ObservationIdentifier.builder();
		}
	}
}
