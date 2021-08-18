package cdm.event.common.functions;

import cdm.base.math.CompareOp;
import cdm.base.math.QuantityGroup;
import cdm.base.math.QuantityGroups;
import cdm.base.math.functions.ListsCompare;
import cdm.event.common.QuantityChangePrimitive;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.common.functions.QuantityChange;
import cdm.event.common.metafields.ReferenceWithMetaTradeState;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(NoQuantityChange.NoQuantityChangeDefault.class)
public abstract class NoQuantityChange implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ListsCompare listsCompare;
	@Inject protected QuantityChange quantityChange;

	/**
	* @param quantityChangePrimitive 
	* @return result 
	*/
	public Boolean evaluate(List<? extends QuantityChangePrimitive> quantityChangePrimitive) {
		
		Boolean resultHolder = doEvaluate(quantityChangePrimitive);
		Boolean result = assignOutput(resultHolder, quantityChangePrimitive);
		
		return result;
	}
	
	private Boolean assignOutput(Boolean result, List<? extends QuantityChangePrimitive> quantityChangePrimitive) {
		result = areEqual(MapperS.of(listsCompare.evaluate(MapperS.of(CompareOp.EQUAL).get(), MapperS.of(beforeQuantity(quantityChangePrimitive).get()).<QuantityGroup>mapC("getQuantityGroups", _quantityGroups -> _quantityGroups.getQuantityGroups()).<BigDecimal>mapC("getAmount", _quantityGroup -> _quantityGroup.getAmount()).getMulti(), MapperS.of(beforeQuantity(quantityChangePrimitive).get()).<QuantityGroup>mapC("getQuantityGroups", _quantityGroups -> _quantityGroups.getQuantityGroups()).<BigDecimal>mapC("getAmount", _quantityGroup -> _quantityGroup.getAmount()).getMulti(), null)), MapperS.of(Boolean.valueOf(true)), CardinalityOperator.All).get();
		return result;
	}

	protected abstract Boolean doEvaluate(List<? extends QuantityChangePrimitive> quantityChangePrimitive);
	
	
	protected Mapper<? extends QuantityGroups> beforeQuantity(List<? extends QuantityChangePrimitive> quantityChangePrimitive) {
		return MapperS.of(quantityChange.evaluate(MapperC.of(quantityChangePrimitive).<ReferenceWithMetaTradeState>map("getBefore", _quantityChangePrimitive -> _quantityChangePrimitive.getBefore()).<TradeState>map("getValue", _f->_f.getValue()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).getMulti()));
	}
	
	protected Mapper<? extends QuantityGroups> afterQuantity(List<? extends QuantityChangePrimitive> quantityChangePrimitive) {
		return MapperS.of(quantityChange.evaluate(MapperC.of(quantityChangePrimitive).<TradeState>map("getAfter", _quantityChangePrimitive -> _quantityChangePrimitive.getAfter()).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).getMulti()));
	}
	public static final class NoQuantityChangeDefault extends NoQuantityChange {
		@Override
		protected  Boolean doEvaluate(List<? extends QuantityChangePrimitive> quantityChangePrimitive) {
			return null;
		}
	}
}
