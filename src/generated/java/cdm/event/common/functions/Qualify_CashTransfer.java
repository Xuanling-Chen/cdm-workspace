package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.event.common.BusinessEvent;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferPrimitive;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_CashTransfer.Qualify_CashTransferDefault.class)
public abstract class Qualify_CashTransfer implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {

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
		is_event = areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All).and(exists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()))).and(areEqual(MapperS.of(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()).<TradeState>map("getAfter", _transferPrimitive -> _transferPrimitive.getAfter()).<Transfer>mapC("getTransferHistory", _tradeState -> _tradeState.getTransferHistory()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All)).and(onlyExists(Arrays.asList(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()).<TradeState>map("getAfter", _transferPrimitive -> _transferPrimitive.getAfter()).<Transfer>mapC("getTransferHistory", _tradeState -> _tradeState.getTransferHistory()).<Quantity>map("getQuantity", _transfer -> _transfer.getQuantity()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue())))).and(notEqual(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()).<TradeState>map("getAfter", _transferPrimitive -> _transferPrimitive.getAfter()).<Transfer>mapC("getTransferHistory", _tradeState -> _tradeState.getTransferHistory()).<FieldWithMetaIdentifier>mapC("getIdentifier", _transfer -> _transfer.getIdentifier()).map("getMeta", a->a.getMeta()).map("getScheme", a->a.getScheme()), MapperS.of("DTCCCashflowId"), CardinalityOperator.All)).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	public static final class Qualify_CashTransferDefault extends Qualify_CashTransfer {
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
