package cdm.event.common.functions;

import cdm.base.staticdata.asset.common.Security;
import cdm.base.staticdata.asset.common.SecurityTypeEnum;
import cdm.legalagreement.master.EquitySwapMasterConfirmation2018;
import cdm.product.asset.ReturnTypeEnum;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.EquityPayout;
import cdm.product.template.EquityPayout.EquityPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(NewSingleNameEquityPayout.NewSingleNameEquityPayoutDefault.class)
public abstract class NewSingleNameEquityPayout implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param security 
	* @param masterConfirmation 
	* @return equityPayout 
	*/
	public EquityPayout evaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
		// pre-conditions
		
			assert
				areEqual(MapperS.of(security).<SecurityTypeEnum>map("getSecurityType", _security -> _security.getSecurityType()), MapperS.of(SecurityTypeEnum.EQUITY), CardinalityOperator.All).get()
				: "Security must be equity (single name).";
		
		EquityPayout.EquityPayoutBuilder equityPayoutHolder = doEvaluate(security, masterConfirmation);
		EquityPayout.EquityPayoutBuilder equityPayout = assignOutput(equityPayoutHolder, security, masterConfirmation);
		
		if (equityPayout!=null) objectValidator.validateAndFailOnErorr(EquityPayout.class, equityPayout);
		return equityPayout;
	}
	
	private EquityPayout.EquityPayoutBuilder assignOutput(EquityPayout.EquityPayoutBuilder equityPayout, Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
		equityPayout
			.setReturnType(MapperS.of(masterConfirmation).<ReturnTypeEnum>map("getTypeOfSwapElection", _equitySwapMasterConfirmation2018 -> _equitySwapMasterConfirmation2018.getTypeOfSwapElection()).get())
		;
		equityPayout
			.setCalculationPeriodDates(MapperS.of(masterConfirmation).<CalculationPeriodDates>map("getEquityCalculationPeriod", _equitySwapMasterConfirmation2018 -> _equitySwapMasterConfirmation2018.getEquityCalculationPeriod()).get())
		;
		equityPayout
			.setPaymentDates(MapperS.of(masterConfirmation).<PaymentDates>map("getEquityCashSettlementDates", _equitySwapMasterConfirmation2018 -> _equitySwapMasterConfirmation2018.getEquityCashSettlementDates()).get())
		;
		equityPayout
			.setSettlementTerms(MapperS.of(masterConfirmation).<SettlementTerms>map("getSettlementTerms", _equitySwapMasterConfirmation2018 -> _equitySwapMasterConfirmation2018.getSettlementTerms()).get())
		;
		return equityPayout;
	}

	protected abstract EquityPayout.EquityPayoutBuilder doEvaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation);
	
	public static final class NewSingleNameEquityPayoutDefault extends NewSingleNameEquityPayout {
		@Override
		protected  EquityPayout.EquityPayoutBuilder doEvaluate(Security security, EquitySwapMasterConfirmation2018 masterConfirmation) {
			return EquityPayout.builder();
		}
	}
}
