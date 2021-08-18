package cdm.event.common.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.Quantity;
import cdm.base.math.functions.Create_Quantity;
import cdm.base.math.functions.Create_UnitType;
import cdm.event.common.BusinessEvent;
import cdm.event.common.BusinessEvent.BusinessEventBuilder;
import cdm.event.common.ContractDetails;
import cdm.event.common.StockSplitInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.Create_PriceChangePrimitive;
import cdm.event.common.functions.Create_QuantityChangePrimitive;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.observable.common.functions.NoOfUnits;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(StockSplit.StockSplitDefault.class)
public abstract class StockSplit implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_PriceChangePrimitive create_PriceChangePrimitive;
	@Inject protected Create_Quantity create_Quantity;
	@Inject protected Create_QuantityChangePrimitive create_QuantityChangePrimitive;
	@Inject protected Create_UnitType create_UnitType;
	@Inject protected NoOfUnits noOfUnits;

	/**
	* @param instruction 
	* @return businessEvent 
	*/
	public BusinessEvent evaluate(StockSplitInstruction instruction) {
		// pre-conditions
		
			assert
				exists(MapperS.of(instruction).<TradeState>map("getTradeState", _stockSplitInstruction -> _stockSplitInstruction.getTradeState()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails())).get()
				: "";
		
		BusinessEvent.BusinessEventBuilder businessEventHolder = doEvaluate(instruction);
		BusinessEvent.BusinessEventBuilder businessEvent = assignOutput(businessEventHolder, instruction);
		
		if (businessEvent!=null) objectValidator.validateAndFailOnErorr(BusinessEvent.class, businessEvent);
		return businessEvent;
	}
	
	private BusinessEvent.BusinessEventBuilder assignOutput(BusinessEvent.BusinessEventBuilder businessEvent, StockSplitInstruction instruction) {
		businessEvent
			.getOrCreatePrimitives(0)
			.setQuantityChange(MapperS.of(create_QuantityChangePrimitive.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", _stockSplitInstruction -> _stockSplitInstruction.getTradeState()).get(), MapperC.of(MapperS.of(postSplitNumberOfShares(instruction).get())).getMulti())).get())
		;
		businessEvent
			.getOrCreatePrimitives(0)
			.setTermsChange(MapperS.of(create_PriceChangePrimitive.evaluate(MapperS.of(instruction).<TradeState>map("getTradeState", _stockSplitInstruction -> _stockSplitInstruction.getTradeState()).get(), MapperS.of(postSplitPrice(instruction).get()).get())).get())
		;
		return businessEvent;
	}

	protected abstract BusinessEvent.BusinessEventBuilder doEvaluate(StockSplitInstruction instruction);
	
	
	protected Mapper<BigDecimal> preSplitNumberOfShares(StockSplitInstruction instruction) {
		return MapperS.of(noOfUnits.evaluate(MapperS.of(MapperS.of(instruction).<TradeState>map("getTradeState", _stockSplitInstruction -> _stockSplitInstruction.getTradeState()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).getMulti()));
	}
	
	protected Mapper<? extends Quantity> postSplitNumberOfShares(StockSplitInstruction instruction) {
		return MapperS.of(create_Quantity.evaluate(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(preSplitNumberOfShares(instruction).get()), MapperS.of(instruction).<BigDecimal>map("getAdjustmentRatio", _stockSplitInstruction -> _stockSplitInstruction.getAdjustmentRatio())).get(), MapperS.of(create_UnitType.evaluate(null, MapperS.of(FinancialUnitEnum.SHARE).get())).get()));
	}
	
	protected Mapper<BigDecimal> preSplitPrices(StockSplitInstruction instruction) {
		return MapperS.of(instruction).<TradeState>map("getTradeState", _stockSplitInstruction -> _stockSplitInstruction.getTradeState()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> postSplitPrice(StockSplitInstruction instruction) {
		return MapperMaths.<BigDecimal, BigDecimal, BigDecimal>divide(MapperS.of(preSplitPrices(instruction).get()), MapperS.of(instruction).<BigDecimal>map("getAdjustmentRatio", _stockSplitInstruction -> _stockSplitInstruction.getAdjustmentRatio()));
	}
	public static final class StockSplitDefault extends StockSplit {
		@Override
		protected  BusinessEvent.BusinessEventBuilder doEvaluate(StockSplitInstruction instruction) {
			return BusinessEvent.builder();
		}
	}
}
