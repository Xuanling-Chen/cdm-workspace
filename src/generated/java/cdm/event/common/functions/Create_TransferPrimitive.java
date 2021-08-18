package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.TransferInstruction;
import cdm.event.common.TransferPrimitive;
import cdm.event.common.TransferPrimitive.TransferPrimitiveBuilder;
import cdm.event.common.functions.Create_CashTransfer;
import cdm.event.common.functions.Create_SecurityFinanceTransfer;
import cdm.event.common.functions.Create_SecurityTransfer;
import cdm.event.position.PositionStatusEnum;
import cdm.observable.asset.PriceQuantity;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.TradeLot;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
import cdm.product.template.SecurityFinancePayout;
import cdm.product.template.SecurityPayout;
import cdm.product.template.TradableProduct;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.math.BigDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_TransferPrimitive.Create_TransferPrimitiveDefault.class)
public abstract class Create_TransferPrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CashTransfer create_CashTransfer;
	@Inject protected Create_SecurityFinanceTransfer create_SecurityFinanceTransfer;
	@Inject protected Create_SecurityTransfer create_SecurityTransfer;

	/**
	* @param tradeState Represents the trade and associated state on which to construct the Transfer data type.
	* @param instruction 
	* @param date Specifies the date the transfer is to take place.
	* @return transfer 
	*/
	public TransferPrimitive evaluate(TradeState tradeState, TransferInstruction instruction, Date date) {
		
		TransferPrimitive.TransferPrimitiveBuilder transferHolder = doEvaluate(tradeState, instruction, date);
		TransferPrimitive.TransferPrimitiveBuilder transfer = assignOutput(transferHolder, tradeState, instruction, date);
		
		if (transfer!=null) objectValidator.validateAndFailOnErorr(TransferPrimitive.class, transfer);
		return transfer;
	}
	
	private TransferPrimitive.TransferPrimitiveBuilder assignOutput(TransferPrimitive.TransferPrimitiveBuilder transfer, TradeState tradeState, TransferInstruction instruction, Date date) {
		transfer
			.setBeforeValue(MapperS.of(tradeState).get())
		;
		transfer
			.setAfter(MapperS.of(tradeState).get())
		;
		transfer
			.getOrCreateAfter()
			.getOrCreateState()
			.setPositionState(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout())).get()) {
						return MapperS.of(positionStatus(tradeState, instruction, date).get());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		transfer
			.getOrCreateAfter()
			.addTransferHistory(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout())).or(exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()))).or(exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout()))).get()) {
						return MapperS.of(create_CashTransfer.evaluate(MapperS.of(tradeState).get(), MapperS.of(instruction).get(), MapperS.of(date).get(), MapperS.of(instruction).<Quantity>map("getQuantity", _transferInstruction -> _transferInstruction.getQuantity()).get()));
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		transfer
			.getOrCreateAfter()
			.addTransferHistory(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<SecurityPayout>mapC("getSecurityPayout", _payout -> _payout.getSecurityPayout())).get()) {
						return MapperS.of(create_SecurityTransfer.evaluate(MapperS.of(tradeState).get(), MapperS.of(date).get(), MapperS.of(instruction).<Quantity>map("getQuantity", _transferInstruction -> _transferInstruction.getQuantity()).get()));
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		transfer
			.getOrCreateAfter()
			.addTransferHistory(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(instruction).<ReferenceWithMetaPayout>map("getPayout", _transferInstruction -> _transferInstruction.getPayout()).<Payout>map("getValue", _f->_f.getValue()).<SecurityFinancePayout>mapC("getSecurityFinancePayout", _payout -> _payout.getSecurityFinancePayout())).get()) {
						return MapperS.of(create_SecurityFinanceTransfer.evaluate(MapperS.of(tradeState).get(), MapperS.of(instruction).get(), MapperS.of(date).get(), MapperS.of(instruction).<Quantity>map("getQuantity", _transferInstruction -> _transferInstruction.getQuantity()).get()));
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		return transfer;
	}

	protected abstract TransferPrimitive.TransferPrimitiveBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date);
	
	
	protected Mapper<PositionStatusEnum> positionStatus(TradeState tradeState, TransferInstruction instruction, Date date) {
		return com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (areEqual(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All).get()) {
					return MapperS.of(PositionStatusEnum.CLOSED);
				}
		else {
					return MapperS.of(PositionStatusEnum.SETTLED);
				}
		});
	}
	public static final class Create_TransferPrimitiveDefault extends Create_TransferPrimitive {
		@Override
		protected  TransferPrimitive.TransferPrimitiveBuilder doEvaluate(TradeState tradeState, TransferInstruction instruction, Date date) {
			return TransferPrimitive.builder();
		}
	}
}
