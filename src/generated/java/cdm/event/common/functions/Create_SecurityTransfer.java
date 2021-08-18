package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaProductIdentifier;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.Transfer.TransferBuilder;
import cdm.observable.asset.Observable;
import cdm.product.common.settlement.SettlementInstructions;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.TransferSettlementEnum;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Create_SecurityTransfer.Create_SecurityTransferDefault.class)
public abstract class Create_SecurityTransfer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState 
	* @param date 
	* @param quantity Specifies quantity amount returned if not the full amount from the TradeState, e.g. partial return
	* @return transfer 
	*/
	public Transfer evaluate(TradeState tradeState, Date date, Quantity quantity) {
		
		Transfer.TransferBuilder transferHolder = doEvaluate(tradeState, date, quantity);
		Transfer.TransferBuilder transfer = assignOutput(transferHolder, tradeState, date, quantity);
		
		// post-conditions

		assert
			com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<Security>map("getSecurity", _product -> _product.getSecurity())).and(areEqual(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<SettlementInstructions>mapC("getSettlementInstructions", _tradableProduct -> _tradableProduct.getSettlementInstructions()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<TransferSettlementEnum>map("getTransferSettlementType", _settlementBase -> _settlementBase.getTransferSettlementType()), MapperS.of(TransferSettlementEnum.DELIVERY_VERSUS_PAYMENT), CardinalityOperator.All)).get()) {
						return onlyExists(Arrays.asList(MapperS.of(transfer).<Quantity>map("getQuantity", _transfer -> _transfer.getQuantity()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()))).and(exists(MapperS.of(transfer).<Observable>map("getObservable", _transfer -> _transfer.getObservable()).<FieldWithMetaProductIdentifier>mapC("getProductIdentifier", _observable -> _observable.getProductIdentifier()).<ProductIdentifier>map("getValue", _f->_f.getValue())));
					}
			else {
						return MapperS.ofNull();
					}
			})).get()
			: "";
		if (transfer!=null) objectValidator.validateAndFailOnErorr(Transfer.class, transfer);
		return transfer;
	}
	
	private Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder transfer, TradeState tradeState, Date date, Quantity quantity) {
		return transfer;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(TradeState tradeState, Date date, Quantity quantity);
	
	public static final class Create_SecurityTransferDefault extends Create_SecurityTransfer {
		@Override
		protected  Transfer.TransferBuilder doEvaluate(TradeState tradeState, Date date, Quantity quantity) {
			return Transfer.builder();
		}
	}
}
