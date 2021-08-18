package cdm.event.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.event.common.BusinessEvent;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferPrimitive;
import cdm.event.common.Transfers;
import cdm.event.common.functions.TransfersForDate;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_CashAndSecurityTransfer.Qualify_CashAndSecurityTransferDefault.class)
public abstract class Qualify_CashAndSecurityTransfer implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected TransfersForDate transfersForDate;

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
		is_event = exists(MapperS.of(transfersForDate(businessEvent).get()).<Transfer>mapC("getTransfers", _transfers -> _transfers.getTransfers()).<Quantity>map("getQuantity", _transfer -> _transfer.getQuantity()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue())).and(exists(MapperS.of(transfersForDate(businessEvent).get()).<Transfer>mapC("getTransfers", _transfers -> _transfers.getTransfers()).<Quantity>map("getQuantity", _transfer -> _transfer.getQuantity()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FinancialUnitEnum>map("getFinancialUnit", _unitType -> _unitType.getFinancialUnit()))).and(areEqual(MapperS.of(MapperS.of(transfersForDate(businessEvent).get()).<Transfer>mapC("getTransfers", _transfers -> _transfers.getTransfers()).resultCount()), MapperS.of(Integer.valueOf(2)), CardinalityOperator.All)).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	
	protected Mapper<? extends Transfers> transfersForDate(BusinessEvent businessEvent) {
		return MapperS.of(transfersForDate.evaluate(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()).<TradeState>map("getAfter", _transferPrimitive -> _transferPrimitive.getAfter()).<Transfer>mapC("getTransferHistory", _tradeState -> _tradeState.getTransferHistory()).getMulti(), MapperS.of(businessEvent).<Date>map("getEventDate", _businessEvent -> _businessEvent.getEventDate()).get()));
	}
	public static final class Qualify_CashAndSecurityTransferDefault extends Qualify_CashAndSecurityTransfer {
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
