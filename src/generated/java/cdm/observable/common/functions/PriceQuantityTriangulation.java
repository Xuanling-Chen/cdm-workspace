package cdm.observable.common.functions;

import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.PriceTypeEnum;
import cdm.observable.asset.metafields.FieldWithMetaPrice;
import cdm.observable.common.functions.CashPriceQuantityNoOfUnitsTriangulation;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperators.contains;

@ImplementedBy(PriceQuantityTriangulation.PriceQuantityTriangulationDefault.class)
public abstract class PriceQuantityTriangulation implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected CashPriceQuantityNoOfUnitsTriangulation cashPriceQuantityNoOfUnitsTriangulation;

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
		success = com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
		if (contains(MapperC.of(priceQuantity).<FieldWithMetaPrice>mapC("getPrice", _priceQuantity -> _priceQuantity.getPrice()).<Price>map("getValue", _f->_f.getValue()).<PriceTypeEnum>map("getPriceType", _price -> _price.getPriceType()), MapperS.of(PriceTypeEnum.CASH_PRICE)).get()) {
					return MapperS.of(cashPriceQuantityNoOfUnitsTriangulation.evaluate(MapperC.of(priceQuantity).getMulti()));
				}
		else {
					return MapperS.of(Boolean.valueOf(true));
				}
		}).get();
		return success;
	}

	protected abstract Boolean doEvaluate(List<? extends PriceQuantity> priceQuantity);
	
	public static final class PriceQuantityTriangulationDefault extends PriceQuantityTriangulation {
		@Override
		protected  Boolean doEvaluate(List<? extends PriceQuantity> priceQuantity) {
			return null;
		}
	}
}
