package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.functions.DeductAmountForEachMatchingQuantity;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ReturnInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_QuantityChangePrimitive;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_Return.Create_ReturnDefault.class)
public abstract class Create_Return implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_QuantityChangePrimitive create_QuantityChangePrimitive;
	@Inject protected DeductAmountForEachMatchingQuantity deductAmountForEachMatchingQuantity;

	/**
	* @param tradeState Specifies a previously formed contractual product with a Security Finance payout. It is required that the description of the contractual product be contained within the previous business event, i.e. its lineage must contain the formation of a contractual product.
	* @param returnInstruction Specifies the information required to fully return the Stock Loan in accordance with the economic terms of the contractual product.
	* @param returnDate Specifies the date of the full return.
	* @return returnEvent Produces the business event composed of primitive events describing the transfer and termination, as a result of the input return instruction.
	*/
	public BusinessEvent evaluate(TradeState tradeState, ReturnInstruction returnInstruction, Date returnDate) {
		
		BusinessEvent.BusinessEventBuilder returnEventHolder = doEvaluate(tradeState, returnInstruction, returnDate);
		BusinessEvent.BusinessEventBuilder returnEvent = assignOutput(returnEventHolder, tradeState, returnInstruction, returnDate);
		
		if (returnEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, returnEvent);
		return returnEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder returnEvent, TradeState tradeState, ReturnInstruction returnInstruction, Date returnDate) {
		returnEvent
			.getOrCreatePrimitives(0)
			.setQuantityChange(MapperS.of(create_QuantityChangePrimitive.evaluate(MapperS.of(tradeState).get(), MapperC.of(deductAmountForEachMatchingQuantity.evaluate(MapperS.of(tradableProduct(tradeState, returnInstruction, returnDate).get()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).getMulti(), MapperS.of(returnInstruction).<Quantity>mapC("getQuantity", _returnInstruction -> _returnInstruction.getQuantity()).getMulti())).getMulti())).get())
		;
		returnEvent
			.setEventDate(MapperS.of(returnDate).get())
		;
		return returnEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, ReturnInstruction returnInstruction, Date returnDate);
	
	
	protected Mapper<? extends TradableProduct> tradableProduct(TradeState tradeState, ReturnInstruction returnInstruction, Date returnDate) {
		return MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct());
	}
	public static final class Create_ReturnDefault extends Create_Return {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(TradeState tradeState, ReturnInstruction returnInstruction, Date returnDate) {
			return BusinessEvent.builder();
		}
	}
}
