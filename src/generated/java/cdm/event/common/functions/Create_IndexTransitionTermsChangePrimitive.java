package cdm.event.common.functions;

import cdm.event.common.IndexTransitionInstruction;
import cdm.event.common.TermsChangePrimitive;
import cdm.event.common.TermsChangePrimitive.TermsChangePrimitiveBuilder;
import cdm.event.common.TradeState;
import cdm.event.common.functions.UpdateSpreadAdjustmentAndRateOptionForEachPriceQuantity;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_IndexTransitionTermsChangePrimitive.Create_IndexTransitionTermsChangePrimitiveDefault.class)
public abstract class Create_IndexTransitionTermsChangePrimitive implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected UpdateSpreadAdjustmentAndRateOptionForEachPriceQuantity updateSpreadAdjustmentAndRateOptionForEachPriceQuantity;

	/**
	* @param tradeState Specifies the trade to be updated.
	* @param instruction Specifies the instructions containing the floating rate index, spread adjustment for each leg to be updated, and the effective date.
	* @return termsChangePrimitive Specifies the resulting term change primitive.
	*/
	public TermsChangePrimitive evaluate(TradeState tradeState, IndexTransitionInstruction instruction) {
		
		TermsChangePrimitive.TermsChangePrimitiveBuilder termsChangePrimitiveHolder = doEvaluate(tradeState, instruction);
		TermsChangePrimitive.TermsChangePrimitiveBuilder termsChangePrimitive = assignOutput(termsChangePrimitiveHolder, tradeState, instruction);
		
		if (termsChangePrimitive!=null) objectValidator.validateAndFailOnErorr(TermsChangePrimitive.class, termsChangePrimitive);
		return termsChangePrimitive;
	}
	
	private TermsChangePrimitive.TermsChangePrimitiveBuilder assignOutput(TermsChangePrimitive.TermsChangePrimitiveBuilder termsChangePrimitive, TradeState tradeState, IndexTransitionInstruction instruction) {
		termsChangePrimitive
			.setAfter(MapperS.of(updateSpreadAdjustmentAndRateOptionForEachPriceQuantity.evaluate(MapperS.of(tradeState).get(), MapperS.of(instruction).<PriceQuantity>mapC("getPriceQuantity", _indexTransitionInstruction -> _indexTransitionInstruction.getPriceQuantity()).getMulti())).get())
		;
		termsChangePrimitive
			.setBeforeValue(MapperS.of(tradeState).get())
		;
		return termsChangePrimitive;
	}

	protected abstract TermsChangePrimitive.TermsChangePrimitiveBuilder doEvaluate(TradeState tradeState, IndexTransitionInstruction instruction);
	
	public static final class Create_IndexTransitionTermsChangePrimitiveDefault extends Create_IndexTransitionTermsChangePrimitive {
		@Override
		protected  TermsChangePrimitive.TermsChangePrimitiveBuilder doEvaluate(TradeState tradeState, IndexTransitionInstruction instruction) {
			return TermsChangePrimitive.builder();
		}
	}
}
