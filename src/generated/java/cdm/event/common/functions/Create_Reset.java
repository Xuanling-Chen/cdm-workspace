package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ResetInstruction;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_ResetPrimitive;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.Optional;


@ImplementedBy(Create_Reset.Create_ResetDefault.class)
public abstract class Create_Reset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ResetPrimitive create_ResetPrimitive;

	/**
	* @param tradeState Specifies the trade to which the reset applies.
	* @param instruction Specifies the reset instructions.
	* @param date Specified the date of the reset event.
	* @return resetEvent Represents the Business Event created as a result of the reset.
	*/
	public BusinessEvent evaluate(TradeState tradeState, ResetInstruction instruction, Date date) {
		
		BusinessEvent.BusinessEventBuilder resetEventHolder = doEvaluate(tradeState, instruction, date);
		BusinessEvent.BusinessEventBuilder resetEvent = assignOutput(resetEventHolder, tradeState, instruction, date);
		
		if (resetEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, resetEvent);
		return resetEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder resetEvent, TradeState tradeState, ResetInstruction instruction, Date date) {
		resetEvent
			.getOrCreatePrimitives(0)
			.setReset(MapperS.of(create_ResetPrimitive.evaluate(MapperS.of(tradeState).get(), MapperS.of(instruction).get(), MapperS.of(date).get())).get())
		;
		resetEvent
			.getOrCreateEventEffect()
			.addEffectedTrade(ReferenceWithMetaTradeState.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(tradeState).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		return resetEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, ResetInstruction instruction, Date date);
	
	public static final class Create_ResetDefault extends Create_Reset {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, ResetInstruction instruction, Date date) {
			return BusinessEvent.builder();
		}
	}
}
