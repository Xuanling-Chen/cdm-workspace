package cdm.event.common.functions;

import cdm.base.staticdata.asset.common.Security;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TransferInstruction;
import cdm.event.common.functions.Create_TransferPrimitive;
import cdm.event.common.functions.SecurityTransferInstruction;
import cdm.event.common.metafields.ReferenceWithMetaTrade;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.WorkflowStep.WorkflowStepBuilder;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;
import java.util.Optional;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Settle.SettleDefault.class)
public abstract class Settle implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_TransferPrimitive create_TransferPrimitive;
	@Inject protected SecurityTransferInstruction securityTransferInstruction;

	/**
	* @param tradeState Execution to be settled.
	* @param previousEvent Previous event for lineage purposes.
	* @param date 
	* @return transferEvent Transfer event composed of cash and security components created from a security settled via delivery vs payment.
	*/
	public WorkflowStep evaluate(TradeState tradeState, WorkflowStep previousEvent, Date date) {
		// pre-conditions
		
			assert
				exists(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<Security>map("getSecurity", _product -> _product.getSecurity())).get()
				: "";
		
		WorkflowStep.WorkflowStepBuilder transferEventHolder = doEvaluate(tradeState, previousEvent, date);
		WorkflowStep.WorkflowStepBuilder transferEvent = assignOutput(transferEventHolder, tradeState, previousEvent, date);
		
		if (transferEvent!=null) objectValidator.validateAndFailOnErorr(WorkflowStep.class, transferEvent);
		return transferEvent;
	}
	
	private WorkflowStep.WorkflowStepBuilder assignOutput(WorkflowStep.WorkflowStepBuilder transferEvent, TradeState tradeState, WorkflowStep previousEvent, Date date) {
		transferEvent
			.getOrCreateBusinessEvent()
			.getOrCreatePrimitives(0)
			.setTransfer(MapperS.of(create_TransferPrimitive.evaluate(MapperS.of(tradeState).get(), MapperS.of(transferInstruction(tradeState, previousEvent, date).get()).get(), MapperS.of(date).get())).get())
		;
		transferEvent
			.getOrCreateLineage()
			.addEventReference(ReferenceWithMetaWorkflowStep.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(previousEvent).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		transferEvent
			.getOrCreateLineage()
			.addTradeReference(ReferenceWithMetaTrade.builder().setGlobalReference(
					Optional.ofNullable(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).get())
						.map(r -> r.getMeta())
						.map(m -> m.getGlobalKey())
						.orElse(null)
				).build()
			)
		;
		return transferEvent;
	}

	protected abstract WorkflowStep.WorkflowStepBuilder doEvaluate(TradeState tradeState, WorkflowStep previousEvent, Date date);
	
	
	protected Mapper<? extends TransferInstruction> transferInstruction(TradeState tradeState, WorkflowStep previousEvent, Date date) {
		return MapperS.of(securityTransferInstruction.evaluate(MapperS.of(tradeState).get()));
	}
	public static final class SettleDefault extends Settle {
		@Override
		protected  WorkflowStep.WorkflowStepBuilder doEvaluate(TradeState tradeState, WorkflowStep previousEvent, Date date) {
			return WorkflowStep.builder();
		}
	}
}
