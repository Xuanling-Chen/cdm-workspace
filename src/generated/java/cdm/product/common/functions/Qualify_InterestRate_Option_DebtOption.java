package cdm.product.common.functions;

import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.IQualifyFunctionExtension;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(Qualify_InterestRate_Option_DebtOption.Qualify_InterestRate_Option_DebtOptionDefault.class)
public abstract class Qualify_InterestRate_Option_DebtOption implements RosettaFunction, IQualifyFunctionExtension<EconomicTerms> {

	/**
	* @param economicTerms 
	* @return is_product 
	*/
	public Boolean evaluate(EconomicTerms economicTerms) {
		
		Boolean is_productHolder = doEvaluate(economicTerms);
		Boolean is_product = assignOutput(is_productHolder, economicTerms);
		
		return is_product;
	}
	
	private Boolean assignOutput(Boolean is_product, EconomicTerms economicTerms) {
		is_product = onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()))).or(onlyExists(Arrays.asList(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout()), MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow())))).and(areEqual(MapperS.of(MapperS.of(optionPayout(economicTerms).get()).<Product>map("getUnderlier", _optionPayout -> _optionPayout.getUnderlier()).<Security>map("getSecurity", _product -> _product.getSecurity()).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()).get()), MapperS.of(SecurityTypeEnum.DEBT), CardinalityOperator.All)).get();
		return is_product;
	}

	protected abstract Boolean doEvaluate(EconomicTerms economicTerms);
	
	
	protected Mapper<? extends OptionPayout> optionPayout(EconomicTerms economicTerms) {
		return MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>mapC("getOptionPayout", _payout -> _payout.getOptionPayout());
	}
	public static final class Qualify_InterestRate_Option_DebtOptionDefault extends Qualify_InterestRate_Option_DebtOption {
		@Override
		protected  Boolean doEvaluate(EconomicTerms economicTerms) {
			return null;
		}
	}
	
	@Override
	public String getNamePrefix() {
		return "Qualify";
	}
}
