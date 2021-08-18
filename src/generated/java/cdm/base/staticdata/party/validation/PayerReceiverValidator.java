package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.PayerReceiver;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class PayerReceiverValidator implements Validator<PayerReceiver> {

	@Override
	public ValidationResult<PayerReceiver> validate(RosettaPath path, PayerReceiver o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("payer", o.getPayer()!=null ? 1 : 0, 0, 1),
				checkCardinality("payerAncillaryRole", o.getPayerAncillaryRole()!=null ? 1 : 0, 0, 1),
				checkCardinality("payerPartyReference", o.getPayerPartyReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("receiver", o.getReceiver()!=null ? 1 : 0, 0, 1),
				checkCardinality("receiverAncillaryRole", o.getReceiverAncillaryRole()!=null ? 1 : 0, 0, 1),
				checkCardinality("receiverPartyReference", o.getReceiverPartyReference()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PayerReceiver", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PayerReceiver", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
