package cdm.event.common.functions;

import cdm.event.common.BusinessEvent;
import cdm.event.common.ContractFormationPrimitive;
import cdm.event.common.PrimitiveEvent;
import cdm.event.workflow.TradeWarehouseWorkflow;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_TradeWarehousePositionNotification.Qualify_TradeWarehousePositionNotificationDefault.class)
public abstract class Qualify_TradeWarehousePositionNotification implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {

	/**
	* @param businessEvent 
	* @return is_event 
	*/
	public Boolean evaluate(BusinessEvent businessEvent) {
		
		Boolean is_eventHolder = doEvaluate(businessEvent);
		Boolean is_event = assignOutput(is_eventHolder, businessEvent);
		
		return is_event;
	}
	
	private Boolean assignOutput(Boolean is_event, BusinessEvent businessEvent) {
		is_event = exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<ContractFormationPrimitive>map("getContractFormation", _primitiveEvent -> _primitiveEvent.getContractFormation())).and(exists(MapperS.of(businessEvent).<TradeWarehouseWorkflow>map("getTradeWarehouseWorkflow", _businessEvent -> _businessEvent.getTradeWarehouseWorkflow()))).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	public static final class Qualify_TradeWarehousePositionNotificationDefault extends Qualify_TradeWarehousePositionNotification {
		@Override
		protected  Boolean doEvaluate(BusinessEvent businessEvent) {
			return null;
		}
	}
	
	@Override
	public String getNamePrefix() {
		return "Qualify";
	}
}
