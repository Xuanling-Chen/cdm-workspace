package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.IndexTransitionInstruction;
import cdm.event.common.IntentEnum;
import cdm.event.common.TermsChangePrimitive;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.functions.Create_IndexTransitionTermsChangePrimitive;
import cdm.event.common.functions.Create_TransferPrimitiveFromTransfer;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_IndexTransition.Create_IndexTransitionDefault.class)
public abstract class Create_IndexTransition implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_IndexTransitionTermsChangePrimitive create_IndexTransitionTermsChangePrimitive;
	@Inject protected Create_TransferPrimitiveFromTransfer create_TransferPrimitiveFromTransfer;

	/**
	* @param tradeState Specifies the trade to be updated.
	* @param instruction Specifies the instructions containing the floating rate index, spread adjustment for each leg to be updated, and the effective date.
	* @param date Specifies the event date.
	* @return businessEvent Specifies the resulting business event which will be composed of up to two primitive events: TermsChangePrimitive and optionally a (cash) TransferPrimitive.
	*/
	public BusinessEvent evaluate(TradeState tradeState, IndexTransitionInstruction instruction, Date date) {
		
		BusinessEvent.BusinessEventBuilder businessEventHolder = doEvaluate(tradeState, instruction, date);
		BusinessEvent.BusinessEventBuilder businessEvent = assignOutput(businessEventHolder, tradeState, instruction, date);
		
		if (businessEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, businessEvent);
		return businessEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder businessEvent, TradeState tradeState, IndexTransitionInstruction instruction, Date date) {
		businessEvent
			.getOrCreatePrimitives(0)
			.setTermsChange(MapperS.of(termsChangePrimitive(tradeState, instruction, date).get()).get())
		;
		businessEvent
			.getOrCreatePrimitives(0)
			.setTransfer(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(instruction).<Transfer>map("getCashTransfer", _indexTransitionInstruction -> _indexTransitionInstruction.getCashTransfer())).get()) {
						return MapperS.of(create_TransferPrimitiveFromTransfer.evaluate(MapperS.of(termsChangePrimitive(tradeState, instruction, date).get()).<TradeState>map("getAfter", _termsChangePrimitive -> _termsChangePrimitive.getAfter()).get(), MapperS.of(instruction).<Transfer>map("getCashTransfer", _indexTransitionInstruction -> _indexTransitionInstruction.getCashTransfer()).get()));
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		businessEvent
			.setIntent(MapperS.of(IntentEnum.INDEX_TRANSITION).get())
		;
		businessEvent
			.setEventDate(MapperS.of(instruction).<Date>map("getEffectiveDate", _indexTransitionInstruction -> _indexTransitionInstruction.getEffectiveDate()).get())
		;
		return businessEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, IndexTransitionInstruction instruction, Date date);
	
	
	protected Mapper<? extends TermsChangePrimitive> termsChangePrimitive(TradeState tradeState, IndexTransitionInstruction instruction, Date date) {
		return MapperS.of(create_IndexTransitionTermsChangePrimitive.evaluate(MapperS.of(tradeState).get(), MapperS.of(instruction).get()));
	}
	public static final class Create_IndexTransitionDefault extends Create_IndexTransition {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, IndexTransitionInstruction instruction, Date date) {
			return BusinessEvent.builder();
		}
	}
}
