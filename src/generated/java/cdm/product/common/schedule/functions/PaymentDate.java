package cdm.product.common.schedule.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.product.asset.InterestRatePayout;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;


@ImplementedBy(PaymentDate.PaymentDateDefault.class)
public abstract class PaymentDate implements RosettaFunction {

	/**
	* @param economicTerms 
	* @return result 
	*/
	public Date evaluate(EconomicTerms economicTerms) {
		
		Date resultHolder = doEvaluate(economicTerms);
		Date result = assignOutput(resultHolder, economicTerms);
		
		return result;
	}
	
	private Date assignOutput(Date result, EconomicTerms economicTerms) {
		result = MapperS.of(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>mapC("getInterestRatePayout", _payout -> _payout.getInterestRatePayout()).get()).<AdjustableDate>map("getPaymentDate", _interestRatePayout -> _interestRatePayout.getPaymentDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()).get();
		return result;
	}

	protected abstract Date doEvaluate(EconomicTerms economicTerms);
	
	public static final class PaymentDateDefault extends PaymentDate {
		@Override
		protected  Date doEvaluate(EconomicTerms economicTerms) {
			return null;
		}
	}
}
