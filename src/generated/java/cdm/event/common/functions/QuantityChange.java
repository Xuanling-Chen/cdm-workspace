package cdm.event.common.functions;

import cdm.base.math.Quantity;
import cdm.base.math.QuantityGroups;
import cdm.base.math.QuantityGroups.QuantityGroupsBuilder;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaQuantity;
import cdm.event.common.Trade;
import cdm.observable.asset.PriceQuantity;
import cdm.product.common.TradeLot;
import cdm.product.template.TradableProduct;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


@ImplementedBy(QuantityChange.QuantityChangeDefault.class)
public abstract class QuantityChange implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param trade 
	* @return quantityChange 
	*/
	public QuantityGroups evaluate(List<? extends Trade> trade) {
		
		QuantityGroups.QuantityGroupsBuilder quantityChangeHolder = doEvaluate(trade);
		QuantityGroups.QuantityGroupsBuilder quantityChange = assignOutput(quantityChangeHolder, trade);
		
		if (quantityChange!=null) objectValidator.validateAndFailOnErorr(QuantityGroups.class, quantityChange);
		return quantityChange;
	}
	
	private QuantityGroups.QuantityGroupsBuilder assignOutput(QuantityGroups.QuantityGroupsBuilder quantityChange, List<? extends Trade> trade) {
		quantityChange
			.getOrCreateQuantityGroups(0)
			.addAmount(MapperC.of(MapperC.of(MapperS.of(MapperC.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<TradeLot>mapC("getTradeLot", _tradableProduct -> _tradableProduct.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", _tradeLot -> _tradeLot.getPriceQuantity()).<FieldWithMetaQuantity>mapC("getQuantity", _priceQuantity -> _priceQuantity.getQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<String>groupBy(g->new MapperS<>(g).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue())).getMulti()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount())).getMulti())
		;
		return quantityChange;
	}

	protected abstract QuantityGroups.QuantityGroupsBuilder doEvaluate(List<? extends Trade> trade);
	
	public static final class QuantityChangeDefault extends QuantityChange {
		@Override
		protected  QuantityGroups.QuantityGroupsBuilder doEvaluate(List<? extends Trade> trade) {
			return QuantityGroups.builder();
		}
	}
}
