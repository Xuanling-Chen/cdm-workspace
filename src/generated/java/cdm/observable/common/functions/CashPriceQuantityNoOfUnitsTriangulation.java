package cdm.observable.common.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.observable.common.functions.CurrencyAmount;
import cdm.observable.common.functions.NoOfUnits;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(CashPriceQuantityNoOfUnitsTriangulation.CashPriceQuantityNoOfUnitsTriangulationDefault.class)
public abstract class CashPriceQuantityNoOfUnitsTriangulation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CurrencyAmount currencyAmount;
	@Inject protected NoOfUnits noOfUnits;

	/**
	* @param priceQuantity 
	* @return success 
	*/
	public Boolean evaluate(List<? extends PriceQuantity> priceQuantity) {
		
		Boolean successHolder = doEvaluate(priceQuantity);
		Boolean success = assignOutput(successHolder, priceQuantity);
		
		return success;
	}
	
	private Boolean assignOutput(Boolean success, List<? extends PriceQuantity> priceQuantity) {
		success = com.rosetta.model.lib.mapper.MapperUtils.toComparisonResult(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (exists(MapperTree.and(MapperTree.and(MapperTree.of(MapperS.of(cashPrice(priceQuantity).get())), MapperTree.of(MapperS.of(noOfUnits(priceQuantity).get()))), MapperTree.of(MapperS.of(notional(priceQuantity).get())))).get()) {
					return areEqual(MapperMaths.<BigDecimal, BigDecimal, BigDecimal>multiply(MapperS.of(cashPrice(priceQuantity).get()), MapperS.of(noOfUnits(priceQuantity).get())), MapperS.of(notional(priceQuantity).get()), CardinalityOperator.All);
				}
		else {
					return MapperS.ofNull();
				}
		})).get();
		return success;
	}

	protected abstract Boolean doEvaluate(List<? extends PriceQuantity> priceQuantity);
	
	
	protected Mapper<BigDecimal> notional(List<? extends PriceQuantity> priceQuantity) {
		return MapperS.of(currencyAmount.evaluate(MapperC.of(priceQuantity).getMulti(), null));
	}
	
	protected Mapper<BigDecimal> noOfUnits(List<? extends PriceQuantity> priceQuantity) {
		return MapperS.of(noOfUnits.evaluate(MapperC.of(priceQuantity).getMulti()));
	}
	
	protected Mapper<BigDecimal> cashPrices(List<? extends PriceQuantity> priceQuantity) {
		return MapperC.of(priceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount());
	}
	
	protected Mapper<BigDecimal> cashPrice(List<? extends PriceQuantity> priceQuantity) {
		return MapperS.of(cashPrices(priceQuantity).get());
	}
	public static final class CashPriceQuantityNoOfUnitsTriangulationDefault extends CashPriceQuantityNoOfUnitsTriangulation {
		@Override
		protected  Boolean doEvaluate(List<? extends PriceQuantity> priceQuantity) {
			return null;
		}
	}
}
