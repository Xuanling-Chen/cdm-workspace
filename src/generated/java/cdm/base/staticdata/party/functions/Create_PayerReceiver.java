package cdm.base.staticdata.party.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import java.util.Arrays;


@ImplementedBy(Create_PayerReceiver.Create_PayerReceiverDefault.class)
public abstract class Create_PayerReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param payer 
	* @param receiver 
	* @return payerReceiver 
	*/
	public PayerReceiver evaluate(CounterpartyRoleEnum payer, CounterpartyRoleEnum receiver) {
		
		PayerReceiver.PayerReceiverBuilder payerReceiverHolder = doEvaluate(payer, receiver);
		PayerReceiver.PayerReceiverBuilder payerReceiver = assignOutput(payerReceiverHolder, payer, receiver);
		
		if (payerReceiver!=null) objectValidator.validateAndFailOnErorr(PayerReceiver.class, payerReceiver);
		return payerReceiver;
	}
	
	private PayerReceiver.PayerReceiverBuilder assignOutput(PayerReceiver.PayerReceiverBuilder payerReceiver, CounterpartyRoleEnum payer, CounterpartyRoleEnum receiver) {
		payerReceiver
			.setPayer(MapperS.of(payer).get())
		;
		payerReceiver
			.setReceiver(MapperS.of(receiver).get())
		;
		return payerReceiver;
	}

	protected abstract PayerReceiver.PayerReceiverBuilder doEvaluate(CounterpartyRoleEnum payer, CounterpartyRoleEnum receiver);
	
	public static final class Create_PayerReceiverDefault extends Create_PayerReceiver {
		@Override
		protected  PayerReceiver.PayerReceiverBuilder doEvaluate(CounterpartyRoleEnum payer, CounterpartyRoleEnum receiver) {
			return PayerReceiver.builder();
		}
	}
}
