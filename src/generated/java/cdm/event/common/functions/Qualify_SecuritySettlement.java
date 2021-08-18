package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier;
import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.event.common.BusinessEvent;
import cdm.event.common.PrimitiveEvent;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferPrimitive;
import cdm.event.common.functions.FilterCashTransfers;
import cdm.event.common.functions.FilterSecurityTransfers;
import cdm.event.common.functions.TransfersForDate;
import cdm.observable.asset.Observable;
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
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

@ImplementedBy(Qualify_SecuritySettlement.Qualify_SecuritySettlementDefault.class)
public abstract class Qualify_SecuritySettlement implements RosettaFunction, IQualifyFunctionExtension<BusinessEvent> {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterCashTransfers filterCashTransfers;
	@Inject protected FilterSecurityTransfers filterSecurityTransfers;
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
		is_event = onlyExists(Arrays.asList(MapperS.of(transfers(businessEvent).get()).<Observable>map("getObservable", _transfer -> _transfer.getObservable()).<FieldWithMetaProductIdentifier>mapC("getProductIdentifier", _observable -> _observable.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue()))).and(onlyExists(Arrays.asList(MapperS.of(transfers(businessEvent).get()).<Quantity>map("getQuantity", _transfer -> _transfer.getQuantity()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue())))).and(areEqual(MapperS.of(MapperS.of(filterCashTransfers.evaluate(MapperS.of(transfers(businessEvent).get()).getMulti())).<Transfer>mapC("getTransfers", _transfers -> _transfers.getTransfers()).get()).<PartyReferencePayerReceiver>map("getPayerReceiver", _transfer -> _transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getPayerPartyReference", _partyReferencePayerReceiver -> _partyReferencePayerReceiver.getPayerPartyReference()).<Party>map("getValue", _f->_f.getValue()), MapperS.of(MapperS.of(filterSecurityTransfers.evaluate(MapperS.of(transfers(businessEvent).get()).getMulti())).<Transfer>mapC("getTransfers", _transfers -> _transfers.getTransfers()).get()).<PartyReferencePayerReceiver>map("getPayerReceiver", _transfer -> _transfer.getPayerReceiver()).<ReferenceWithMetaParty>map("getReceiverPartyReference", _partyReferencePayerReceiver -> _partyReferencePayerReceiver.getReceiverPartyReference()).<Party>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).and(notExists(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<QuantityChangePrimitive>map("getQuantityChange", _primitiveEvent -> _primitiveEvent.getQuantityChange()))).get();
		return is_event;
	}

	protected abstract Boolean doEvaluate(BusinessEvent businessEvent);
	
	
	protected Mapper<? extends Transfer> transfers(BusinessEvent businessEvent) {
		return MapperS.of(transfersForDate.evaluate(MapperS.of(businessEvent).<PrimitiveEvent>mapC("getPrimitives", _businessEvent -> _businessEvent.getPrimitives()).<TransferPrimitive>map("getTransfer", _primitiveEvent -> _primitiveEvent.getTransfer()).<TradeState>map("getAfter", _transferPrimitive -> _transferPrimitive.getAfter()).<Transfer>mapC("getTransferHistory", _tradeState -> _tradeState.getTransferHistory()).getMulti(), MapperS.of(businessEvent).<Date>map("getEventDate", _businessEvent -> _businessEvent.getEventDate()).get())).<Transfer>mapC("getTransfers", _transfers -> _transfers.getTransfers());
	}
	public static final class Qualify_SecuritySettlementDefault extends Qualify_SecuritySettlement {
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
