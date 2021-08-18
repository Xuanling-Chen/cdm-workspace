package cdm.observable.event.functions;

import cdm.base.staticdata.asset.common.AveragingCalculationMethodEnum;
import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
import cdm.observable.event.Observation;
import cdm.observable.event.functions.ResolveObservationAverage;
import cdm.product.template.SecurityFinancePayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(Create_SecurityFinanceReset.Create_SecurityFinanceResetDefault.class)
public abstract class Create_SecurityFinanceReset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected ResolveObservationAverage resolveObservationAverage;

	/**
	* @param securityFinancePayout Represents the SecurityFinancePayout to which the reset will apply.
	* @param observation Represents the observations that will be used to compute the reset value.
	* @param resetDate Specifies the date of the reset.
	* @return reset 
	*/
	public Reset evaluate(SecurityFinancePayout securityFinancePayout, List<? extends Observation> observation, Date resetDate) {
		
		Reset.ResetBuilder resetHolder = doEvaluate(securityFinancePayout, observation, resetDate);
		Reset.ResetBuilder reset = assignOutput(resetHolder, securityFinancePayout, observation, resetDate);
		
		if (reset!=null) objectValidator.validateAndFailOnErorr(Reset.class, reset);
		return reset;
	}
	
	private Reset.ResetBuilder assignOutput(Reset.ResetBuilder reset, SecurityFinancePayout securityFinancePayout, List<? extends Observation> observation, Date resetDate) {
		reset
			.setResetValue(MapperS.of(resolveObservationAverage.evaluate(MapperC.of(observation).getMulti())).get())
		;
		reset
			.setResetDate(MapperS.of(resetDate).get())
		;
		reset
			.addObservationsValue(MapperC.of(observation).getMulti())
		;
		reset
			.getOrCreateAggregationMethodology()
			.setAveragingCalculationMethod(MapperS.of(AveragingCalculationMethodEnum.ARITHMETIC).get())
		;
		return reset;
	}

	protected abstract Reset.ResetBuilder doEvaluate(SecurityFinancePayout securityFinancePayout, List<? extends Observation> observation, Date resetDate);
	
	public static final class Create_SecurityFinanceResetDefault extends Create_SecurityFinanceReset {
		@Override
		protected  Reset.ResetBuilder doEvaluate(SecurityFinancePayout securityFinancePayout, List<? extends Observation> observation, Date resetDate) {
			return Reset.builder();
		}
	}
}
